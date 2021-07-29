package test.code;

import test.code.cotrller.Controller;
import test.code.service.WorkServiceImpl;
/*
 * Main landing class which is calling controller class. 
 * One argument with controller of Type WorkService (to remove tight coupling) 
 * */
public class App {

	
	public static void main(String[] args) {
		
		Runtime current = Runtime.getRuntime();
		current.addShutdownHook(new Begin());
		
		Controller controller = new Controller(new WorkServiceImpl());
		controller.start();
	}
	
}

class Begin extends Thread{
	public void run() {
		Controller controller = new Controller(new WorkServiceImpl());
		controller.start();
	}
}
/*
 *  New Game 



>>>>>		 Enter RowSize and ColomnSize of Matrix

>>>	 RowSize :4
>>>	 ColomnSize :5
>>>>>		 Enter a single row of Matrix saparate by space

Examlple:0 1 0 0 1 0......
Input=>
0 0 0 0 0
0 1 1 0 0
0 0 0 1 0
0 0 0 0 0
Output=>
0 0 0 0 0 
0 0 1 0 0 
0 0 1 0 0 
0 0 0 0 0 

 * */
