package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.util.*;

public class ExplicitODE extends dLStructure {

// Constructors and field getters
	public ExplicitODE ( RealVariable lhs, Term rhs ) {
		operator = new Operator( "explicit-ode" );

		arguments = new ArrayList<dLStructure>();
		arguments.add( lhs );
		arguments.add( rhs );

	}

	//public ExplicitODE ( dLStructure lhs, dLStructure rhs ) {
	//	operator = new Operator( "explicit-ode" );

	//	arguments = new ArrayList<dLStructure>();
	//	arguments.add( lhs );
	//	arguments.add( rhs );

	//}

	public RealVariable getLHS() {
		return (RealVariable)(arguments.get(0));
	}

	public Term getRHS() {
		return (Term)(arguments.get(1));
	}

// Substitution method
	public ExplicitODE substituteConcreteValuation( Valuation substitution ) {
		return new ExplicitODE( getLHS().clone(),
					getRHS().substituteConcreteValuation( substitution ) );
	}

// Clone method
	public ExplicitODE clone() {
		return new ExplicitODE( getLHS().clone(), getRHS().clone() );
	}

// String methods
	public String toInfix() {
		return toString();
	}

	public String toKeYmaeraString () {
		String returnString = "";

		returnString = returnString + getLHS().toKeYmaeraString() + "' = " + getRHS().toKeYmaeraString();

		return returnString;
	}
// Logic
	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables = new HashSet<RealVariable>();
		freeVariables.addAll( getLHS().getFreeVariables() );
		freeVariables.addAll( getRHS().getFreeVariables() );
		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		dynamicVariables.add( getLHS() );
		return dynamicVariables;
	}


}
