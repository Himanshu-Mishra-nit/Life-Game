package test.code.service;

import test.code.entity.Grid;

//Work service interface having two methods solution and save 
//this class is used to achieve the abstration

public interface WorkService {
	
	public boolean save(Grid matrix, int row, int col);
	
	public void solutoin(Grid matrix);

}
