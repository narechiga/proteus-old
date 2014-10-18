
package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class ArbitraryAssignmentProgram extends DiscreteProgram {

	public ArbitraryAssignmentProgram( RealVariable child ) {
		operator = new Operator( "arbitrary-assign", 1, true );

		arguments = new ArrayList<dLStructure>();
		arguments.add( child );
	}

	public RealVariable getLHS() {
		return (RealVariable)arguments.get(0);
	}


// Substitution method
	public ArbitraryAssignmentProgram substituteConcreteValuation( Valuation substitution ) {
		return this;
	}

// Clone method
	public ArbitraryAssignmentProgram clone() {
		return new ArbitraryAssignmentProgram( getLHS().clone() );
	}

// String methods
	public String toKeYmaeraString() {
		return "( " + getLHS().toKeYmaeraString() + " := * )";
	}
	
	public String toManticoreString() {
		return "( " + getLHS().toManticoreString() + " := ** )";
	}

// Administrative
	public boolean isPurelyDiscrete() {
		return true;
	}

	public boolean isProgramPrimitive() {
		return true;
	}

	public boolean isQuantifierFree() {
		return true;
	}

// public Set<RealVariable> getBoundVariables();
// Assignment program cannot bind any variables, so we do not return any bound variables

	public Set<RealVariable> getFreeVariables() {
		return getLHS().getFreeVariables();
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		dynamicVariables.add( getLHS() );
		return dynamicVariables;
	}
	
	public Set<RealVariable> getPurelyDiscreteVariables() {
		return getDynamicVariables();
	}

	public Set<RealVariable> getPurelyContinuousVariables() {
		return new HashSet<RealVariable>();
	}

	public Set<RealVariable> getHybridVariables() {
		return new HashSet<RealVariable>();
	}

}
