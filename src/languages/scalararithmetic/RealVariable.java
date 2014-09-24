package hephaestos.languages.scalararithmetic;

import java.util.*;

public class RealVariable extends ScalarTerm {

	String name;

// Constructor
	public RealVariable ( String name ) {
		this.name = name;
	}

// equals
	public boolean equals( Object otherObject ) {
		if ( otherObject instanceof RealVariable ) {
			return name.equals( ((RealVariable)otherObject).name );
		} else {
			return false;
		}
	}

// hashCode
	public int hashCode() {
		return name.hashCode();
	}

// Clone
	public RealVariable clone() {
		return new RealVariable( this.name );
		
	}

// Logic
	public ArrayList<ScalarTerm> getSubTerms() {
		return new ArrayList<ScalarTerm>();
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.add( this );
		return freeVariables;
	}

// String methods
	public String toKeYmaeraString() {
		return name;
	}

	public String toMathematicaString() {
		return name;
	}

	public String todRealString() {
		return name;
	}


}

