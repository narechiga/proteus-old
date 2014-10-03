package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class RealVariable extends Term {

// Constructor
	public RealVariable ( String name ) {
		operator = new Operator( name, 0 );
		arguments = null;
	}

	public boolean isAVariable() {
		return true;
	}

// equals
	public boolean equals( Object otherObject ) {
		if ( otherObject instanceof RealVariable ) {
			return operator.equals( ((RealVariable)otherObject).operator );
		} else {
			return false;
		}
	}

	public Term substituteConcreteValuation( Valuation substitution ) {
		if ( substitution == null ) {
			return this;
		} else if ( substitution.get( this ) != null ) {
			return substitution.get( this );
		} else {
			return this.clone();
		}
	}

// hashCode
	public int hashCode() {
		return operator.toString().hashCode();
	}

// String methods
	public String toKeYmaeraString() {
		return operator.toKeYmaeraString();
	}

	public String toManticoreString() {
		return operator.toManticoreString();
	}

	public String toMathematicaString() {
		return operator.toMathematicaString();
	}

	public String todRealString() {
		return operator.todRealString();
	}

// Clone
	public RealVariable clone() {
		return new RealVariable( this.operator.toString() );
		
	}

// Logic
	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables 
			= new HashSet<RealVariable>();
		freeVariables.add( this.clone() );
		return freeVariables;
	}

// Arithmetic
	public Term distributeMultiplication() {
		return this.clone();
	}

// Arithmetic Analysis
	public boolean isLinearIn( ArrayList<RealVariable> variables ) {
		if ( variables.contains( this ) ) {
			return true;

		} else {
			return false;

		}
	}

	public boolean isAffineIn( ArrayList<RealVariable> variables ) {
		// If this variable is one of the variables of interest, 
		// it is linear and hence affine. 
		// If it is not one of the variables of interest, 
		// then it is affine because it is an additive constant
		// with respect to the variables of interest.

		return true;
	}
	

}

