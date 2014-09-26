package proteus.dl.syntax;

import proteus.dl.semantics.*;

public class PowerTerm extends Term {

	public PowerTerm( Term base, Term exponent ) {
		operator = new Operator("^", 2, true);

		spawnArguments();
		addArgument( base );
		addArgument( exponent );
	}

// Getters
	public Term getBase() {
		return (Term)getArgument( 0 );
	}

	public Term getExponent() {
		return (Term)getArgument( 1 );
	}

	public Term getLHS() {
		return (Term)getArgument( 0 );
	}

	public Term getRHS() {
		return (Term)getArgument( 1 );
	}

// Clone
	public PowerTerm clone() {
		return new PowerTerm( getBase(), getExponent() );
	}

}

