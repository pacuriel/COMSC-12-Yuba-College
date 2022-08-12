// Importing Scanner class
import java.util.Scanner;

public class RecursiveMultiplication {
	
	// Main method
	public static void main(String[] args){
     
		// Creating Scanner class object
		Scanner keyboard =new Scanner(System.in);
        
		// Declaring integer variables
		int x, y, result;
        
		System.out.println("Recursive Multiplication Calculator\n");
		
		// Asking user to enter a value for x
		System.out.println("Enter the value of x:");
		
		x = keyboard.nextInt();

		// Asking user to enter a value for y
		System.out.println("Enter the value of y:");
        
		y = keyboard.nextInt();
        
		//Creating object to the class
		RecursiveMultiplication obj = new RecursiveMultiplication();
        
		// Calling the method multiply
		result = obj.multiply(x, y);
        
		// Displaying the result
		System.out.println("The result is: " + result); 
	}
    
	// Recursive method
	int multiply(int x, int y){
    
		if(x == 0)
        
			return 0;
		
		// Recursively calling the method
		return y + multiply(x-1, y);
	}
}
