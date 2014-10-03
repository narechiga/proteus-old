package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public abstract class HybridProgram extends dLStructure {

// Specific classes override these.
	public boolean isPurelyContinuous() {
		return false;
	}

	public boolean isPurelyDiscrete() {
		return false;
	}

	public boolean isHybrid() {
		return false;
	}

	public boolean isProgramPrimitive() {
		return false;
	}

	public boolean isQuantifierFree() {
		return false;
	}

	public abstract HybridProgram substituteConcreteValuation( Valuation substitution );

	public abstract HybridProgram clone();

	public ArrayList<RealVariable> getStateList() {
		Set<RealVariable> stateSet = getDynamicVariables();
		ArrayList<RealVariable> states = new ArrayList<>();
		states.addAll( stateSet );

		Collections.reverse( states );

		return states;
	}

}
