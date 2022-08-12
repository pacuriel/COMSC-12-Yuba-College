// Importing for exceptions
import java.io.*;
// Importing the Scanner class
import java.util.Scanner;

public class TestScoresDemo {
	public static void main(String args[]) {
	
		// Creating an object of the Scanner class
		Scanner keyboard = new Scanner(System.in);
		
		// Integer variable to hold the number of test scores
		int numberOfTestScores;
		
		double averageTestScore;

		// Asking user how many test scores they would like to input
		System.out.print("Please enter the number of test scores you " +
		"would like to input: ");
		numberOfTestScores = keyboard.nextInt();
		
		// Declaring a double array to hold test scores with a user-chosen index
		double[] userTestScores = new double[numberOfTestScores];
		
		System.out.println();
		
		// for loop to store user test scores 
		for (int index = 0; index < userTestScores.length; index++) {
			System.out.print("Please enter test score number " + (index + 1) + ": ");
			userTestScores[index] = keyboard.nextDouble();
		}
		
		// Created an object of the TestScores class
		TestScores classObject = null;
		
		// try statement to test the scores
		try {
			classObject = new TestScores(userTestScores);
		}
		// Displaying an exception
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		averageTestScore = classObject.getAverage();
		
		System.out.print("\nThe average test score is: ");
		System.out.printf("%.2f", averageTestScore);
		
	}
}

/* Write a class named TestScores. The class constructor should accept
 * an array of test scores as its argument. The class should have a method
 * that returns the average of the test scores. If any test score in the 
 * array is negative or greater than 100, the class should throw an
 * IllegalArgumentException. Demonstrate the class in a program. */