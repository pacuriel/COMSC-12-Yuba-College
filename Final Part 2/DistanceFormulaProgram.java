// Importing the Scanner and Math class
import java.util.Scanner;
import java.lang.Math;

public class DistanceFormulaProgram {

	public static void main(String[] args) {
		
		// Declaring double variables
		double X1, Y1, X2, Y2, distance;
		
		// Creating an object of the Scannre class
		Scanner keyboard = new Scanner(System.in);
		
		// Program heading
		System.out.println("Distance Between Two Points Calculator\n");
		
		// Asking user to input values and storing them in their
		// respective variables
		System.out.print("Enter a value for X1: ");
		
		X1 = keyboard.nextDouble();
		
		System.out.print("Enter a value for Y1: ");
		
		Y1 = keyboard.nextDouble();
		
		System.out.print("Enter a value for X2: ");
		
		X2 = keyboard.nextDouble();
		
		System.out.print("Enter a value for Y2: ");
		
		Y2 = keyboard.nextDouble();
		
		// Calculating distance using the distance formula
		distance = Math.sqrt(Math.pow(X2 - X1, 2) + Math.pow(Y2 - Y1, 2));
		
		// Displaying output
		System.out.println("\nPoint A: (" + X1 + ", " + Y1 + ")");
		System.out.println("Point B: (" + X2 + ", " + Y2 + ")\n");
		System.out.printf("The distance bewteen Point A and Point B is %.3f.", distance);
	}
}