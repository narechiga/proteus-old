package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public class NegativeTerm extends Term {

	public NegativeTerm ( Term negatedTerm ) {
		operator = new Operator( "-", 1, false );

		spawnArguments();
		addArgument( negatedTerm );
	}

// Getters
	public Term getNegatedTerm() {
		return (Term)getArgument( 0 );
	}

// Clone
	public NegativeTerm clone() {
		return new NegativeTerm( getNegatedTerm().clone() );
	}

// Arithmetic
	public Term distributeMultiplication() {
		MultiplicationTerm negativeAsMultiplication = new MultiplicationTerm(
			new Real("-1"),
			getNegatedTerm() );

		return negativeAsMultiplication.distributeMultiplication();
	}

// Arithmetic Analysis
	public boolean isLinearIn( ArrayList<RealVariable> variables ) {
		return getNegatedTerm().isLinearIn( variables );
	}

	public boolean isAffineIn( ArrayList<RealVariable> variables ) {
		return getNegatedTerm().isAffineIn( variables );
	}

}

