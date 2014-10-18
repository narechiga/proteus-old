package proteus.dl.syntax;

import proteus.dl.semantics.*;

public abstract class BallFormula extends ComparisonFormula {

	protected Real radius;
	protected Valuation center;

	public Real getRadius() {
		return radius;
	}

	public Valuation getCenter() {
		return center;
	}


}
