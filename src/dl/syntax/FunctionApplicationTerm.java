package proteus.dl.syntax;

import java.util.*;

public class FunctionApplicationTerm extends Term {

	public FunctionApplicationTerm ( Operator operator, ArrayList<Term> subTerms ) {
		this.operator = operator;
		spawnArguments();
		addSubTerms( subTerms );
	}

}
