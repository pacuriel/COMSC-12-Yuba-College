// Importing the Scanner class
import java.util.Scanner;

public class PhoneNumberList {

	public static void main(String[] args) {
	
		// Creating an object of the Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		// Initializing an array of strings to hold the sample names
		String[] names = { "Harrison, Rose", "James, Jean", 
						   "Smith, William", "Smith, Brad" };
		
		// Initializing an array of strings to hold the sample phone numbers
		String[] phoneNumbers = { "555-2234", "555-9098", 
								  "555-1785", "555-9224" };
	
		// Declaring a string variable to hold the name the user inputs
		String userInput;
		
		// Declaring a boolean variable in case user input has no matches
		boolean matchFound = false; 

		// Displaying the given names and phone numbers
		System.out.println("The following are names and their phone numbers in a \n" +
		"telemarketing phone number list:\n");
		
		
		// Using a for loop to display the names and phone numbers easier
		for (int index = 0; index < names.length; index++) {
			System.out.println(names[index] + "\t" + phoneNumbers[index]);
		}
		
		System.out.println();
				
		// Asking the user to input a name or the first few character of a name
		System.out.print("Please enter a name or the first few characters of a name: ");
		userInput = keyboard.nextLine();
		
		System.out.println();
		
		// Displaying the names that match
		System.out.println("The names and phone numbers that match are: \n");
		
		// Using a for loop to test all names
		for (int index = 0; index < names.length; index++) {
			
			// Using an if statement that test each name individually
			if (names[index].indexOf(userInput) >= 0) {
			System.out.println(names[index] + ": " + phoneNumbers[index]);
				
			// If a match is found, the matchFound variable is set to true
			matchFound = true;
			}
		}
		
		// if statement in case no matches were found
		if (!matchFound) {
			System.out.println("* Input does not match one of the given names. *");
		}
	}
}