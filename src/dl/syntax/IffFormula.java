package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;


public class IffFormula extends dLFormula {

// Constructor and field getters
	public IffFormula ( dLFormula antecedent, dLFormula succedent ) {
		operator = new Operator("iff", 2, true); //

		arguments = new ArrayList<dLStructure>();
		arguments.add( antecedent );
		arguments.add( succedent );
	}

	public dLFormula getAntecedent() {
		return ((dLFormula)(arguments.get(0))).clone();
	}

	public dLFormula getSuccedent() {
		return ((dLFormula)(arguments.get(1))).clone();
	}

	public dLFormula getLHS() {
		return getAntecedent(); 
	}

	public dLFormula getRHS() {
		return getSuccedent();
 	}


// Substitution method
	public IffFormula substituteConcreteValuation( Valuation substitution ) {
		return new IffFormula( getAntecedent().substituteConcreteValuation( substitution ),
					getSuccedent().substituteConcreteValuation( substitution ) );
	}

	public IffFormula replace( Replacement replacement ) {
		return new IffFormula( getAntecedent().replace( replacement ),
					getSuccedent().replace( replacement ) );
	}
// Clone method
	public IffFormula clone() {
		return new IffFormula( getAntecedent().clone(), getSuccedent().clone() );
	}

// String methods
	public String toKeYmaeraString () {
		return "( " + getAntecedent().toKeYmaeraString() + " <-> " + getSuccedent().toKeYmaeraString() + " )";
	}

	public String toManticoreString () {
		return "( " + getAntecedent().toManticoreString() + " <-> " + getSuccedent().toManticoreString() + " )";
	}

	public String toMathematicaString () {
		return "Equivalent[ " + getAntecedent().toMathematicaString() 
				+ ", " + getSuccedent().toMathematicaString() + " ]";
	}

	public String todRealString () {
		AndFormula biimplies = new AndFormula( new ImpliesFormula( this.getAntecedent(), this.getSuccedent() ),
							new ImpliesFormula( this.getSuccedent(), this.getAntecedent() ) ) ;
		
		return biimplies.todRealString();
	}

// Assorted convenience functions
	public boolean isFirstOrder() {
		return (getAntecedent().isFirstOrder() && getSuccedent().isFirstOrder() );
	}

	public boolean isModal() {
		return (getAntecedent().isModal() && getSuccedent().isModal() );
	}

        public boolean isStatic() {
                return (getAntecedent().isStatic() && getSuccedent().isStatic());
        }

        public boolean isQuantifierFree() {
                return (getAntecedent().isQuantifierFree() && getSuccedent().isQuantifierFree());
        }
// Logic
	public OrFormula negate() {
		AndFormula biimplies = new AndFormula( new ImpliesFormula( this.getAntecedent(), this.getSuccedent() ),
							new ImpliesFormula( this.getSuccedent(), this.getAntecedent() ) ) ;
		return biimplies.negate();
	}
	
	public Set<RealVariable> getBoundVariables() {
		HashSet<RealVariable> boundVariables = new HashSet<RealVariable>();
		boundVariables.addAll( getLHS().getBoundVariables() );
		boundVariables.addAll( getRHS().getBoundVariables() );
		return boundVariables;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getLHS().getFreeVariables() );
		freeVariables.addAll( getRHS().getFreeVariables() );
		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		dynamicVariables.addAll( getLHS().getDynamicVariables() );
		dynamicVariables.addAll( getRHS().getDynamicVariables() );
		return dynamicVariables;
	}

}
