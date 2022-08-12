// Importing the Scanner class
import java.util.Scanner;

public class GradeBookDemo {
	public static void main(String[] args) {
		// Adding Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		// Declaring variables for a student's name, 
		// test score, average, and letter grade
		String studentName;
		double studentScore;
		double studentAverage;
		char studentLetterGrade; 
		
		// Two dimensional array to hold student test scores
		double[][] studentTestScores;
		
		// Declaring final variables for the number of students and tests
		final int numOfStudents = 5;
		final int numOfTests = 4;
		
		// Importing a GradeBook class object
		GradeBook students = new GradeBook(numOfStudents, numOfTests);
		
		// Setting the two-dimensional array studentTestScores equal to
		// the getStudentTestScores method 
		studentTestScores = students.getStudentTestScores();
		
		
		// Nested for loops to take user input for the student's name and test score
		for (int studentIndex = 0; studentIndex < numOfStudents; studentIndex++) {
			
			// Asking user to enter a student's name
			System.out.println("Please enter the name of student " + (studentIndex + 1) + ": ");
			studentName = keyboard.nextLine();
			
			// Calling the setStudentName method
			students.setStudentName(studentName);
			
			for (int testScoreIndex = 0; testScoreIndex < numOfTests; testScoreIndex ++) {
				
				// Asking user to enter the student's test scores
				System.out.println("Please enter " + (studentName) + "'s score on test " +
				"number " + (testScoreIndex + 1) + ": ");
				studentScore = keyboard.nextDouble();
				
				// while loop for input validation
				while (studentScore < 0 || studentScore > 100) {
					System.out.println("Please re-enter a VALID score BETWEEN 0 TO 100: ");
					studentScore = keyboard.nextDouble();
				}
								
				keyboard.nextLine();
				
				// Calling the setStudentScore method
				students.setStudentScore(studentIndex, testScoreIndex, studentScore);			
			}
		}
		
		// Nested for loops to display output
		for (int studentIndex = 0; studentIndex < numOfStudents; studentIndex++) {
			
			// Displaying student's name
			System.out.print(students.getName(studentIndex) + " has scores ");
			
			// Using the averageTestScores method to get the student's average
			studentAverage = students.averageTestScores(studentTestScores[studentIndex]);
			
			// Using the letterGrade method to get the student's letter grade
			studentLetterGrade = students.letterGrade(studentAverage);
			
			// for loop to display student's scores
			for (int testScoreIndex = 0; testScoreIndex < numOfTests; testScoreIndex ++) {
				
				// if-else-if statements for formatting output
				if (testScoreIndex != (numOfTests - 1)) {
					System.out.print(studentTestScores[studentIndex][testScoreIndex] + ", ");
				}
				else if (testScoreIndex == (numOfTests - 2)) {
					System.out.print(studentTestScores[studentIndex][testScoreIndex] + ", and ");
				}
				else {
					System.out.print(studentTestScores[studentIndex][testScoreIndex] + " ");
				}				
			}
			
			// Displaying student's average score and letter grade
			System.out.println(" with an average score of " + studentAverage + " and a letter " +
			"grade of " + studentLetterGrade + ".");
			
			System.out.println();
		}
	}
}