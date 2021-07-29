package test.code.exception;

/**
 * This is custom exception for GridException
 * */

public class GridException extends RuntimeException{
	
	public GridException(String message) {
		super(message);
	}
	
	public GridException(String message, Throwable error) {
		super(message, error);
	}

}
