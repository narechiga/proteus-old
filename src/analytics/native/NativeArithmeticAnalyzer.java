package hephaestos.analytics.native;

// GAAH this is why the dl stuff needs to be 
// refactored into hephaestos
import manticore.dl.*;
import hephaestos.analytics.abstractions.*;

public class NativeArithmeticAnalyzer extends ArithmeticAnalyzer {

//
	public boolean TermContainsVariables( Term thisTerm, ArrayList<RealVariable> variables ) {
		Set<RealVariable> termVars = thisTerm.getFreeVariables();
		int termVarsCardinality = termVars.size();
		termVars.removeAll( variables );

		if ( thisTermVars.size() < termVarsCardinality ) {
			return true;
		} else {
			return false;
		}
	}

//
	public boolean termIsLinearInVariables( Term thisTerm, ArrayList<RealVariable> variables ) {

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
				&& !TermContainsVariables( term.getRightFactor(), variables) ) {
				return true;

			} else if ( termIsLinearInVariables( term.getRightFactor(), variables )
				&& !TermContainsVariables( term.getLeftFactor(), variables ) ) {
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
				&& !TermContainsVariables( term.getDenominator(), variables )) {

				linearity = true;
				
			} else {
				linearity = false;
			}
	
			return linearity;

		} else if ( thisTerm instanceof PowerTerm ) {
			// A power term can never be linear in any of its variables
			return false;

		} else {
			throw new HephaestosAnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
					+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	} // end termIsLinearInVariables

//
	public boolean isAffineIn( Term term, ArrayList<RealVariable> variables ) {
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
				&& !TermContainsVariables( term.getRightFactor(), variables) ) {
				return true;

			} else if ( termIsAffineInVariables( term.getRightFactor(), variables )
				&& !TermContainsVariables( term.getLeftFactor(), variables ) ) {
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
				&& !TermContainsVariables( term.getDenominator(), variables )) {

				affinity = true;
				
			} else {
				affinity = false;
			}
	
			return linearity;

		} else if ( thisTerm instanceof PowerTerm ) {
			// A power term can be affine only if it doesn't contain the given variables

			PowerTerm term = (PowerTerm)thisTerm;

			if ( !TermContainsVariables( term, variables ) ) {
				return true;

			} else  {
				return false;

			}

		} else {
			throw new HephaestosAnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
					+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	}

//
	public RealMatrix extractLinearCoefficients( Term term, ArrayList<RealVariable> variables ) {
	}

}

