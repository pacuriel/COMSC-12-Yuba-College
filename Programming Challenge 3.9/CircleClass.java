public class CircleClass {
	// Declaring fields
	private double radius;
	private final double PI = 3.14159;
	
	// Constructor
	public CircleClass(double radiusGiven) {
		radius = radiusGiven;
	}
	
	public CircleClass() {
		radius = 0;
	}
	
	// Mutator method for radius field
	public void setRadius(double radiusGiven) {
		radius = radiusGiven;
	}
	
	// Accessor method for radius field
	public double getRadius( ) {
		return radius;
	}
	
	// Calculating the area
	public double getArea() {
		return PI * radius * radius;
	}
	
	
	// Calculating the diameter
	public double getDiameter() {
		return radius * 2;
	}

	// Calculating the circumference
	public double getCircumference() {
		return 2 * PI * radius;
	}
	
}
// End of CircleClassjj