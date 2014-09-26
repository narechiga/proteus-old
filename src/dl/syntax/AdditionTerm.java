package proteus.dl.syntax;

import proteus.dl.semantics.*;

public class AdditionTerm extends Term {

// Constructor
	public AdditionTerm ( Term leftSummand, Term rightSummand ) {
		this.operator = new Operator("+", true );

		spawnArguments();
		addArgument( leftSummand );
		addArgument( rightSummand );
	}

	public Term getLeftSummand() {
		return (Term)getArgument( 0 );
	}

	public Term getRightSummand() {
		return (Term)getArgument( 1 );
	}

	public Term getLHS() {
		return (Term)getArgument( 0 );
	}

	public Term getRHS() {
		return (Term)getArgument( 1 );
	}

// Clone
	public AdditionTerm clone() {
		return new AdditionTerm( getLeftSummand().clone() , getRightSummand().clone() );
	}


}
