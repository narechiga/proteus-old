package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;


public class ForAllFormula extends dLFormula {

// Constructors and field getters
	public ForAllFormula ( RealVariable quantifiedVariable, dLFormula quantifiedFormula ) {
		operator = new Operator("forall"); //

		arguments = new ArrayList<dLStructure>();
		arguments.add( quantifiedVariable );
		arguments.add( quantifiedFormula );
	}

	public ForAllFormula( List<RealVariable> variables, dLFormula formula ) {

		ForAllFormula quantifiedFormula = null;

		if ( variables.isEmpty() ) {
			if ( formula instanceof ForAllFormula ) {
				quantifiedFormula = (ForAllFormula)formula;
			} 

		} else {
			RealVariable thisVariable = variables.remove(0);
			quantifiedFormula = 
				new ForAllFormula( thisVariable,
						new ForAllFormula( variables, formula ) );
		}

		//return quantifiedFormula;		
	}

	public RealVariable getVariable() {
		return ((RealVariable)(arguments.get(0))).clone();
	}

	public dLFormula getFormula() {
		return ((dLFormula)(arguments.get(1))).clone();
	}

	public ForAllFormula substituteConcreteValuation( Valuation substitution ) {
		if ( substitution.containsVariable( getVariable() ) ) {
			return this.clone();
		} else {
			return new ForAllFormula( getVariable().clone(),
						getFormula().substituteConcreteValuation( substitution ) );
		}
	}

	public ForAllFormula replace( Replacement replacement ) {
		if ( replacement.containsVariable( getVariable() ) ) {
			return this.clone();
		} else {
			return new ForAllFormula( getVariable(),
						getFormula().replace( replacement ) );
		}
	}

	public ForAllFormula clone() {
		return new ForAllFormula( getVariable().clone(), getFormula().clone() );
	}

// String methods
	public String toKeYmaeraString () {
		return "(\\forall R " + getVariable().toKeYmaeraString() + "; " + getFormula().toKeYmaeraString() +" )";
	}

	public String toManticoreString () {
		return "(\\forall R " + getVariable().toManticoreString() + "; " + getFormula().toManticoreString() +" )";
	}

	public String toMathematicaString () {
		return "ForAll[ " + getVariable().toMathematicaString() + ", " + getFormula().toMathematicaString() +" ]";
	}

// Assorted convenience functions
	public boolean isFirstOrder() {
		return getFormula().isFirstOrder();
	}
	
	public boolean isModal() {
		return getFormula().isModal();
	}

	public boolean isStatic() {
		return getFormula().isStatic();
	}

	public boolean isQuantifierFree() {
		return false;
	}

// Logic
	public ExistsFormula negate() {
		return new ExistsFormula( getVariable(), getFormula().negate() );
	}

	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.add( getVariable() );
		boundVariables.addAll( getFormula().getBoundVariables() );
		return boundVariables;
	}


	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> realVariables = new HashSet<RealVariable>();
		realVariables.addAll( getFormula().getFreeVariables() );
		realVariables.remove( getVariable() );
		return realVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		dynamicVariables.addAll( getFormula().getDynamicVariables() );
		return dynamicVariables;
	}
}


