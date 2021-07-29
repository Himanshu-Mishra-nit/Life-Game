package test.code.service;

import test.code.entity.Cell;
import test.code.entity.Grid;
import test.code.exception.GridException;

/**
 * This is internal implemetation of workservice class and their methods
 */
public class WorkServiceImpl implements WorkService {

	@Override
	public boolean save(Grid matrix, int row, int col) {
		return (matrix.getRowSize() > row && matrix.getColSize() > col && row >= 0 && col >= 0);
	}

	@Override
	public void solutoin(Grid matrix) {
		// TODO Auto-generated method stub

		try {
			int rowSize = matrix.getRowSize();
			int colSize = matrix.getColSize();

			// Possible neighboring
			// indexes
			int neighbourU[] = { 1, -1, 0, 1, -1, 0, 1, -1 };
			int neighbourV[] = { 0, 0, -1, -1, -1, 1, 1, 1 };

			for (int row = 0; row < rowSize; row++) {
				for (int col = 0; col < colSize; col++) {

					// IF the initial value
					// of the grid(i, j) is 1
					if (matrix.getCell(row, col).getValue() > 0) {
						for (int neighbour = 0; neighbour < 8; neighbour++) {
							if (save(matrix, row + neighbourU[neighbour], col + neighbourV[neighbour]) && matrix
									.getCell(row + neighbourU[neighbour], col + neighbourV[neighbour]).getValue() > 0) {

								// If initial value > 0,
								// just increment it by 1
								int newValue = matrix.getCell(row, col).getValue();
								matrix.setCell(row, col, new Cell(newValue + 1));
							}
						}
					}

					// IF the initial value
					// of the grid(i, j) is 0
					else {
						for (int neighbour = 0; neighbour < 8; neighbour++) {
							if (save(matrix, row + neighbourU[neighbour], col + neighbourV[neighbour]) && matrix
									.getCell(row + neighbourU[neighbour], col + neighbourV[neighbour]).getValue() > 0) {

								// If initial value <= 0
								// just decrement it by 1
								int newValue = matrix.getCell(row, col).getValue();
								matrix.setCell(row, col, new Cell(newValue - 1));

							}
						}
					}
				}
			}

			// Generating new Generation.
			// Now the magnitude of the
			// grid will represent number
			// of neighbours
			for (int row = 0; row < rowSize; row++) {
				for (int col = 0; col < colSize; col++) {

					// If initial value was 1.
					if (matrix.getCell(row, col).getValue() > 0) {

						// Since Any live cell with
						// < 2 live neighbors dies
						if (matrix.getCell(row, col).getValue() < 3)
							matrix.setCell(row, col, new Cell(0));

						// Since Any live cell with
						// 2 or 3 live neighbors live
						else if (matrix.getCell(row, col).getValue() <= 4)
							matrix.setCell(row, col, new Cell(1));

						// Since Any live cell with
						// > 3 live neighbors dies
						else if (matrix.getCell(row, col).getValue() > 4)
							matrix.setCell(row, col, new Cell(0));
					}

					else {

						// Since Any dead cell with
						// exactly 3 live neighbors
						// becomes a live cell
						if (matrix.getCell(row, col).getValue() == -3)
							matrix.setCell(row, col, new Cell(1));
						else
							matrix.setCell(row, col, new Cell(0));
					}

				}
			}

		} catch (Exception exception) {
			throw new GridException("Encounter an exception in WorkServiceImpl at solution method");
		}

	}

}
