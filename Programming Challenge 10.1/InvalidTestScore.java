
public class InvalidTestScore extends Exception {
	
	InvalidTestScore(double score) {
		
		super("Invalid score entered: " + score);
	}

}
