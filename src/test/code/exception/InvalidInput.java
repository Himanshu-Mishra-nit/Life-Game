package test.code.exception;

/**
 * This is custom exception for invalid input
 * */
public class InvalidInput extends RuntimeException{
	
	public InvalidInput(String message) {super(message);}
	
	public InvalidInput(String message, Throwable error) {super(message, error);}

}
