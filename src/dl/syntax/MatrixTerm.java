package proteus.dl.syntax;

import proteus.dl.semantics.*;
import java.util.*;

public class MatrixTerm extends NonScalarTerm {

	int numRows;
	int numColumns;

// Constructors
	public MatrixTerm ( int rows, int columns ) {
		numColumns = columns;
		numRows = rows;

		// Correct type of chiildren will be enforced when adding elements
		// to it -- only terms may be added.
		spawnArguments();
	}

	protected MatrixTerm ( int rows, int columns, List<dLStructure> matrix  ) {

		arguments = new ArrayList<dLStructure>();

		Iterator<dLStructure> matrixIterator = matrix.iterator();
		while( matrixIterator.hasNext() ) {
			arguments.add( (Term)(matrixIterator.next()) );
		}

		numRows = rows;
		numColumns = columns;

	}

	protected int computeArgumentIndex( int row, int column ) {
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
		return ((Term)(getArgument( computeArgumentIndex( row, column ) )));
	}

	public void setElement( int row, int column, Term element ) {
		setArgument( computeArgumentIndex( row, column ), element );
	}

// Get rows and columns
	public MatrixTerm getRow( int row ) {
		// Recall that sublist is inclusive in the first index and exclusive
		// in the second index. This way we get from the first element of the
		// desired row (inclusive) to the first element of the next row (exclusive)
		return new MatrixTerm( 1, this.getNumColumns(), arguments.subList( 
							computeArgumentIndex( row, 1 ),
							computeArgumentIndex( row + 1, 1 ) ) );
	}

	public MatrixTerm getColumn( int column ) {
		// Gets a row of the transpose, which is our column.
		MatrixTerm thisTranspose = this.transpose();
		MatrixTerm thisTransposeRow = thisTranspose.getRow( column );
		
		return thisTransposeRow.transpose();
	}

	public MatrixTerm getRowsMatrix( int lowerRow, int upperRow ) throws Exception {
		// Returns the submatrix consisting of the rows from lowerRow to upperRow,
		// inclusive for both.
		
		MatrixTerm rowsMatrix = new MatrixTerm( upperRow - lowerRow + 1, getNumColumns() );

		for ( int i = lowerRow; i < upperRow + 1; i++ ) {
			rowsMatrix.addAsRow( getRow( i ) );
		}

		return rowsMatrix;
	}

	public MatrixTerm getColumnsMatrix( int lowerColumn, int upperColumn ) throws Exception {
		// Returns the submatrix consisting of the columns from lowerColumn to upperColumn,
		// inclusive for both.

		MatrixTerm columnsMatrix = new MatrixTerm( getNumRows(), upperColumn - lowerColumn + 1);

		for ( int j = lowerColumn; j < upperColumn + 1; j++ ) {
			columnsMatrix.addAsColumn( getColumn( j ) );
		}

		return columnsMatrix;
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
		return new MatrixTerm( getRows(), getColumns(), cloneArguments() );
	}

	public ArrayList<Term> toArrayList() {
		ArrayList<Term> termArray = new ArrayList<>();

		// Enforce that we return terms!
		Iterator<dLStructure> childIterator = arguments.iterator();
		while ( childIterator.hasNext() ) {
			termArray.add( (Term)(childIterator.next()) );
		}

		return termArray;
	}

	public Set<RealVariable> getFreeVariables() {
		HashSet<RealVariable> freeVariables;

		ArrayList<Term> entries = toArrayList();
		Iterator<Term> entryIterator = entries.iterator();

		while( entryIterator.hasNext() ) {
			freeVariables.addAll( entryIterator.next().getFreeVariables() );
		}

		return freeVariables;
	}

	public Set<RealVariable> getDynamicVariables() {
		// Same as the corresponding method for a term
		HashSet<RealVariable> dynamicVariables = new HashSet<RealVariable>();
		return dynamicVariables;
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
			ArrayList<dLStructure> newArguments = this.cloneArguments();
			newArguments.addAll( anotherMatrix.toArrayList() );

			return new MatrixTerm( getNumRows() + anotherMatrix.getNumRows(),
						getNumColumns(),
						newArguments );

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
