package manticore.dl;

public class SymbolicMatrix extends Term {

	// In order to preserve the low-level interface to a "children" list
	// of the arguments, a matrix is a "list" of column vectors, i.e. a vector
	// of vectors

	int numRows;
	int numColumns;

	public SymbolicMatrix ( int rows, int columns ) {
		children = new ArrayList<dLStructure>( rows*columns );
	}

	public SymbolicMatrix ( ArrayList<ArrayList<Term>> matrix  ) {

	}

	public Term getElement( int row, int column ) {
		
	}

	public void setElement( int row, int column, Term element ) {
	}

	protected int getArrayIndex( int row, int column ) {
	}

}
