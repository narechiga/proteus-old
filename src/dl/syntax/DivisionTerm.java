package proteus.dl.syntax;

import proteus.dl.semantics.*;

public class DivisionTerm extends Term {

	public DivisionTerm ( Term dividend, Term divisor ) {
		operator = new Operator( "/", 2, true );

		spawnArguments();
		addArgument( dividend );
		addArgument( divisor );
	}

	//public Term getDividend() {
	//	return (Term)getArgument( 0 );
	//}
        //
	//public Term getDivisor() {
	//	return (Term)getArgument( 1 );
	//}

	public Term getNumerator() {
		return (Term)getArgument( 0 );
	}

	public Term getDenominator() {
		return (Term)getArgument( 1 );
	}

	public DivisionTerm clone() {
		return new DivisionTerm( getNumerator().clone() , getDenominator().clone() );
	}

	//public Term getLHS() {
	//	return (Term)getArgument( 0 );
	//}

	//public Term getRHS() {
	//	return (Term)getArgument( 1 );
	//}

}

