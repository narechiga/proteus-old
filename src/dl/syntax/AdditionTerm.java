package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

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
		return new AdditionTerm( getLeftSummand().clone() , 
						getRightSummand().clone() );
	}

	public Term distributeMultiplication() {
		return new AdditionTerm(
			getLeftSummand().distributeMultiplication(),
			getRightSummand().distributeMultiplication() );
	}

// Arithmetic Analysis
	public boolean isLinearIn( ArrayList<RealVariable> variables ) {
		// If both terms are linear in the given variables,
		// then the sum is linear
		if ( getLeftSummand().isLinearIn( variables )
			&& getRightSummand().isLinearIn( variables ) ) {
			return true;

		} else {
			return false;

		}
	}

	public boolean isAffineIn( ArrayList<RealVariable> variables ) {
		// If both terms are affine in the given variables,
		// then the sum is affine
		
		if ( getLeftSummand().isAffineIn( variables )
			&& getRightSummand().isAffineIn( variables ) ) {
			return true;

		} else {
			return false;

		}
	}
}
