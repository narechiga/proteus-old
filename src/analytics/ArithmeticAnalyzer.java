package proteus.analytics;

import proteus.dl.syntax.*;
import java.util.*;

public class ArithmeticAnalyzer { //extends ScalarTerm {
	// Would like to implement this as a decorator, but I am not sure how to forward the needed
	// functionality in an easy way
	
	// And of course spin off the decorators for the ODEs and for the ContinuousPrograms in separate
	// classes, so that everything can have its own little decorator that adds analytics

//
	//public static boolean termContainsVariables( Term thisTerm, ArrayList<RealVariable> variables ) {
	//	Set<RealVariable> termVars = thisTerm.getFreeVariables();
	//	int termVarsCardinality = termVars.size();
	//	termVars.removeAll( variables );

	//	if ( termVars.size() < termVarsCardinality ) {
	//		return true;
	//	} else {
	//		return false;
	//	}
	//}

//
	public static boolean isLinearIn( Term thisTerm, ArrayList<RealVariable> variables ) throws AnalyticsException {

		if ( thisTerm.isANumber() ) {
			// A Real is affine in any variables, but never strictly linear -- unless it is zero
			if ( thisTerm.equals( new Real("0") ) ) {
				return true;
			} else {
				return false;
			}

		} else if ( thisTerm.isAVariable() ) {
			RealVariable term = (RealVariable)thisTerm;

			if ( variables.contains( term ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("+") ) {
			AdditionTerm term = (AdditionTerm)thisTerm;
			// If both terms are linear in the given variables,
			// then the sum is linear
			if ( isLinearIn( term.getLeftSummand(), variables )
				&& isLinearIn( term.getRightSummand(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("-") 
				&& (thisTerm.getArguments().size() == 1) ) {
			// Unary minus, is linear if its subterm is linear
			NegativeTerm term = (NegativeTerm)thisTerm;

			if ( isLinearIn( term.getNegatedTerm(), variables ) ) {
				return true;
			} else {
				return false;
			}

		} else if ( thisTerm.operatorEquals("-") ) {
			// If both terms are linear in the given variables,
			// then the difference is linear
			SubtractionTerm term = (SubtractionTerm)thisTerm;

			if ( isLinearIn( term.getMinuend(), variables )
				&& isLinearIn( term.getSubtrahend(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("*") ) {
			// If exactly one factor is linear in the given variables
			// and the other contains none, then the product is linear
			MultiplicationTerm term = (MultiplicationTerm)thisTerm;

			if ( term.getLeftFactor().containsAnyFreeVariables( variables )
				&& !term.getRightFactor().containsAnyFreeVariables( variables) )  {
				return true;

			} else if ( isLinearIn( term.getRightFactor(), variables )
				&& !term.getLeftFactor().containsAnyFreeVariables( variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("/") ) {
			// If the numerator is linear and the denominator does not contain
			// the variables, then the quotient is linear
			DivisionTerm term = (DivisionTerm)thisTerm;

			boolean linearity;
	
			if ( isLinearIn( term.getNumerator(), variables ) 
				&& !term.getDenominator().containsAnyFreeVariables( variables )) {

				linearity = true;
				
			} else {
				linearity = false;
			}
	
			return linearity;

		} else if ( thisTerm.operatorEquals("^") ) {
			// A power term can never be linear in any of its variables
			return false;

		} else {
			throw new AnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
					+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	} // end isLinearIn

//
	public static boolean isAffineIn( Term thisTerm, ArrayList<RealVariable> variables ) throws AnalyticsException {
		if ( thisTerm.isANumber() ) {
			// A Real is affine in any variables
			return true;

		} else if ( thisTerm.isAVariable() ) {
			// If this variable is one of the variables of interest, it
			// is linear and hence affine. If it is not one of the variables
			// of interest, then it is affine because it is an additive constant
			// with respect to the variables of interest.

			return true;

		} else if ( thisTerm.operatorEquals("+") ) {
			// If both terms are affine in the given variables,
			// then the sum is affine
			
			AdditionTerm term = (AdditionTerm)thisTerm;
			
			if ( isAffineIn( term.getLeftSummand(), variables )
				&& isAffineIn( term.getRightSummand(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("-") ) {
			SubtractionTerm term = (SubtractionTerm)thisTerm;

			if ( isAffineIn( term.getMinuend(), variables )
				&& isAffineIn( term.getSubtrahend(), variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("*") ) {
			// If exactly one factor is affine in the given variables
			// and the other contains none of those variables, then the product is affine

			MultiplicationTerm term = (MultiplicationTerm)thisTerm;

			if ( isAffineIn( term.getLeftFactor(), variables )
				&& !term.getRightFactor().containsAnyFreeVariables( variables) ) {
				return true;

			} else if ( isAffineIn( term.getRightFactor(), variables )
				&& !term.getLeftFactor().containsAnyFreeVariables( variables ) ) {
				return true;

			} else {
				return false;

			}

		} else if ( thisTerm.operatorEquals("/") ) {
			// If the numerator is affine and the denominator does not contain
			// the variables, then the quotient is affine

			DivisionTerm term = (DivisionTerm)thisTerm;

			boolean affinity;
	
			if ( isAffineIn( term.getNumerator(), variables ) 
				&& !term.getDenominator().containsAnyFreeVariables( variables )) {

				affinity = true;
				
			} else {
				affinity = false;
			}
	
			return affinity;

		} else if ( thisTerm.operatorEquals("^") ) {
			// A power term can be affine only if it doesn't contain the given variables

			PowerTerm term = (PowerTerm)thisTerm;

			if ( !term.containsAnyFreeVariables( variables ) ) {
				return true;

			} else  {
				return false;

			}

		} else {
			return false;
			//throw new AnalyticsException("Unknown term type: " + thisTerm.getClass().getName()
			//		+ "; with operator: " + thisTerm.getOperator().toString() );
		}

	}

// ExplicitODE
	public static boolean isLinearIn( ExplicitODE ode, ArrayList<RealVariable> variables ) throws AnalyticsException {
		return isLinearIn( ode.getRHS(), variables );
	}

	public static boolean isAffineIn( ExplicitODE ode, ArrayList<RealVariable> variables ) throws AnalyticsException {
		return isAffineIn( ode.getRHS(), variables );
	}

// ContinuousProgram
	//public static boolean isLinearIn( ContinuousProgram continousProgram, ColumnVector stateVector ) throws AnalyticsException {
	//	return isLinearIn( continousProgram, stateVector.toArrayList() );
	//}

	//public static boolean isAffineIn( ContinuousProgram continousProgram, ColumnVector stateVector ) throws AnalyticsException {
	//	return isAffineIn( continousProgram, stateVector.toArrayList() );
	//}

	public static boolean isLinearIn( ContinuousProgram continousProgram, ArrayList<RealVariable> variables ) throws AnalyticsException {
		boolean linearity = true;

		Iterator<ExplicitODE> odeIterator = continousProgram.getODEs().iterator();
		while ( odeIterator.hasNext() ) {
			linearity = linearity && isLinearIn( odeIterator.next(), variables );
		}

		return linearity;
	}

	public static boolean isAffineIn( ContinuousProgram continousProgram, ArrayList<RealVariable> variables ) throws AnalyticsException {
		boolean affinity = true;

		Iterator<ExplicitODE> odeIterator = continousProgram.getODEs().iterator();
		while ( odeIterator.hasNext() ) {
			affinity = affinity && isAffineIn( odeIterator.next(), variables );
		}

		return affinity;
	}

// Arithmetic splitting
	public static ArrayList<Term> splitTermOnAddition( Term thisTerm ) {
		ArrayList<Term> summands = new ArrayList<>();

		if ( thisTerm instanceof AdditionTerm ) {
			summands.addAll( splitTermOnAddition( ((AdditionTerm)thisTerm).getLeftSummand() ) );
			summands.addAll( splitTermOnAddition( ((AdditionTerm)thisTerm).getRightSummand() ) );

		} else if ( thisTerm instanceof SubtractionTerm ) {
			summands.addAll( splitTermOnAddition( ((SubtractionTerm)thisTerm).getMinuend() ) );

			NegativeTerm negativeRHS = new NegativeTerm( ((SubtractionTerm)thisTerm).getSubtrahend() );
			summands.addAll( splitTermOnAddition( negativeRHS.distributeMultiplication() ) );

		} else {
			summands.add( thisTerm );

		}

		return summands;
	}
	
	public static ArrayList<Term> splitTermOnMultiplication( Term thisTerm ) {
		ArrayList<Term> factors = new ArrayList<>();

		if ( thisTerm.operatorEquals("*") ) {
			factors.addAll( splitTermOnMultiplication( ((MultiplicationTerm)thisTerm).getLeftFactor() ) );
			factors.addAll( splitTermOnMultiplication( ((MultiplicationTerm)thisTerm).getRightFactor() ) );

		} else if ( thisTerm.operatorEquals("-")
				&& thisTerm.getSubTerms().size() == 1) {
			factors.add( new Real("-1"));
			factors.addAll( splitTermOnMultiplication( ((NegativeTerm)thisTerm).getNegatedTerm() ) );
		
		} else {
			factors.add( thisTerm );

		}

		return factors;
	}

	//public static Term distributeMultiplication( Term thisTerm ) {

	//	if ( thisTerm.operatorEquals("*") {
	//		MultiplicationTerm product = (MultiplicationTerm)thisTerm;

	//		Term leftFactor = product.getLeftFactor();
	//		Term rightFactor = product.getRightFactor();

	//		if ( rightFactor.operatorEquals("+") ) {
	//			// Return a new sum of the distributed products
	//			AdditionTerm distributeeSum = (AdditionTerm)rightFactor;

	//			MultiplicationTerm newLeftSummand = 
	//				new MulitplicationTerm( leftFactor,
	//							distributeeSum.getLeftSummand() );
	//			MulitplicationTerm newRightSummand =
	//				new MultiplicationTerm( leftFactor,
	//							distributeeSum.getRightSummand() );

	//			return new AdditionTerm(
	//				distributeMultiplication( newLeftSummand ),
	//				distributeMultiplication( newRightSummand ) );

	//		} else if ( rightFactor.operatorEquals("-")
	//				&& rightFactor.getArguments().size() > 1 ) {
	//			// Return a new difference of the distributed products
	//			AdditionTerm distributeeDifference = (SubtractionTerm)rightFactor;
	//			
	//			MulitplicationTerm newMinuend = 
	//				new MultiplicationTerm( leftFactor,
	//							distributeeDifference.getMinuend() );
	//			MultiplicationTerm newSubtrahend = 
	//				new MultiplicationTerm( leftFactor,
	//							distributeeDifference.getSubtrahend() );

	//			return new SubtractionTerm(
	//				distributeMultiplication( newMinuend ),
	//				distributeMultiplication( newSubtrahend ) );

	//		} else if ( leftFactor.operatorEquals("+") {


	//	} else {
	//		return thisTerm;
	//	}
//
	public static MatrixTerm extractLinearCoefficients( ExplicitODE ode, ArrayList<RealVariable> variables ) throws AnalyticsException {
		
		if ( !isLinearIn( ode, variables ) ){
			throw new AnalyticsException( "ODE is not even linear!" );
		}

		System.out.println("WARNING: extractLinearCoefficients does not expand terms, so this will only work if your ode expression is expanded");
		System.out.println("ode is: " + ode);
		System.out.println("rhs is: " + ode.getRHS() );

		ArrayList<Term> additiveTerms = splitTermOnAddition( ode.getRHS() );
		MatrixTerm coefficients = new MatrixTerm( 1, variables.size() );

		ArrayList<Term> subFactors;
		RealVariable thisVariable;
		for ( Term thisSummand : additiveTerms ) {
			
			System.out.println("this summand is: " + thisSummand.toString());
			subFactors = splitTermOnMultiplication( thisSummand );
			System.out.println("subfactors before removing anything: " + subFactors.toString() );

			System.out.println("variables size: " + variables.size());
			for ( int j = 1; j < variables.size() + 1; j ++ ) {
				if ( subFactors.contains( variables.get( j - 1 ) ) ) {
					subFactors.remove( variables.get( j - 1 ) );
					System.out.println("subfactors after removing var: " + subFactors.toString() );
					System.out.println("subfactor size: " + subFactors.size() );


					if ( subFactors.size() == 0 ) {
						coefficients.setElement( 1, j, new Real(1) );
					} else {
						coefficients.setElement( 1, j, new MultiplicationTerm( subFactors ) );
					}

				}
			}

		}
		return coefficients;
	}

//
	public static MatrixTerm extractLinearCoefficients( ContinuousProgram continousProgram, ArrayList<RealVariable> variables ) throws AnalyticsException {
		// A challenge when getting this method to work was ensuring that the column-order of the variables
		// is the same as the row-order of the variables. The variables in the ArrayList passed in here are in some order,
		// and I need to make sure that the row corresponding to each ODE is put at the same index.

		if ( !isLinearIn( continousProgram, variables ) ){
			throw new AnalyticsException( "Continuous program is not even linear!" );
		}

		System.out.println("WARNING: extractLinearCoefficients does not expand terms, so this will only work if your ode expression is expanded");

		ArrayList<ExplicitODE> odeList = continousProgram.getODEs();
		HashMap<RealVariable, MatrixTerm> rows = new HashMap<>();
		for ( ExplicitODE thisODE : odeList ) {
			rows.put( thisODE.getLHS(), extractLinearCoefficients( thisODE, variables ) );
		}

		MatrixTerm coefficients = new MatrixTerm( 0, variables.size() );
		for ( int v = 0; v < variables.size(); v ++ ) {
			coefficients = coefficients.addAsRow( rows.get( variables.get( v ) ) );
		}

		return coefficients;
	}

	//public static MatrixTerm extractLinearCoefficients( ContinuousProgram continousProgram, ColumnVector stateVector ) throws Exception {
	//	return extractLinearCoefficients( continuousProgram, stateVector.toArrayList() );
	//}

// Not currently useful because of difficulties between RealVariable, Terms, and casting
	//public static ColumnVector getStateVector( ContinuousProgram continuousProgram ) {
	//	Set<RealVariable> stateSet = continuousProgram.getDynamicVariables();

	//	ArrayList<Term> states = new ArrayList<>();
	//	states.addAll( stateSet );
	//	Collections.reverse( states );

	//	ColumnVector stateVector = new ColumnVector( states );

	//	return stateVector;
	//}

	public static ArrayList<RealVariable> getStateList( ContinuousProgram continuousProgram ) {
		Set<RealVariable> stateSet = continuousProgram.getDynamicVariables();
		ArrayList<RealVariable> states = new ArrayList<>();
		states.addAll( stateSet );

		Collections.reverse( states );

		return states;
	}

	public static ArrayList<RealVariable> getStateList( HybridProgram hybridProgram ) {
		Set<RealVariable> stateSet = hybridProgram.getDynamicVariables();
		ArrayList<RealVariable> states = new ArrayList<>();
		states.addAll( stateSet );

		Collections.reverse( states );

		return states;
	}

}

