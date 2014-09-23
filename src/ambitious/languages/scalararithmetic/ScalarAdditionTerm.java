package hephaestos.languages.scalararithmetic;

public class ScalarAdditionTerm extends ScalarTerm {

	protected ScalarTerm leftSummand;
	protected ScalarTerm rightSummand;

// Constructor
	public ScalarAdditionTerm ( ScalarTerm leftSummand, ScalarTerm rightSummand ) {
		this.leftSummand = leftSummand;
		this.rightSummand = rightSummand;
	}

	public ScalarTerm getLeftSummand() {
		return leftSummand;
	}

	public ScalarTerm getRightSummand() {
		return rightSummand;
	}

//
	public ArrayList<ScalarTerm> getSubTerms() {
		ArrayList<ScalarTerm> subterms = new ArrayList<ScalarTerm>();

		subterms.add( getLeftSummand() );
		subterms.add( getRightSummand() );

		return subterms;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> variables = new HashSet<RealVariable>();

		variables.addAll( getLeftSummand().getFreeVariables() );
		variables.addAll( getRightSummand().getFreeVariables() );

		return variables;
	}


// Clone
	public ScalarAdditionTerm clone() {
		return new ScalarAdditionTerm( getLeftSummand().clone() , getRightSummand().clone() );
	}

// String methods
	public String toMathematicaString() {
		return "( " + getLeftSummand().toMathematicaString() + " + " + getRightSummand().toMathematicaString() + " )";
	}

	public String todRealString() {
		return "(+ " + getLeftSummand().todRealString() + " " + getRightSummand().todRealString() + " )";
	}

	public String toKeYmaeraString() {
		return toMathematicaString();
	}

}
