
package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class TestProgram extends DiscreteProgram {


	public TestProgram( dLStructure onlyArgument ) {
		operator = new Operator( "test" );

		arguments = new ArrayList<dLStructure>();
		arguments.add( onlyArgument );
	}

	public dLFormula getFormula() {
		return (dLFormula)(arguments.get(0));
	}

// Substitute
	public TestProgram substituteConcreteValuation( Valuation substitution ) {
		return new TestProgram( getFormula().substituteConcreteValuation( substitution ) );
	}

// Clone
	public TestProgram clone() {
		return new TestProgram( getFormula().clone() );
	}

// String methods
	public String toKeYmaeraString() {
		return "(? " + getFormula().toKeYmaeraString() + " )";
	}

	public String toManticoreString() {
		return "(? " + getFormula().toManticoreString() + " )";
	}

// Administrative
	public boolean isPurelyDiscrete() {
		return true;
	}

	public boolean isProgramPrimitive() {
		return true;
	}

	public boolean isQuantifierFree() {
		return getFormula().isQuantifierFree();
	}

	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.addAll( getFormula().getBoundVariables() );
		return boundVariables;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getFormula().getFreeVariables() );
		return freeVariables;
	}

        public Set<RealVariable> getDynamicVariables() {
                HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
                dynamicVariables.addAll( getFormula().getDynamicVariables() );
                return dynamicVariables;
        }

}
