// Importing the ArrayList class
import java.util.ArrayList;

public class GradeBook {

	// Adding an ArrayList object with reference variable names
	private ArrayList<String> names = new ArrayList<String>();
	
	// Single array for letter grades
	private char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};
	
	// Two-dimensional array for test scores
	private double[][] testScores;
	
	// final variables to set number of students and tests
	private final int NUMBER_OF_STUDENTS = 5;
	private final int NUMBER_OF_TESTS = 4;
	
	// GradeBook method to call an object from this class
	public GradeBook(int NUMBER_OF_STUDENTS, int NUMBER_OF_TESTS) {
		testScores = new double[NUMBER_OF_STUDENTS][NUMBER_OF_TESTS];
	}
	
	// Method to get student names to array list names
	public void setStudentName(String studentNames) {
		names.add(studentNames);
	}
	
	// Method to add the student scores to the two-dimensional array
	public void setStudentScore(int studentIndex, int scoreIndex, double studentScore) {
		testScores[studentIndex][scoreIndex] = studentScore;
	}
	
	// Method to return a student's name
	public String getName(int index) {
		// Returning student names
		return names.get(index);
	}
	
	// Method to return a student's average test score
	public double averageTestScores(double[] testScore) {
		
		// Initializing totalTestScores to 0 for the for loop
		double totalTestScores = 0;
		double averageTestScore;
		
		// for loop to add up all the test scores and get total test scores
		for (int singleScore = 0; singleScore < testScores.length; singleScore++) {
			totalTestScores = totalTestScores + testScore[singleScore];
		}
		
		// Calculating average test score
		averageTestScore = totalTestScores / testScores.length;
		
		// Returning average test score based on all tests
		return averageTestScore;		
	}
	
	// Method to return the two dimensional array
	public double[][] getStudentTestScores() {
		return testScores;
	}
	
	// Method to return a letter grade based on average test score
	public char letterGrade(double averageTestScore) {
		// Declaring char variable to return a student's letter grade
		char studentLetterGrade = 'X'; 
		
		// if-else-if statements to determine a student's letter grade
		// based on the student's average test score
		if (averageTestScore < 60) {
			studentLetterGrade = 'F';
		}
		else if (averageTestScore < 70) {
			studentLetterGrade = 'D';
		}
		else if (averageTestScore < 80) {
			studentLetterGrade = 'C';
		}
		else if (averageTestScore < 90) {
			studentLetterGrade = 'B';
		}
		else if (averageTestScore <= 100) {
			studentLetterGrade = 'A';
		}
		
		// Returning the student's letter grade
		return studentLetterGrade;
	}		
}