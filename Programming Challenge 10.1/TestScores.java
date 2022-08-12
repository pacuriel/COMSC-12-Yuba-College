import java.io.*;
import java.util.Scanner;

public class TestScores {

	// Declaring variables for array of scores, total of scores, and average
	private double[] testScoresArray;
	private double totalTestScores; 
	private double average;
	
	// Class constructor that accepts an array of test scores as its arguments
	public TestScores(double[] array) throws InvalidTestScore {
		
		// for loop to get length of the array
		for (int index = 0; index < array.length; index++) {
			
			testScoresArray = new double[array.length];
			
			// if-else statement to throw an IllegalArgumentException
			if (array[index] < 0 || array[index] > 100) {
				
				// Manually throwing the exception and displaying invalid scores
				throw new InvalidTestScore(array[index]);
			}

			else {
				
				// Setting elements of both arrays equal to each other
				testScoresArray[index] = array[index];
				
				// Adding the scores to get the total
				totalTestScores += array[index];
			}
		}
	}
	
	// Method to return the average of the test scores
	public double getAverage() {
		
		// Calculating average
		average = totalTestScores / testScoresArray.length;
		
		return average;
	}
}

/* Write a class named TestScores. The class constructor should accept
 * an array of test scores as its argument. The class should have a method
 * that returns the average of the test scores. If any test score in the 
 * array is negative or greater than 100, the class should throw an
 * IllegalArgumentException. Demonstrate the class in a program. */