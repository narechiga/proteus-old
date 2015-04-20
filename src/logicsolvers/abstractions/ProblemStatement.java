package proteus.logicsolvers.abstractions;

import proteus.dl.syntax.*;
import proteus.dl.semantics.*;
import java.util.*;

public abstract class ProblemStatement {
	public List<RealVariable> stateVariables;
	public dLFormula initialSet;
	public dLFormula safeSet;
	public List<RealVariable> eiParameters;
	public dLFormula eiParameterSet;
	public dLFormula envelope;
	public dLFormula invariant;
	public dLFormula control;
}
