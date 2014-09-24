package hephaestos.languages.scalararithmetic;

import java.util.*;

public class ScalarSubtractionTerm extends ScalarTerm {

	protected ScalarTerm minuend;
	protected ScalarTerm subtrahend;

	public ScalarSubtractionTerm ( ScalarTerm minuend, ScalarTerm subtrahend ) {
		this.minuend = minuend;
		this.subtrahend = subtrahend;
	}

// Getters
	public ScalarTerm getMinuend() {
		return minuend;
	}

	public ScalarTerm getSubtrahend() {
		return subtrahend;
	}

//
	public ArrayList<ScalarTerm> getSubTerms() {
		ArrayList<ScalarTerm> subterms = new ArrayList<ScalarTerm>();

		subterms.add( getMinuend() );
		subterms.add( getSubtrahend() );

		return subterms;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> variables = new HashSet<RealVariable>();

		variables.addAll( getMinuend().getFreeVariables() );
		variables.addAll( getSubtrahend().getFreeVariables() );

		return variables;
	}
// Clone
	public ScalarSubtractionTerm clone() {
		return new ScalarSubtractionTerm( getMinuend().clone(), 
						getSubtrahend().clone() );
	}

// String methods
	public String toMathematicaString() {
		return "( " + getMinuend().toMathematicaString() + " + " + getSubtrahend().toMathematicaString() + " )";
	}

	public String todRealString() {
		return "(- " + getMinuend().todRealString() + " " + getSubtrahend().todRealString() + " )";
	}

	public String toKeYmaeraString() {
		return toMathematicaString();
	}
}

