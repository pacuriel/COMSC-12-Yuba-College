import javax.swing.JOptionPane;
 
public class speedOfSound {
	public static void main(String [] args) {
		// Declaring variables
		String userInputMedium; 
		String str;
		double distance;
		double time = 0; 
		
		// Asking user to input the medium for sound to travel through
		userInputMedium = JOptionPane.showInputDialog("Enter the medium for sound to " + 
									"travel through.\nEnter either air, water, or steel.");
			
		// Asking user to input the distance sound will travel through
		str = JOptionPane.showInputDialog("Enter a distance in feet that the sound wave will travel.");
		distance = Double.parseDouble(str);		
		
		// if and else if statements for the medium and distance user inputs
		if (userInputMedium.equalsIgnoreCase("air")) {
			time = distance / 1100;
		} else if (userInputMedium.equalsIgnoreCase("water")) {
			time = distance / 4900;	
		} else if (userInputMedium.equalsIgnoreCase("steel")) {
			time = distance / 16400;
		}
		
		// Displaying time it takes for sound to travel user's inputted distance through the medium
		JOptionPane.showMessageDialog(null, "The time it will take for sound to travel " + distance + " feet through " + 
		userInputMedium + " is " + time + " seconds.");
	}
}

