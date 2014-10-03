package proteus.logicsolvers.abstractions;

import proteus.dl.syntax.*;
import proteus.dl.semantics.*;
import java.util.*;

public abstract class ProblemStatement {
	public List<RealVariable> stateVariables;
	public List<RealVariable> eiParameters;
	public dLFormula envelope;
	public dLFormula invariant;
	public dLFormula robustParameters;
	public dLFormula domain;
}
