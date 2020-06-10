

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questions {
	

	static // list to hold set of question/answer combos
			List <MyQuestions> qs = new ArrayList<MyQuestions>();
			
	static int id = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		//initialize scanner
		Scanner in = new Scanner(System.in);
		
		int choice; // hold menu option
		int stop = 0; // use to stop program
		
		while(stop != 1) {
		
		mainMenu(); // display menu
		
		choice = in.nextInt(); // get menu choice
		
		if( choice == 1) {
			add();
		}
		else if(choice == 2) {
			display();
		}
		else if(choice == 3) {
			stop = 1;
		}
		}
		
}
	//method to display all questions and answer combos 
	public static void display() {
		
		// Print contents from list....
        for(MyQuestions qs : qs) {
        	System.out.print(qs.getId() + ". ");
            System.out.print(qs.getQuestion());
            System.out.print(" = ");
            System.out.println(qs.getAnswer());
        }
		
	}
	
	// method to add question/answer combos
	public static void add() {
		
		int more = 0; // use in loop, if user wants to add more questions
		String ask; 
		String q; // hold question string 
		String a; // hold answer string 
		//initialize scanner
				Scanner in = new Scanner(System.in);
		
		// while less than one, allow user to enter questions w answers
				do {
					
					//get question
				System.out.println("Enter a question.");
				q = in.nextLine();
				
				//get answer
				System.out.println("Enter the answer.");
				a = in.nextLine();
				
				
				// keep question and answer together in object
				MyQuestions quest = new MyQuestions(id,q,a);
				
				id++;
				
				qs.add(quest);
				
				// enter another? 
				System.out.println("Enter another question? (Y/N)");
				ask = in.nextLine();
				
				// if not, exit loop
				if (ask.equals("N") || ask.equals("n")) {
			
					more = 2;
					System.out.println("");
				}
				
				
				} 
				while(more == 0);
		
	}
	
	public static void remove(int id) {
		
		qs.remove(id);
		
	}
	
	// method to print menu
	public static void mainMenu() {
		
	
		
		System.out.println("Main Menu\nChoose an option");
		System.out.println("1.Enter new question/answer\n2.Display all questions/answers");
		System.out.println("3.Remove entry\n4.Exit Program");
		
	}
	
}
