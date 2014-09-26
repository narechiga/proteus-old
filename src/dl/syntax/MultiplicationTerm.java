package proteus.dl.syntax;

import proteus.dl.semantics.*;

public class MultiplicationTerm extends Term {

	public MultiplicationTerm( Term leftFactor, Term rightFactor ) {
		this.operator = new Operator("*", 2, true);

		spawnArguments();
		addArgument( leftFactor );
		addArgument( rightFactor );
	}

// Getters
	public Term getLeftFactor() {
	       return (Term)getArgument( 0 );
	}

	public Term getRightFactor() {
		return (Term)getArgument( 1 );
	}

// Clone
	public MultiplicationTerm clone() {
		return new MultiplicationTerm( getLeftFactor(), getRightFactor() );
	}

}

