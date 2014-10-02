package proteus.dl.syntax;

import java.util.*;

public class FunctionApplicationTerm extends Term {

	public FunctionApplicationTerm ( Operator operator, ArrayList<Term> subTerms ) {
		this.operator = operator;
		spawnArguments();
		addSubTerms( subTerms );
	}

	public Term clone() {
		ArrayList<Term> newSubTerms = new ArrayList<>();

		Iterator<Term> subTermIterator = getSubTerms().iterator();
		while( subTermIterator.hasNext() ) {
			newSubTerms.add( subTermIterator.next().clone() );
		}

		return new FunctionApplicationTerm( operator.clone(), newSubTerms );
	}

	public Term distributeMultiplication() {
		return this.clone();
	}

}
