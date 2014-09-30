package proteus.dl.syntax;

import proteus.dl.semantics.*;
import proteus.dl.parser.*;

import java.util.*;
import java.io.*;

public abstract class dLStructure {

	public boolean debug = true;
	public Operator operator;
	public ArrayList<dLStructure> arguments;

        // COLORS! OMG COLORS!
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
        public static final String ANSI_BOLD = "\u001B[1m";


// Constructors
	public dLStructure() {
		operator = null;
		arguments = null;
	}

	public dLStructure( String operator ) {
		this.operator = new Operator( operator );
		arguments = null;
	}

	public dLStructure( Operator operator ) {
		this.operator = operator;
		arguments = null;
	}

	public dLStructure( Operator operator, ArrayList<dLStructure> arguments ) {
		this.operator = operator;
		this.arguments = arguments;
	}

	public dLStructure( String operator, ArrayList<dLStructure> arguments ) {
		this.operator = new Operator( operator );
		this.arguments = arguments;
	}

// Getters and setters
	public Operator getOperator() {
		return this.operator;
	}

	public dLStructure getArgument( int index ) {
		if ( arguments != null ) {
			return arguments.get( index );
		} else {
			return null;
		}
	}

	public ArrayList<dLStructure> getArguments() {
		return arguments;
	}

	public Iterator<dLStructure> getArgumentIterator() {
		return getArguments().iterator();
	}

	public boolean setArgument( int index, dLStructure newArgument ) {
		if ( arguments != null ) {
			arguments.set( index, newArgument );
			return true;
		} else {
			return false;
		}
	}

	public boolean addArgument( dLStructure newArgument ) {
		if ( arguments != null ) {
			arguments.add( newArgument );
			return true;
		} else {
			return false;
		}
	}

	public boolean addArguments( ArrayList<dLStructure> newArgumentList ) {
		if ( arguments != null ) {
			arguments.addAll( newArgumentList );
			return true;
		} else {
			return false;
		}
	}

	public void spawnArguments() {
		arguments = new ArrayList<dLStructure>();
	}

	public boolean operatorEquals( Operator thisOperator ) {
		return getOperator().equals( thisOperator );
	}

	public boolean operatorEquals( String thisOperatorString ) {
		return getOperator().equals( new Operator( thisOperatorString ) );
	}



// clone all the arguments!
	public ArrayList<dLStructure> cloneArguments() {
		ArrayList<dLStructure> newArguments = new ArrayList<>();

		Iterator<dLStructure> argIterator = getArguments().iterator();
		while( argIterator.hasNext() ) {
			newArguments.add( (argIterator.next()).clone() );
		}

		return newArguments;
	}

// Parse a dLStructure from a string
	public static dLStructure parseStructure( String structureString ) throws Exception {
		// returns the dLStructure that exists in the string
		StringReader thisReader = new StringReader( structureString );
		dLLexer thisdLLexer = new dLLexer( thisReader );
		dLParser thisParser = new dLParser( thisdLLexer );

		thisParser.parse();

		return thisParser.parsedStructure;
	}


// Extract assorted bits and pieces
// 1. getVariables
// 2. getBoundVariables
// 3. getFreeVariables
// 4. getDynamicVariables
// 5. containsAnyFreeVariables
// 6. extractContinuousBlocks
// 7. extractFirstHybridProgram

	public Set<RealVariable> getVariables () {
		Set<RealVariable> myVariables = new HashSet<RealVariable>();

		if ( this instanceof RealVariable ) {
			myVariables.add( (RealVariable)this );
		} else if ( arguments != null ) {
			Iterator<dLStructure> childIterator = arguments.iterator();

			while ( childIterator.hasNext() ) {
				myVariables.addAll( childIterator.next().getVariables() );
			}

		}

		return myVariables;
	}

	public Set<RealVariable> getBoundVariables() {
		return new HashSet<RealVariable>();
	}

	public abstract Set<RealVariable> getFreeVariables();
	
	public boolean containsAnyFreeVariables( ArrayList<RealVariable> variables ) {
		Set<RealVariable> freeVars = getFreeVariables();
		int freeVarsCardinality = freeVars.size();
		freeVars.removeAll( variables );

		if ( freeVars.size() < freeVarsCardinality ) {
			return true;
		} else {
			return false;
		}
	}

	public abstract Set<RealVariable> getDynamicVariables();

	public ArrayList<ContinuousProgram> extractContinuousBlocks() {

		ArrayList<ContinuousProgram> continuousBlocks = new ArrayList<ContinuousProgram>();

		if ( getClass().equals( ContinuousProgram.class ) ) {
			continuousBlocks.add( (ContinuousProgram)this );

		} else if ( arguments != null ) {

			Iterator<dLStructure> argumentsIterator = arguments.iterator();

			dLStructure thisArgument;
			while ( argumentsIterator.hasNext() ) {
				thisArgument = argumentsIterator.next();

				if ( thisArgument.arguments != null ) { 
					continuousBlocks.addAll( thisArgument.extractContinuousBlocks() );
				}
			}
		}

		return continuousBlocks;
	}

	public HybridProgram extractFirstHybridProgram() {
		HybridProgram myProgram = null;

		if ( this instanceof HybridProgram ) {
			return (HybridProgram)this;
		} else if ( arguments!= null ) {

			Iterator<dLStructure> argumentsIterator = arguments.iterator();
			dLStructure thisArgument;
			while ( argumentsIterator.hasNext() ) {
				thisArgument = argumentsIterator.next();

				if ( thisArgument.extractFirstHybridProgram() != null ) {
					myProgram = thisArgument.extractFirstHybridProgram();
				}
			}
		}

		return myProgram;
	}


// Export toString methods
	public String toString() {
		if ( (operator != null) && (arguments != null) ) {
			return "(" + operator.toString() + " " + arguments.toString() + " )";
		} else if ( (operator != null) && (arguments == null) ) {
			return operator.toString();
		} else {
			return "(uninitialized structure)";
		}
	}

	public String toKeYmaeraString() {
		throw new RuntimeException("KeYmaera string is undefined for this structure: " + this.getClass().toString() );
	}

	public String toMathematicaString() {
		throw new RuntimeException("Mathematica string is undefined for this structure: " + this.getClass().toString() );
	}

	public String toManticoreString() {
		throw new RuntimeException("Manticore string is undefined for this structure: " + this.getClass().toString() );
	}

	public String todRealString() {
		throw new RuntimeException("dReal string is undefined for this structure: " + this.getClass().toString() );
	}

	public String toMatlabString() {
		throw new RuntimeException("Matlab string is undefined for this structure: " + this.getClass().toString() );
	}

	public abstract dLStructure clone();

// Convenience functions
	public boolean isANumber() {
		return false;
	}

	public boolean isAVariable() {
		return false;
	}

}
