package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public class MatrixTerm extends NonScalarTerm {

	// In order to preserve the low-level interface to a "children" list
	// of the arguments, a matrix is a "list" of column vectors

	int numRows;
	int numColumns;

	/* Note that VectorTerm is an internal class, not visible or usable
	 * by the rest of the world--only here for our convenience */
	ArrayList<ArrayList<Term>> rowVectors;
	ArrayList<ArrayList<Term>> columnVectors;


	// Stores the transpose of the matrix, for when it is needed
	ArrayList<Term> transposeArray;

// Constructors
	public MatrixTerm ( int rows, int columns ) {
		numColumns = columns;
		numRows = rows;

		// Correct type of chiildren will be enforced when adding elements
		// to it -- only terms may be added.
		spawnChildren();
	}

	//protected MatrixTerm ( int rows, int columns, ArrayList<Term> matrix  ) {

	//	spawnChildren();
	//	children.addAll( matrix );

	//	numRows = rows;
	//	numColumns = columns;

	//	transposeArray = computeTransposeArray();
	//}

	//protected MatrixTerm( int rows, int columns, ArrayList<ArrayList<Term>> matrix ) {

	//	// check if we are being fed a row matrix or a column matrix
	//	
	//}

// Internal functionality
	protected ArrayList<Term> computeTransposeArray() {
		ArrayList<Term> transposeList = new ArrayList<>( numRows*numColumns);

		for ( int i = 1; i < numRows + 1; i++ ) {
			for ( int j = 1; j < numColumns + 1; j++ ) {
				transposeList.set( computeChildIndex(j, i),
					getElement( i, j ) );
			}
		}

		return transposeList;
	}

	protected int computeChildIndex( int row, int column ) {
		return (row - 1)*numColumns + column - 1;
	}

// Basic getters and setters
	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public Term getElement( int row, int column ) {
		return ((Term)(getChild( computeChildIndex( row, column ) )));
	}

	public void setElement( int row, int column, Term element ) {
		setChild( computeChildIndex( row, column ), element );
	}

// Get rows and columns
	public MatrixTerm getRow( int row ) {
		return new MatrixTerm( 1, numColumns, rowVectors.get( row - 1 ) );
	}

	public MatrixTerm getColumn( int column ) {
		return new MatrixTerm( numRows, 1, columnVectors.get( column - 1 ) );
	}

	public MatrixTerm getRowsMatrix( int lowerRow, int upperRow ) {
		// Returns the submatrix consisting of the rows from lowerRow to upperRow,
		// inclusive for both.
		
		MatrixTerm rowsMatrix = new MatrixTerm();

		for ( int i = lowerRow; i < upperRow + 1; i++ ) {
			rowsMatrix.addAsRow( getRow( i ) );
		}
	}

	public MatrixTerm getColumnsMatrix( int lowerColumn, int upperColumn ) {
		// Returns the submatrix consisting of the columns from lowerColumn to upperColumn,
		// inclusive for both.

		MatrixTerm columnsMatrix = new MatrixTerm();

		for ( int j = lowerColumn; j < upperColumn + 1; j++ ) {
			columnsMatrix.addAsColumn( getColumn( j ) );
		}
	}

	public ArrayList<MatrixTerm> getRowsList( int lowerRow, int upperRow ) {
		ArrayList<MatrixTerm> rowsList = new ArrayList<MatrixTerm>();

		for ( int i = lowerRow; i < upperRow + 1; i++ ) {
			rowsList.add( getRow( i ) );	
		}

		return rowsList;
	}

	public ArrayList<MatrixTerm> getColumnsList( int lowerColumn, int upperColumn ) {
		ArrayList<MatrixTerm> columnsList = new ArrayList<MatrixTerm>();

		for ( int i = lowerColumn; i < upperColumn + 1; i++ ) {
			columnsList.add( getColumn( i ) );	
		}

		return columnsList;
	}

// String methods
	// TODO
	
// Convenience functions
	public MatrixTerm clone() {
		//TODO
		return null;
	}

	public ArrayList<Term> toArrayList() {
		return children;
	}

	public Set<RealVariable> getFreeVariables() {
		return null;
		// TODO
	}

	public Set<RealVariable> getDynamicVariables() {
		return null;
		// TODO
	}

// Manipulations
	public MatrixTerm transpose() {

		MatrixTerm newMatrix = new MatrixTerm( numColumns, numRows );

		for ( int i = 1; i < numRows + 1; i++ ) {
			for ( int j = 1; j < numColumns; j++ ) {
				newMatrix.setElement( j, i, this.getElement(i, j) );
			}
		}

		return newMatrix;
	}

	public MatrixTerm addAsRow( MatrixTerm anotherMatrix ) throws Exception {
		if ( this.getNumColumns() != anotherMatrix.getNumColumns() ) {
			throw new Exception("Matrix dimenstion mismatch when adding in row form");

		} else {
			children.addAll( anotherMatrix.toArrayList() );	

		}
	}

	public MatrixTerm addAsColumn( MatrixTerm anotherMatrix ) throws Exception {
		if ( this.getNumRows() != anotherMatrix.getNumRows() ) {
			throw new Exception("Matrix dimenstion mismatch when adding in column form");

		} else {
			MatrixTerm thisTranspose = this.transpose();
			MatrixTerm anotherTranspose = anotherMatrix.transpose();
			thisTranspose = thisTranspose.addAsRow( anotherTranspose );

			return thisTranspose.transpose();
		}
	}


}
