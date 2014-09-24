package hephaestos.languages.fol;
import java.util.*;


public class AndFOLFormula extends FOLFormula {
	boolean debug = false;

// Constructors and field getters
	public AndFOLFormula ( FOLFormula leftChild, FOLFormula rightChild ) {
		operator = new Operator("and", 2, true); //

		children = new ArrayList<dLStructure>();
		children.add( leftChild );
		children.add( rightChild );
	}

	public FOLFormula getLHS() {
		return (FOLFormula)(children.get(0));
	}

	public FOLFormula getRHS() {
		return (FOLFormula)(children.get(1));
	}

// Substitution method
	public AndFOLFormula substituteConcreteValuation( Valuation substitution ) {
		AndFOLFormula substitutedFOLFormula =  new AndFOLFormula( getLHS().substituteConcreteValuation( substitution ), 
							getRHS().substituteConcreteValuation( substitution ) );
		if( debug ) {
			System.out.println("Returning AndFOLFormula: " + substitutedFOLFormula.toMathematicaString() );
		}
		return substitutedFOLFormula;
	}

// Clone method
	public AndFOLFormula clone() {
		return new AndFOLFormula( getLHS().clone(), getRHS().clone() );
	}

// String methods
	public String toKeYmaeraString () {
		return "( " + getLHS().toKeYmaeraString() + " & " + getRHS().toKeYmaeraString() + " )";
	}

	public String toManticoreString () {
		return "( " + getLHS().toManticoreString() + " & " + getRHS().toManticoreString() + " )";
	}

	public String toMathematicaString () {
		return "( " + getLHS().toMathematicaString() + " && " + getRHS().toMathematicaString() + " )";
	}
    
	public String todRealString () {
		return "(and " + getLHS().todRealString() + " " + getRHS().todRealString() + " )";
	}

// Assorted convenience functions
	public boolean isFirstOrder() {
		return (getLHS().isFirstOrder() && getRHS().isFirstOrder() );
	}

	public boolean isModal() {
		return (getLHS().isModal() && getRHS().isModal() );
	}

	public boolean isStatic() {
		return (getLHS().isStatic() && getRHS().isStatic());
	}

	public boolean isQuantifierFree() {
		return (getLHS().isQuantifierFree() && getRHS().isQuantifierFree());
	}

// Logical manipulations
	public OrFOLFormula negate() {
		return new OrFOLFormula( getLHS().negate(), getRHS().negate() );
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

