import java.util.Random;

public class algorithmWorkbench9 {
	public static void main(String[] args) {
	// Random object to generate random numbers	
	Random number = new Random();
	int i; // Loop control variable
	// Repeats loop 10 times	
	for (i = 1; i <= 10; i++) {
	
		int number1 = number.nextInt(2);
		// if-else statement to display yes or no
		if (number1 == 1)
			System.out.println("Yes");
		else
			System.out.println("No");
			
		}	
}
}
