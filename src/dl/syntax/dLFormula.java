package proteus.dl.syntax;

import proteus.dl.semantics.*;

import java.io.*;
import java.util.*;

public abstract class dLFormula extends dLStructure {

	public boolean isFirstOrder() {
		return false;
	}

	public boolean isModal() {
		return false;
	}

	public boolean isPropositionalPrimitive() {
		return false;
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isQuantifierFree() {
		return false;
	}

//	public abstract boolean isPurelyExistentiallyQuanfied() {
//	}
//
//	public abstract boolean isPurelyUniversallyQuantified() {
//	}


// All subclasses need to implement this guy
	public abstract dLFormula clone();

	public abstract dLFormula substituteConcreteValuation( Valuation substitution );

// Logic
	public abstract dLFormula negate();

	public boolean isClosedFormula() { // A formula is closed if it has no free variables
		if ( this.getFreeVariables().isEmpty() ) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<dLFormula> splitOnAnds () {
                ArrayList<dLFormula> subFormulas = new ArrayList<dLFormula>();

                if ( !( this instanceof AndFormula ) ) {                                                                 
                        subFormulas.add( this );                                                                        
                } else {
                        subFormulas.addAll( ((AndFormula)this ).getLHS().splitOnAnds() );                               
                        subFormulas.addAll( ((AndFormula)this ).getRHS().splitOnAnds()  );                               
                }

                return subFormulas;
        }           

        public ForAllFormula universalClosure() {
        	return universalClosure( this, 
        		new ArrayList<RealVariable>( this.getFreeVariables() ) );
        	//dLFormula uC;
        	//if ( this.isClosedFormula() ) {
        	//	uC = this.clone();
		//} else {
		//	uC = this.clone();
		//	Iterator<RealVariable> fVi = this.getFreeVariables().iterator();
		//	while ( fVi.hasNext() ) {
		//		uC = new ForAllFormula( fVi.next().clone(), uC );
		//	}
		//}
		//return uC;
	}

	public ForAllFormula universalClosure( ArrayList<RealVariable> qvars ) {
		dLFormula uC = this.clone();
		for ( RealVariable var : qvars ) {
			if ( this.getFreeVariables().contains( var ) ){
				uC = new ForAllFormula( var.clone(), uC );
			}
		}
		return uC;
	}

	public ExistsFormula existentialClosure( ArrayList<RealVariable> qvars ) {
		dLFormula eC = this.clone();
		for ( RealVariable var : qvars ) {
			if ( this.getFreeVariables().contains( var ) ){
				eC = new ExistsFormula( var.clone(), eC );
			}
		}
		return eC;
	}

        public ExistsFormula existentialClosure() {
        	return existentialClosure( this, 
        		new ArrayList<RealVariable>( this.getFreeVariables() ) );
        	//dLFormula eC;
        	//if ( this.isClosedFormula() ) {
        	//	eC = this.clone();
		//} else {
		//	eC = this.clone();
		//	Iterator<RealVariable> fVi = this.getFreeVariables().iterator();
		//	while ( fVi.hasNext() ) {
		//		eC = new ExistsFormula( fVi.next().clone(), eC );
		//	}
		//}
		//return eC;
	}





	//public Set<RealVariable> getBoundVariables() {
	//	return new HashSet();
	//}


//	public simplifyOrFalse() {
//		if ( !(this instanceof OrFormula) && this.isPropositionalPrimitive() ) {
//			return this.clone();	
//		} else if ( !(this instanceof OrFormula) ) {
//		}
//
//
//
//	}

}
