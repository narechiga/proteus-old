package manticore.dl;

public class SymbolicVector extends Term {
	 
	public SymbolicVector( int length ) {
	 	 children = new ArrayList<Term>( length );
	 }

	public SymbolicVector( ArrayList<Term> list ) {
	 	 children = list;
	 }

	public Term getElement( int index ) {
	 	 return children.get( index );
	 }

	public void setElement( int index, Term term ) {
	 	 children.set( index, term );
	 }

	public 

	/*
	 clone
	 equals
	 substituteConcreteValuation
	 */

}


