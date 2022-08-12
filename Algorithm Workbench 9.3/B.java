// Superclass B
public abstract class B {
	
	private int m;
	protected int n;
	
	public void setM(int value) {
		
		m = value;
	}
	
	public void setN(int value) {
		
		n = value; 
	}
	
	public int getM() {
		
		return m;
	}
	
	public int getN() {
		
		return n;
	}
	
	public abstract double calcl();
}

// Subclass D
public class D extends B {
	
	private double q;
	protected double r;
	
	public void setQ(double value) {
		
		q = value;
	}
	
	public void setR(double value) {
		
		r = value;
	}
	
	public double getQ() {
		
		return q;
	}
	
	public double getR() {
		
		return r;
	}
	
	public double calc() {
		
		return (q * r);
	}
}


