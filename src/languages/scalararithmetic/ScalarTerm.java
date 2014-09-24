package hephaestos.languages.scalararithmetic;

import hephaestos.languages.abstractions.*;
import java.util.*;

public abstract class ScalarTerm extends Term {

	public abstract ArrayList<ScalarTerm> getSubTerms();
	public abstract Set<RealVariable> getFreeVariables();

	public abstract ScalarTerm clone();

	public abstract String toMathematicaString();
	public abstract String toKeYmaeraString();
	public abstract String todRealString();
}
