package test.code.util;

import test.code.entity.Cell;
import test.code.entity.Grid;
import test.code.exception.GridException;
/**
 * Utility class to print the matrix
 * */
public class Print {

	
	
	private int rowSize;
	private int colSize;
	
	//print method take an input of grid type
	public void print(Grid matrix) {
		try {
		
			//setting rowSize and colSize
		rowSize= matrix.getRowSize();
		colSize= matrix.getColSize();
		
		//printing
		 for (int row = 0; row < rowSize; row++)
		  {
		    for (int col = 0; col < colSize; col++)
		    {
		      System.out.print(matrix.getCell(row, col).getValue()+" ");
		    }
		    System.out.println();
		  }
		}
		//throw a custom GridExcption  if encounter an exception
		catch (Exception exception) {
			throw new GridException("Encounter an exception while printing matrix");
		}
	}
	
}
