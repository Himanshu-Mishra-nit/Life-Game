package test.code.entity;

//Entity class of Grid
public class Grid {

	private int rowSize;
	
	private int colSize;
	
	private Cell[][] cell;

	public Grid(int rowSize, int colSize) {
		super();
		this.rowSize = rowSize;
		this.colSize = colSize;
		cell = new Cell [rowSize][colSize];
	}

	public Grid() {
		// TODO Auto-generated constructor stub
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	public Cell getCell(int row, int col) {
		return this.cell[row][col];
	}

	public void setCell(int row, int col, Cell value) {
		this.cell[row][col]=value;
	}

	


	
	
	
	
	
	
}
