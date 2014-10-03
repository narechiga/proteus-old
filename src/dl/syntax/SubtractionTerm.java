package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public class SubtractionTerm extends Term {

	public SubtractionTerm ( Term minuend, Term subtrahend ) {
		operator = new Operator( "-", 2, true );

		spawnArguments();
		addArgument( minuend );
		addArgument( subtrahend );
	}

// Getters
	public Term getMinuend() {
		return (Term)getArgument( 0 );
	}

	public Term getSubtrahend() {
		return (Term)getArgument( 1 );
	}

	public Term getLHS() {
		return (Term)getArgument( 0 );
	}

	public Term getRHS() {
		return (Term)getArgument( 1 );
	}
	
// Clone
	public SubtractionTerm clone() {
		return new SubtractionTerm( getMinuend().clone(), getSubtrahend().clone() );
	}

	public Term distributeMultiplication() {
		return new SubtractionTerm(
			getMinuend().distributeMultiplication(),
			getSubtrahend().distributeMultiplication() );
	}

// Arithmetic Analysis
	public boolean isLinearIn( ArrayList<RealVariable> variables ) {
		// If both terms are linear in the given variables,
		// then the difference is linear
		if ( getMinuend().isLinearIn( variables )
			&& getSubtrahend().isLinearIn( variables ) ) {
			return true;

		} else {
			return false;

		}
	}

	public boolean isAffineIn( ArrayList<RealVariable> variables ) {
		// If both terms are affine in the given variables,
		// then the difference is affine
		if ( getMinuend().isAffineIn( variables )
			&& getSubtrahend().isAffineIn( variables ) ) {
			return true;

		} else {
			return false;

		}
	}
	
}

