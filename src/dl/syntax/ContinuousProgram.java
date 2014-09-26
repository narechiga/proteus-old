package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class ContinuousProgram extends HybridProgram {

// Constructors and field getters
	// constructor with DOE
	public ContinuousProgram ( ArrayList<ExplicitODE> odeList, dLFormula doe ) {
		this.operator = new Operator("continuous-evolution");

		spawnArguments();
		this.arguments.addAll( odeList );

		// Guarantee: Must always have a doe, even if it's just "true"
		this.arguments.add( doe );
	}

	// constructor without DOE
	public ContinuousProgram ( ArrayList<ExplicitODE> odeList ) {
		this.operator = new Operator("continuous-evolution");
		
		spawnArguments();
		this.arguments.addAll( odeList );

		// Guarantee: Must always have a doe, even if it's just "true"
		this.arguments.add( new TrueFormula() );
	}

	public ArrayList<RealVariable> getContinuousVariables() {

		ArrayList<RealVariable> myVariables = new ArrayList<RealVariable>();

		ArrayList<ExplicitODE> myODEs= this.getODEs();
		Iterator<ExplicitODE> odeIterator = myODEs.iterator();
		
		while ( odeIterator.hasNext() ) {
			myVariables.add( odeIterator.next().getLHS() );
		}

		return myVariables;
	}

	// Operations on ODE List
	public ArrayList<ExplicitODE> getODEs () {

		ArrayList<ExplicitODE> odeList = new ArrayList<ExplicitODE>();

		Iterator<dLStructure> childIterator = arguments.iterator();
		dLStructure thisArgument;
		while ( childIterator.hasNext() ) {
			thisArgument = childIterator.next();
			if ( thisArgument instanceof ExplicitODE) {
				odeList.add( (ExplicitODE)thisArgument );
			}
		}

		return odeList;
	}

	public ExplicitODE getODE( int index ) {
		return (ExplicitODE)arguments.get( index );
	}

	public void addODE( dLStructure ode ) {
		int doeIndex = arguments.size() - 1;
		
		arguments.add( doeIndex, ode );
	}

	public void addODEs( ArrayList<dLStructure> odeList ) {
		int doeIndex = arguments.size() - 1;
		
		arguments.addAll( doeIndex, odeList );
	}


	// Operations on DOE
	public dLFormula getDOE() {
		int doeIndex = arguments.size() - 1;

		if ( arguments.get(doeIndex) instanceof dLFormula ) {
			return ((dLFormula)arguments.get(doeIndex));
		} else {
			return null;
		}
	}

	public void setDOE ( dLFormula doe ) {
		int doeIndex = arguments.size();

		// Assume: Must always have a doe, even if it's just "true"
		arguments.set( doeIndex, doe );
	}

	public void restrictDOE () {}

	public void enlargeDOE () {}


// Substitution method
	public ContinuousProgram substituteConcreteValuation( Valuation substitution ) {
		// Substitute into the ode list
		ArrayList<ExplicitODE> odeSubstituted = new ArrayList<ExplicitODE>();
		Iterator<ExplicitODE> myODEiterator = getODEs().iterator();
		while ( myODEiterator.hasNext() ) {
			odeSubstituted.add( myODEiterator.next().substituteConcreteValuation( substitution ) );
		}

		return new ContinuousProgram( odeSubstituted, getDOE().clone() );
	}



// Clone method
	public ContinuousProgram clone() {
		// Clone the ode list
		ArrayList<ExplicitODE> odeClones = new ArrayList<ExplicitODE>();
		Iterator<ExplicitODE> myODEiterator = getODEs().iterator();
		while ( myODEiterator.hasNext() ) {
			odeClones.add( myODEiterator.next().clone() );
		}

		return new ContinuousProgram( odeClones, getDOE().clone() );
	}

// Assorted convenience functions
	public boolean isPurelyContinuous() {
		return true;
	}

	public boolean isPurelyDiscrete() {
		return false;
	}

	public boolean isHybrid() {
		return false;
	}

	public boolean isProgramPrimitive() {
		return true;
	}

	public boolean isQuantifierFree() {
		return getDOE().isQuantifierFree();
	}

// String operations
	public String toKeYmaeraString() {
		
		String returnString = "{ ";

		Iterator<dLStructure> childIterator = arguments.iterator();
		dLStructure thisArgument;
		ExplicitODE thisODE;

		while( childIterator.hasNext() ) {
			
			thisArgument = childIterator.next();

			if ( childIterator.hasNext() ) { // then this is an ode, not the doe

				thisODE = (ExplicitODE)thisArgument;
				returnString = returnString + thisODE.toKeYmaeraString() + ", ";

			} else { //then this is the doe
				returnString = returnString.substring(0, returnString.length() -2 );
				returnString = returnString + " & " + getDOE().toKeYmaeraString();
			}
		}
		returnString = returnString + " }";
		
		return returnString;
	}

	public String toManticoreString() {
		return toKeYmaeraString();
	}


	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.addAll( getDOE().getBoundVariables() );
		return boundVariables;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getDOE().getFreeVariables() );

		Iterator<ExplicitODE> odeIterator = getODEs().iterator();
		while (odeIterator.hasNext() ) {
			freeVariables.addAll( odeIterator.next().getFreeVariables() );
		}

		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();

		Iterator<ExplicitODE> odeIterator = getODEs().iterator();
		while( odeIterator.hasNext() ) {
			dynamicVariables.addAll( odeIterator.next().getDynamicVariables() );
		}

		return dynamicVariables;
	}

}
