package hephaestos.languages.scalararithmetic;

import java.util.*;

public class ScalarDivisionTerm extends ScalarTerm {

	protected ScalarTerm numerator;
	protected ScalarTerm denominator;

	public ScalarDivisionTerm ( ScalarTerm numerator, ScalarTerm denominator ) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public ScalarTerm getNumerator() {
		return numerator;
	}

	public ScalarTerm getDenominator() {
		return denominator;
	}

//
	public ArrayList<ScalarTerm> getSubTerms() {
		ArrayList<ScalarTerm> subterms = new ArrayList<ScalarTerm>();

		subterms.add( getNumerator() );
		subterms.add( getDenominator() );

		return subterms;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> variables = new HashSet<RealVariable>();

		variables.addAll( getNumerator().getFreeVariables() );
		variables.addAll( getDenominator().getFreeVariables() );

		return variables;
	}

// Clone
	public ScalarDivisionTerm clone() {
		return new ScalarDivisionTerm( numerator.clone(), denominator.clone() );
	}

// String methods
	public String toMathematicaString() {
		return "( " + getNumerator().toMathematicaString() + " + " + getDenominator().toMathematicaString() + " )";
	}

	public String todRealString() {
		return "(/ " + getNumerator().todRealString() + " " + getDenominator().todRealString() + " )";
	}

	public String toKeYmaeraString() {
		return toMathematicaString();
	}
}

