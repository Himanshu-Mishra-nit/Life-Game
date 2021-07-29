package test.code.util;

import java.util.Scanner;

import test.code.entity.Cell;
import test.code.entity.Grid;
import test.code.exception.GridException;
import test.code.exception.InvalidInput;
/*
 * This is a utility class to take input
 * */
public class Input {

	//Creating new instance of Grid
	private Grid grid = new Grid();

	private int rowSize;
	private int colSize;
	private Grid matrix;

	private Scanner scan = new Scanner(System.in);

	public Grid input() {
		try {
			System.out.println("\n\n\n New Game \n\n\n");
			System.out.println(">>>>>\t\t Enter RowSize and ColomnSize of Matrix\n");
			System.out.print(">>>\t RowSize :");
			this.rowSize = scan.nextInt();
			System.out.println(">>>\t ColomnSize :");
			this.colSize = scan.nextInt();
			
			//creating matrix
			this.matrix = new Grid(rowSize, colSize);
			System.out.println(">>>>>\t\t Enter a single row of Matrix saparate by space\n");
			System.out.println("Examlple:0 1 0 0 1 0......");
			String rowString = scan.nextLine();
			
			//Tacking Input
			for (int row = 0; row < rowSize; row++) {
				rowString = scan.nextLine();

				//if string is null throw InvalidInput custom exception
				if (rowString.equals("") && colSize > 0) {
					throw new InvalidInput("Invalid stirng, input is null");
				}
				String[] rowArrayString = rowString.trim().split(" ");

				//if input length is less than requirement throw Invalud input custom exception
				if (rowArrayString.length < colSize - 1) {
					throw new InvalidInput("Invalid input, input String contiaing less number");
				}

				//tacking input 
				for (int col = 0; col < colSize; col++) {
					
					int value = Integer.parseInt(rowArrayString[col]);
					Cell cell = new Cell(value);
					matrix.setCell(row, col, cell);
				}

			}

			return matrix;
		} 
		//throw Exception if encouter any exception
		catch (Exception exception) {
			throw new GridException("Encounter an exception while taking input");
		}

	}

}
