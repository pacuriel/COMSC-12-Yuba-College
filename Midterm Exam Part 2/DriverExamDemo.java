// Importing the Scanner class
import java.util.Scanner; 
import java.io.PrintStream;

public class DriverExamDemo {

	public static void main(String[] args) {

		// Creating an object of the Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		// Declaring final int variable to store the number of exam questions
		final int numberOfExamQuestions = 15;
		
		// Creating a String array to hold the values the user inputs
		String[] studentExamAnswers = new String[numberOfExamQuestions];
		String userAnswer;
		
		// Declaring variables to store values when methods are called
		String passOrFail = "x";
		int totalCorrectAnswers;
		int totalIncorrectAnswers;
		int[] incorrectQuestions;

		// Creating an object of the DriverExam class
		DriverExam writtenExam = new DriverExam(studentExamAnswers);
		
		// Using a for loop to ask the user to input answers for the exam questions
		for (int index = 0; index < numberOfExamQuestions; index++) {
			
			System.out.println("Please input an answer for question " + (index + 1) + ": ");
			
			// Using the Scanner class object to store the user input into userAnswer
			userAnswer = keyboard.nextLine();
			
			// while loop for input validation
			while (!(userAnswer.equalsIgnoreCase("A") || userAnswer.equalsIgnoreCase("B") ||
					userAnswer.equalsIgnoreCase("C") || userAnswer.equalsIgnoreCase("D"))) {
				
				// Asking user to enter a valid answer
				System.out.println("Only A, B, C, or D are acceptable answers. \nPlease enter " +
				   " a VALID answer for question number " + (index + 1) + ": ");	
				userAnswer = keyboard.nextLine();
			}
			
			// Storing the user's input into the studentExamAnswers array
			studentExamAnswers[index] = userAnswer;
		}
		
		// if-else statement to determine whether student passed or failed
		if (writtenExam.passed())
			passOrFail = "passed";
		else
			passOrFail = "failed";
		
		// Calling methods from DriverExam to be stored in variables
		totalCorrectAnswers = writtenExam.totalCorrect();
		
		totalIncorrectAnswers = writtenExam.totalIncorrect();
		
		incorrectQuestions = writtenExam.questionsMissed();
				
		System.out.println();
		
		// Displaying output
		if (writtenExam.passed()) {
			System.out.println("\t\t****** CONGRATULATIONS! ******\n");
		}
		
		System.out.println("You have " + passOrFail + " the written portion of your driver's " + 
		"license exam. \nYou answered " + totalCorrectAnswers + " questions correctly and " + 
		totalIncorrectAnswers + " questions incorrectly.");
		
		// if statement to either display incorrect questions or not
		if (totalIncorrectAnswers != 0) {
			
			System.out.print("The questions you answered incorrectly are: ");
			
			// for loop to display missed questions
			for (int index = 0; index < incorrectQuestions.length; index++) {
				if (incorrectQuestions[index] != 0) {
					System.out.print(incorrectQuestions[index] + " ");
				}
			}
		}
		
		// Displaying the student's grade as a percentage
		System.out.print("\nYour percentage grade is: %");
		
		// Using a format specifier and calling the yourScore() method
		System.out.printf("%.2f", writtenExam.yourScore());
	}
}