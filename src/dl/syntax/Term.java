package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class Term extends GeneralizedTerm {

	public Term () {
	}

	public Term ( Operator operator, ArrayList<Term> subterms ) {
		this.operator = operator;
		this.arguments = new ArrayList<dLStructure>();
		this.arguments.addAll( subterms );
	}

	public Term ( String operator, ArrayList<Term> subterms ) {
		this.operator = new Operator( operator );
		this.arguments = new ArrayList<dLStructure>();
		this.arguments.addAll( subterms );
	}

	public Operator getOperator() {
		return this.operator;
	}

// Substitution method
	public Term substituteConcreteValuation( Valuation substitution ) {
		ArrayList<Term> subtermsSubstituted = new ArrayList<Term>();
		Iterator<Term> subtermIterator = getSubTerms().iterator();
		while ( subtermIterator.hasNext() ) {
			subtermsSubstituted.add( subtermIterator.next().substituteConcreteValuation( substitution ) );
		}
		
		return new Term( getOperator().clone(), subtermsSubstituted );
	}

// Clone method
	public Term clone() {
		ArrayList<Term> subtermClones = new ArrayList<Term>();
		Iterator<Term> subTermIterator = getSubTerms().iterator();
		while ( subTermIterator.hasNext() ) {
			subtermClones.add( subTermIterator.next().clone() );
		}

		return new Term( getOperator().clone(), subtermClones );
	}

	public ArrayList<Term> getSubTerms() {
		ArrayList<Term> subTerms = new ArrayList<Term>();
		Iterator<dLStructure> subTermIterator = arguments.iterator();

		while ( subTermIterator.hasNext() ) {
			// This can be done safely because all the arguments of a term will be terms,
			// see constructors
			subTerms.add( (Term)(subTermIterator.next()) );
		}

		return subTerms;
	}


	public String toKeYmaeraString() {

		String returnString = "";

		if ( operator.infix == false ) {
			returnString = returnString + operator.toKeYmaeraString() + "(";
			if ( arguments != null ) {
				Iterator<dLStructure> childIterator = arguments.iterator();
				while ( childIterator.hasNext() ) {
					returnString = returnString + " " + childIterator.next().toKeYmaeraString();
				}
			}
			returnString = returnString + " )";
		} else {
			returnString = returnString + "( ";
			if ( arguments != null ) {
				Iterator<dLStructure> childIterator = arguments.iterator();
				while ( childIterator.hasNext() ) {
					returnString = returnString + childIterator.next().toKeYmaeraString();

					if ( childIterator.hasNext() ) {
						returnString = returnString + " " + operator.toKeYmaeraString() + " ";
					}
				}
			}
			returnString = returnString + " )";
		}

		return returnString;
	}

	public String toMathematicaString() {
		return toKeYmaeraString();
	}

	public String toManticoreString() {
		return toKeYmaeraString();
	}

	public String todRealString() {
		String returnString = "(" + this.operator.todRealString() ;

		Iterator<Term> subTermIterator = getSubTerms().iterator();
		while ( subTermIterator.hasNext() ) {
			returnString = returnString + " " + subTermIterator.next().todRealString();
		}
		returnString = returnString + " )";

		return returnString;
	}


		

	//public boolean equals( Object otherObject ) { // This is too restrictive, because does not allow for commutativity

	//	if ( !(otherObject instanceof Term ) ) {
	//		return false;
	//	}

	//	Term otherTerm = (Term)otherObject;
	//	if ( !(this.operator.equals( otherTerm.operator ) ) ) {
	//		return false;
	//	}

	//	Iterator<dLStructure> myArgumentIterator = this.arguments.iterator();
	//	Iterator<dLStructure> otherArgumentIterator = otherTerm.arguments.iterator();

	//	boolean result = true; //will be anded with the condition that each child must be equal, then returned
	//	Term myArgument; Term otherArgument;
	//	// Look at the constructor, and note that all the arguments of terms are terms.
	//	// Then all the typecasts below should succeed.
	//	while ( myArgumentIterator.hasNext() ) {

	//		if ( otherArgumentIterator.hasNext() ) {

	//			myArgument = (Term)(myArgumentIterator.next());
	//			otherArgument = (Term)(otherArgumentIterator.next());
	//			
	//			result = result && myArgument.equals( otherArgument );

	//		} else {
	//			return false; // because then they are not the same size, cannot be equal!
	//		}
	//	}
	//}

// Following two methods really only used for the "arbitrary" term, as in x := *
	public Term ( Operator operator ) {
		this.operator = operator;
		this.arguments = null;
	}

	public Term ( String operator ) {
		this.operator = new Operator( operator );
		this.arguments = null;
	}

// Logic
	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		Iterator<Term> subTermIterator = getSubTerms().iterator();
		while ( subTermIterator.hasNext() ) {
			freeVariables.addAll( subTermIterator.next().getFreeVariables() );
		}

		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		return dynamicVariables;
	}
// Arithmetic properties
	public boolean isLinearIn( RealVariable variable ) {
		return false;
	}
	public boolean isAffineIn( RealVariable variable ) {
		return false;	
	}

	public boolean isLinearIn( ArrayList<RealVariable> variable ) {
		return false;
	}

	public boolean isAffineIn( ArrayList<RealVariable> variable ) {
		return false;
	}



			

}
