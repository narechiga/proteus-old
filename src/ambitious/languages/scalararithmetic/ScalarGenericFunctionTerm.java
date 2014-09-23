package hephaestos.languages.scalararithmetic;

public class ScalarGenericFunctionTerm extends ScalarTerm {
	
	protected String functionName;
	protected ArrayList<ScalarTerm> arguments;

	public ScalarGenericFunctionTerm( String functionName, ArrayList<ScalarTerm> arguments ) {
		this.functionName = functionName;
		this.arguments = arguments;
	}

	public String getFunctionName() {
		return functionName;
	}

	public ArrayList<ScalarTerm> getArguments() {
		return arguments;
	}

	public ArrayList<ScalarTerm> getSubTerms() {
		return arguments;
	}

}

