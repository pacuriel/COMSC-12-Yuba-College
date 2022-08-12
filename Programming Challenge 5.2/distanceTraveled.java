import java.util.Scanner;

public class distanceTraveled {
	
	// getDistance method to return distance in main method
	public static int getDistance(int speed, int time) {
		int distance;
		// Distance equation provided in problem
		distance = speed * time;
		return distance;
	}
	
	// Main method
	public static void main(String[] args) {
		// Adding scanner keyboard for user input
		Scanner keyboard = new Scanner(System.in);
		// Declaring variables
		int vehicleSpeed, timeTraveled, vehicleDistance;
		
		//Asking user to input the vehicle's speed
		System.out.println("Please enter the vehicle's speed in miles per hour: ");
		vehicleSpeed = keyboard.nextInt();
		// while loop to make sure user inputs valid speed
		while (vehicleSpeed <= 0 ) {
			System.out.println("Please enter a speed greater than zero: ");			
			vehicleSpeed = keyboard.nextInt();
		}
		
		// Asking user to input the time the vehicle traveled
		System.out.println("Please enter the total time traveled in hours: ");
		timeTraveled = keyboard.nextInt();
		// while loop to make sure user inputs time greater than 0
		while (timeTraveled <= 0) {
			System.out.println("Please enter a time greater than zero: ");
			timeTraveled = keyboard.nextInt();
		}
		
		// Displaying similar to example in textbook
		System.out.println("Hour\tDistance Traveled");
		// for loop to display distance for every hour traveled
		for (int hour = 1; hour <= timeTraveled; hour++) {
			// Calling getDistance method to return distance
			vehicleDistance = getDistance(vehicleSpeed, hour);
			System.out.println(hour + "\t" + vehicleDistance);
		}		
	}
}