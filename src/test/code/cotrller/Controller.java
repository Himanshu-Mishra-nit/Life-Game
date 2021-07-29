package test.code.cotrller;

import java.util.Scanner;

import test.code.entity.Grid;
import test.code.service.WorkService;
import test.code.util.Input;
import test.code.util.Print;

/*
 * This is controller class which handle whole flow of program.
 * it needs 3 dependencies two of them are tightly coupled which are utility class and service is loosely coupled
 * */

public class Controller {

	public Controller() {}
	
	//Utility classes
	private Input input = new Input();
	private Print print =new Print();
	
	//Service class
	private WorkService workService;
	
	//injection of dependency
	public Controller(WorkService workService) {
		this.workService = workService;
	}
	private Scanner scanner  = new Scanner(System.in);
	
	public void start() {
		System.out.println("To start the game press 1");
		int choice = scanner.nextInt();
		while(choice == 1) {
		
		//Taking input
		Grid matrix = input.input();
		
		//Solving the matrix
		workService.solutoin(matrix);
		
		//Printing the solution
		print.print(matrix);
		
		System.out.println("/n/n want to start again press 1");
		choice = scanner.nextInt();
		}
	}
	
}
