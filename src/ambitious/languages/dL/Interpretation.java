package manticore.dl;

import java.util.*;

public interface Interpretation {

	public Term evaluateTerm( Term thisTerm, Valuation valuation ) throws Exception;
	public Boolean evaluateFormula( dLFormula thisFormula, Valuation valuation ) throws Exception;

}
