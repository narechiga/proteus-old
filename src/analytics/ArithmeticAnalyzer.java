package proteus.analytics;

import proteus.dl.syntax.*;
import java.util.*;

public class ArithmeticAnalyzer { //extends ScalarTerm {
	// Would like to implement this as a decorator, but I am not sure how to forward the needed
	// functionality in an easy way
	
	// And of course spin off the decorators for the ODEs and for the ContinuousPrograms in separate
	// classes, so that everything can have its own little decorator that adds analytics

//
	public boolean termContainsVariables( Term thisTerm, ArrayList<RealVariable> variables ) {
		Set<RealVariable> termVars = thisTerm.getFreeVariables();
		int termVarsCardinality = termVars.size();
		termVars.removeAll( variables );

		if ( termVars.size() < termVarsCardinality ) {
			return true;
		} else {
			return false;
		}
	}

//
	public boolean termIsLinearInVariables( Term thisTerm, ArrayList<RealVariable> variables ) throws AnalyticsException {

		if ( thisTerm instanceof Real ) {
			// A Real is affine in any variables, but never strictly linear
			return false;

		} else if ( thisTerm instanceof RealVariable ) {
			RealVariable term = (RealVariable)thisTerm;

			if ( variables.contains( term ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof AdditionTerm ) {
			AdditionTerm term = (AdditionTerm)thisTerm;
			// If both terms are linear in the given variables,
			// then the sum is linear
			if ( termIsLinearInVariables( term.getLeftSummand(), variables )
				&& termIsLinearInVariables( term.getRightSummand(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof SubtractionTerm ) {
			SubtractionTerm term = (SubtractionTerm)thisTerm;

			if ( termIsLinearInVariables( term.getMinuend(), variables )
				&& termIsLinearInVariables( term.getSubtrahend(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof MultiplicationTerm ) {
			// If exactly one factor is linear in the given variables
			// and the other contains none, then the product is linear
			MultiplicationTerm term = (MultiplicationTerm)thisTerm;

			if ( termIsLinearInVariables( term.getLeftFactor(), variables )
				&& !termContainsVariables( term.getRightFactor(), variables) ) {
				return true;

			} else if ( termIsLinearInVariables( term.getRightFactor(), variables )
				&& !termContainsVariables( term.getLeftFactor(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof DivisionTerm ) {
			// If the numerator is linear and the denominator does not contain
			// the variables, then the quotient is linear
			DivisionTerm term = (DivisionTerm)thisTerm;

			boolean linearity;
	
			if ( termIsLinearInVariables( term.getNumerator(), variables ) 
				&& !termContainsVariables( term.getDenominator(), variables )) {

				linearity = true;
				
			} else {
				linearity = false;
			}
	
			return linearity;

		} else if ( thisTerm instanceof PowerTerm ) {
			// A power term can never be linear in any of its variables
			return false;

		} else {
			throw new AnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
					+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	} // end termIsLinearInVariables

//
	public boolean termIsAffineInVariables( Term thisTerm, ArrayList<RealVariable> variables ) throws AnalyticsException {
		if ( thisTerm instanceof Real ) {
			// A Real is affine in any variables
			return true;

		} else if ( thisTerm instanceof RealVariable ) {
			// If this variable is one of the variables of interest, it
			// is linear and hence affine. If it is not one of the variables
			// of interest, then it is affine because it is an additive constant
			// with respect to the variables of interest.

			return true;

		} else if ( thisTerm instanceof AdditionTerm ) {
			// If both terms are affine in the given variables,
			// then the sum is affine
			
			AdditionTerm term = (AdditionTerm)thisTerm;
			
			if ( termIsAffineInVariables( term.getLeftSummand(), variables )
				&& termIsAffineInVariables( term.getRightSummand(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof SubtractionTerm ) {
			SubtractionTerm term = (SubtractionTerm)thisTerm;

			if ( termIsAffineInVariables( term.getMinuend(), variables )
				&& termIsAffineInVariables( term.getSubtrahend(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof MultiplicationTerm ) {
			// If exactly one factor is affine in the given variables
			// and the other contains none of those variables, then the product is affine

			MultiplicationTerm term = (MultiplicationTerm)thisTerm;

			if ( termIsAffineInVariables( term.getLeftFactor(), variables )
				&& !termContainsVariables( term.getRightFactor(), variables) ) {
				return true;

			} else if ( termIsAffineInVariables( term.getRightFactor(), variables )
				&& !termContainsVariables( term.getLeftFactor(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm instanceof DivisionTerm ) {
			// If the numerator is affine and the denominator does not contain
			// the variables, then the quotient is affine

			DivisionTerm term = (DivisionTerm)thisTerm;

			boolean affinity;
	
			if ( termIsAffineInVariables( term.getNumerator(), variables ) 
				&& !termContainsVariables( term.getDenominator(), variables )) {

				affinity = true;
				
			} else {
				affinity = false;
			}
	
			return affinity;

		} else if ( thisTerm instanceof PowerTerm ) {
			// A power term can be affine only if it doesn't contain the given variables

			PowerTerm term = (PowerTerm)thisTerm;

			if ( !termContainsVariables( term, variables ) ) {
				return true;

			} else  {
				return false;

			}

		} else {
			throw new AnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
					+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	}

// ExplicitODE
	public boolean odeIsLinearInVariables( ExplicitODE ode, ArrayList<RealVariable> variables ) throws AnalyticsException {
		return termIsLinearInVariables( ode.getRHS(), variables );
	}

	public boolean odeIsAffineInVariables( ExplicitODE ode, ArrayList<RealVariable> variables ) throws AnalyticsException {
		return termIsAffineInVariables( ode.getRHS(), variables );
	}

// ContinuousProgram
	public boolean continuousProgramIsLinearInVariables( ContinuousProgram cprogram, ArrayList<RealVariable> variables ) throws AnalyticsException {
		boolean linearity = true;

		Iterator<ExplicitODE> odeIterator = cprogram.getODEs().iterator();
		while ( odeIterator.hasNext() ) {
			linearity = linearity && odeIsLinearInVariables( odeIterator.next(), variables );
		}

		return linearity;
	}

	public boolean continuousProgramIsAffineInVariables( ContinuousProgram cprogram, ArrayList<RealVariable> variables ) throws AnalyticsException {
		boolean affinity = true;

		Iterator<ExplicitODE> odeIterator = cprogram.getODEs().iterator();
		while ( odeIterator.hasNext() ) {
			affinity = affinity && odeIsAffineInVariables( odeIterator.next(), variables );
		}

		return affinity;
	}

	public MatrixTerm extractLinearCoefficients( ExplicitODE ode, ArrayList<RealVariable> variables ) {
		System.out.println("WARNING: extractLinearCoefficients does not expand terms, so this will only work if your ode expression is expanded");

		ArrayList<Term> additiveTerms= splitOnPlus( ode.getRHS() );

		return null;
	}

}

