package hephaestos.languages.scalararithmetic;

public class ScalarMultiplicationTerm extends ScalarTerm {

	protected ScalarTerm leftFactor;
	protected ScalarTerm rightFactor;

	public ScalarMultiplicationTerm( ScalarTerm leftFactor, ScalarTerm rightFactor ) {
		this.leftFactor = leftFactor;
		this.rightFactor = rightFactor;
	}

// Getters
	public ScalarTerm getLeftFactor() {
	       return leftFactor; 
	}

	public ScalarTerm getRightFactor() {
		return rightFactor;
	}

//
	public ArrayList<ScalarTerm> getSubTerms() {
		ArrayList<ScalarTerm> subterms = new ArrayList<ScalarTerm>();

		subterms.add( getLeftFactor() );
		subterms.add( getRightFactor() );

		return subterms;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> variables = new HashSet<RealVariable>();

		variables.addAll( getLeftFactor().getFreeVariables() );
		variables.addAll( getRightFactor().getFreeVariables() );

		return variables;
	}
// Clone
	public ScalarMultiplicationTerm clone() {
		return new ScalarMultiplicationTerm( getLeftFactor().clone(), 
						getRightFactor().clone() );
	}

// String methods
	public String toMathematicaString() {
		return "( " + getLeftFactor().toMathematicaString() + " + " + getRightFactor().toMathematicaString() + " )";
	}

	public String todRealString() {
		return "(* " + getLeftFactor().todRealString() + " " + getRightFactor().todRealString() + " )";
	}

	public String toKeYmaeraString() {
		return toMathematicaString();
	}
}

