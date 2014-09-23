package hephaestos.languages.scalararithmetic;

import java.util.*;

public class Real extends ScalarTerm {

	String value;

// Constructors
	public Real ( String value ) {
		this.value = value;
	}

	public Real( Double value ) {
		Value = value.toString();
	}
	
	public Real( Float value ) {
		Value = value.toString();
	}

	public Real( Integer value ) {
		Value = value.toString();
	}

// Equality
	public boolean equals( Object otherObject ) {
		if ( otherObject instanceof Real ) {
			return value.equals( ((Real)otherObject).name );
		} else {
			return false;
		}
	}

// hashCode
	public int hashCode() {
		return value.toString().hashCode();
	}

// String methods
	public String toKeYmaeraString() {
		return value;
	}

	public String toMathematicaString() {
		return value;
	}

	public String todRealString() {
		return value;
	}

// Clone
	public Real clone() {
		return new Real( value );
	}

// toDouble
	public Double toDouble() throws Exception {
		return new Double( this.value.toString() );
	}

// Basic arithmetic
	public static Real add( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = aDouble + bDouble;
		return new Real( result.toString() );
	}

	public static Real subtract( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = aDouble - bDouble;
		return new Real( result.toString() );
	}

	public static Real multiply( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = aDouble * bDouble;
		return new Real( result.toString() );
	}

	public static Real divide( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = aDouble / bDouble;
		return new Real( result.toString() );
	}

	public static Real power( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = Math.pow(aDouble,bDouble);
		return new Real( result.toString() );
	}

	public static Real max( Real a, Real b ) {
		Double aDouble = new Double( a.value );
		Double bDouble = new Double( b.value );

		Double result = Math.min(aDouble,bDouble);
		return new Real( result.toString() );
	}

// Logic
	public ArrayList<ScalarTerm> getSubTerms() {
		return new ArrayList<ScalarTerm>();
	}

	public Set<RealVariable> getFreeVariables() {
		return new HashSet<RealVariable>();
	}

}

