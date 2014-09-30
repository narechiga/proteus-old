package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public class MultiplicationTerm extends Term {

	public MultiplicationTerm( Term leftFactor, Term rightFactor ) {
		this.operator = new Operator("*", 2, true);

		spawnArguments();
		addArgument( leftFactor );
		addArgument( rightFactor );
	}

	public MultiplicationTerm( ArrayList<Term> subterms ) {
		this.operator = new Operator("*", 2, true);
		spawnArguments();

		if ( subterms.size() == 2 ) {
			addArgument( subterms.get( 0 ) );
			addArgument( subterms.get( 1 ) );

		} else if ( subterms.size() > 2 ) {
			addArgument( subterms.remove( 0 ) );
			addArgument( new MultiplicationTerm( subterms ) );

		} else if ( subterms.size() == 1 ) {
			addArgument( new Real("1") );
			addArgument( subterms.get( 0 ) );

		} else if ( subterms.size() == 0 ) {
			throw new RuntimeException("Refusing to create multiplication term from empty list of subterms");
			//spawnArguments();
			//addArgument( new Real("0") );
			//addArgument( new Real("0") );

		}
			
	}


// Getters
	public Term getLeftFactor() {
	       return (Term)getArgument( 0 );
	}

	public Term getRightFactor() {
		return (Term)getArgument( 1 );
	}

// Clone
	public MultiplicationTerm clone() {
		return new MultiplicationTerm( getLeftFactor(), getRightFactor() );
	}

	public static void main( String [] args ) {
		ArrayList<Term> mySubterms = new ArrayList<>();

		mySubterms.add( new Real("1") );
		mySubterms.add( new Real("2") );
		mySubterms.add( new Real("42") );

		MultiplicationTerm myProduct = new MultiplicationTerm( mySubterms );
		System.out.println( myProduct.toMathematicaString() );
	}

		

}

