package hephaestos.languages.scalararithmetic;

import java.util.*;

public class ScalarPowerTerm extends ScalarTerm {

	protected ScalarTerm base;
	protected ScalarTerm exponent;

	public ScalarPowerTerm( ScalarTerm base, ScalarTerm exponent ) {
		this.base = base;
		this.exponent = exponent;
	}

// Getters
	public ScalarTerm getBase() {
		return base;
	}

	public ScalarTerm getExponent() {
		return exponent;
	}

//
	public ArrayList<ScalarTerm> getSubTerms() {
		ArrayList<ScalarTerm> subterms = new ArrayList<ScalarTerm>();

		subterms.add( getBase() );
		subterms.add( getExponent() );

		return subterms;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> variables = new HashSet<RealVariable>();

		variables.addAll( getBase().getFreeVariables() );
		variables.addAll( getExponent().getFreeVariables() );

		return variables;
	}
// Clone
	public ScalarPowerTerm clone() {
		return new ScalarPowerTerm( getBase().clone(),
					 getExponent().clone() );
	}

// String methods
	public String toMathematicaString() {
		return "( " + getBase().toMathematicaString() + " + " + getExponent().toMathematicaString() + " )";
	}

	public String todRealString() {
		return "(^ " + getBase().todRealString() + ", " + getExponent().todRealString() + " )";
	}

	public String toKeYmaeraString() {
		return toMathematicaString();
	}
}

