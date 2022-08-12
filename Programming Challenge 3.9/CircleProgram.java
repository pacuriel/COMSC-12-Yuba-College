import javax.swing.JOptionPane;

public class CircleProgram {

	public static void main(String [] args) {
		
		String userInputString;
		double userRadius;
		
		userInputString = JOptionPane.showInputDialog("Please enter the circle's radius: ");
		userRadius = Double.parseDouble(userInputString);
		
		CircleClass circle1 = new CircleClass(userRadius);
		
		JOptionPane.showMessageDialog(null, "Area: " + circle1.getArea() + "\nDiameter: " + circle1.getDiameter() + 
				"\nCircumference: " + circle1.getCircumference());
		
		System.exit(0);
	
	
	}
}
