package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class RepetitionProgram extends HybridProgram {

	//ArrayList<HybridProgram> arguments;

	public RepetitionProgram( HybridProgram onlyArgument ) {

		this.operator = new Operator("repeat", 1);

		this.arguments = new ArrayList<dLStructure>();
		this.arguments.add( onlyArgument );
	}

	public HybridProgram getProgram() {
		return (HybridProgram)(arguments.get(0));
	}

// Substitution method
	public RepetitionProgram substituteConcreteValuation( Valuation substitution ) {
		return new RepetitionProgram( getProgram().substituteConcreteValuation( substitution ) );
	}

// Clone method
	public RepetitionProgram clone() {
		return new RepetitionProgram( getProgram().clone() );
	}

// String methods
	public String toKeYmaeraString() {
		return "(" + getProgram().toKeYmaeraString() + "*)";
	}

	public String toManticoreString() {
		return "(" + getProgram().toManticoreString() + "***)";
	}


// Assorted convenience functions
	public boolean isPurelyContinuous() {
		return false;
	}

	public boolean isPurelyDiscrete() {
		return getProgram().isPurelyDiscrete();
	}

	public boolean isHybrid() {
		if ( (!isPurelyContinuous()) && (!isPurelyDiscrete()) ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isProgramPrimitive() {
		return false;
	}

	public boolean isQuantifierFree() {
		return getProgram().isQuantifierFree();
	}

	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.addAll( getProgram().getBoundVariables() );
		return boundVariables;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getProgram().getFreeVariables() );
		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
                HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
                dynamicVariables.addAll( getProgram().getDynamicVariables() );
                return dynamicVariables;
        }


}
