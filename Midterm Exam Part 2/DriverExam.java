public class DriverExam {

	// String array holding the exam's correct answers
	private String[] correctAnswers = {"B", "D", "A", "A", "C", "A", 
		"B", "A", "C", "D", "B", "C", "D", "A", "D"};
	
	// String array to hold the student's answers
	private String[] studentAnswers = new String[correctAnswers.length];
	
	// Declaring final int variable to store the 15 exam questions
	private final int numberOfQuestions = correctAnswers.length;
	
	// totalCorrect method to return total correct answers
	public int totalCorrect() {
		
		// Declaring integer variable to store number of correct answers and
		int totalCorrectAnswers = 0;
		
		// for loop iterating once per question
		for (int index = 0; index < numberOfQuestions; index++) {
			
			// if statement to determine if student answer is correct by comparing the arrays
			if (correctAnswers[index].equalsIgnoreCase(studentAnswers[index])) {
				
				// Adding one to total of correct answers if arrays are equal at index element 
				totalCorrectAnswers = totalCorrectAnswers + 1;
			}						
		}
		
		// Returning the total of correctly answered questions
		return totalCorrectAnswers; 
	}
	
	// totalIncorrect method to return total of incorrect answers
	// Structure of method is almost identical to totalCorrect() method 
	public int totalIncorrect() {
		
		int totalIncorrectAnswers = 0; 
		
		// for loop iterating once per question
		for (int index = 0; index < numberOfQuestions; index++) {
					
			// if statement to determine if student answer is incorrect by comparing the arrays
			if (!(correctAnswers[index].equalsIgnoreCase(studentAnswers[index]))) {
				
				// Adding one to total of incorrect answers if arrays are equal at index element
				totalIncorrectAnswers = totalIncorrectAnswers + 1;
			}
		}
		
		// Returning the total of correctly answersed questions
		return totalIncorrectAnswers;
	}
	
	// passed boolean method that returns true if student passed exam
	public boolean passed() {
			
		// Setting the passingScore equal to 10 
		int passingScore = 10; 
			
		// Using an if-else statement to decide if the student passed by 
		// comparing the totalCorrect() method to the passing score
		if (totalCorrect() >= passingScore) 
			return true;
		else
			return false;
	}
	
	
	// questionsMissed method to return an array of the missedQuestions
	public int[] questionsMissed() {
		
		// Declaring an integer array to store the questions missed
		int[] questionsMissedArray = new int[numberOfQuestions];
		
		// Initializing 0 for the index of the questionsMissedArray
		int questionsMissedIndex = 0;
		
		// Same for loop and if statement from the totalIncorrect() method
		for (int index = 0; index < numberOfQuestions; index++) {					
			if (!(correctAnswers[index].equalsIgnoreCase(studentAnswers[index]))) {
				
				// Storing the incorrect question numbers in the questionsMissedArray 
				// by adding 1 to the index to account for the elements starting at 0
				questionsMissedArray[questionsMissedIndex] = index + 1;
				questionsMissedIndex++;						
			}	
		}
		
		return questionsMissedArray;
	}
	
	// yourScore method to return the student's percentage grade on the exam
	public double yourScore() {
		
		// Declaring double variable to store percentage
		double percentCorrect;
		
		/* Dividing the number of correct answers by the number of questions
		 * and multiplying by 100 to get the percentage of correct answers.
		 * Had to use (float) because totalCorrect() returns an integer, which
		 * was causing the math to be wrong. 
		*/ 
		percentCorrect = (((float)totalCorrect() / 15) * 100);
		
		return percentCorrect;
	}
	
	// DriverExam class method to be able to call the class. Method has a String 
	// array as a constructor to use that array's values in the studentAnswers array. 
	public DriverExam(String[] userAnswers) {
		
		// Setting the studentAnswers array equal to the userAnswers array
		studentAnswers = userAnswers; 
	}
}