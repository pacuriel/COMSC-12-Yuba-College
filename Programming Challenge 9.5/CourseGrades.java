public class CourseGrades implements Analyzable {

	int index = 0; // to hold place in object array
    // create array of GradedActivity objects
	GradedActivity[] grades = new GradedActivity[4];
	    
	// default constructor	
	public CourseGrades() {

		
	    
	}

	
	
	// Method to set element of array as Lab
	
	public void setLab(GradedActivity g) {
	
		grades[index] = g;  
		index++;    
	}

	// Method to set element of array as Pass/Fail Exam
	public void setPassFailExam(PassFailExam p) {
	
		grades[index] = p;    
		index++;
	}

	
	
	// Method to set element of array as Essay
	public void setEssay(Essay e) {
	
		grades[index] = e;  
		index++;
	}

	
	
	// Method to set element of array as FInal Exam
	public void setFinalExam(FinalExam f) {
	
		grades[index] = f;
		index++;
	}

	
	
	// Method to calculate and return average score of assignments
	
	public double getAverage() {
	
		double totScore = 0;  
		double avgScore = 0;
 
		for(int i = 0; i < 4; i++) {
	    
			totScore = totScore + grades[i].getScore();  
		}
  
		avgScore = totScore / 4;  
		return avgScore;
	}

	// Method to determine and return highest score of assignments	
	public GradedActivity getHighest() {
	
		int startScan, element, minIndex;   // Needed for sort 
		int high = 0;
		double minValue; 
		double[] scores = new double[4];    // hold scores from object array

		// Load score array
		for(int i = 0; i < 4; i++) {
	    
			scores[i] = grades[i].getScore();   
		}
	    
		// Sort scores
		for (startScan = 0; startScan < 4; startScan++) {
	    
			minIndex = startScan; 
			minValue = scores[startScan];
			
			for(element = startScan + 1; element < 4; element++) {
	        
				if (scores[element] < minValue) {
	            
					minValue = scores[element];
					minIndex = element;  
				}
			}
	        
			scores[minIndex] = scores[startScan];
			scores[startScan] = minValue;
		}

		// Find high score
	    
		for(int i = 0; i < 4; i++) {
	    
			if(grades[i].getScore() == scores[3])
	        
				high = i;
		}
    
		return grades[high];
	}

	// Method to determine and return lowest score of assignments
	public GradedActivity getLowest() {
	
		int startScan, element, minIndex;
		int low = 0;
		double minValue;
	    
		 // Hold scores from object array
		double[] scores = new double[4];   

		// Load score array
		for(int i = 0; i < 4; i++) {
	    
			scores[i] = grades[i].getScore();    
		}

		// sort scores    
		for (startScan = 0; startScan < 4; startScan++) {
	    
			minIndex = startScan;
			minValue = scores[startScan];
	        
			for(element = startScan + 1; element < 4; element++) {
	                if (scores[element] < minValue)
	                {
	                    minValue = scores[element];
	                    minIndex = element;
	                }
	        }
			
	        
			scores[minIndex] = scores[startScan];
			scores[startScan] = minValue;
	        
		}
  
		// find lowest score
	    for(int i = 0; i < 4; i++) {
	           
	    	if(grades[i].getScore() == scores[0])
	              
	    		low = i; 	
	    }
	       
	    return grades[low];    
	}

	    
	public String toString() {
	        
		String str = "The scores and letter grades for current " +
	                "graded activities are: ";
	        
		for(int i = 0; i < 4; i++) {
	            
			str = str + "\nGraded Activity " + (i+1) +
	                    " Score: " + grades[i].getScore() +
	                    " Grade: " + grades[i].getGrade();    
		}
     
		// Return the string.      
		return str; 
	}
}

public class Essay extends GradedActivity {

	    
	// To hold score and subscores
	    
	private double gramScore;
	
	private double spellScore;
	
	private double lengthScore;
	
	private double contentScore;
	
	private double totScore;

	
	
	// default Essay constructor
	
	public Essay()
	
	{

		
	    
	}

	
	
	// Method to set Essay subscores,
	
	public void setScore(double gram, double spell, double length, double content)
	
	{
	
		// Set the subscores
	    
		gramScore = gram;
	    
		spellScore = spell;
	    
		lengthScore = length;
	    
		contentScore = content;

		
	    
		// Calculate the total score
	    
		totScore = gramScore + spellScore + lengthScore + contentScore;

		
	    
		// Call the superclass's setScore method to
	    
		// set the numeric score.
	    
		setScore(totScore);

		
	    
	}

	
	
	// Method to return Grammar subscore
	
	public double getGrammar()
	
	{
	
		return gramScore;
	    
	}

	
	
	// Method to return Spelling subscore
	
	public double getSpelling()
	
	{
	
		return spellScore;
	    
	}

	
	
	// Method to return Length subscore
	
	public double getCorrectLength()
	
	{
	
		return lengthScore;
	    
	}

	
	
	// Method to return Content subscore
	
	public double getContent()
	
	{
	
		return contentScore;
	    
	}

	
	
}



public class FinalExam extends GradedActivity

{

	private int numQuestions; // Number of questions
	
	private double pointsEach; // Points for each question
	
	private int numMissed;     // Number of questions missed

	

	
	
	public FinalExam(int questions, int missed)
	
	{
	
		double numericScore; // To calculate the numeric score

		
	    
		// Set the numQuestions and numMissed fields.
	    
		numQuestions = questions;
	    
		numMissed = missed;

		
	    
		// Calculate the points for each question and
	    
		// the numeric score for this exam.
	    
		pointsEach = 100.0 / questions;
	    
		numericScore = 100.0 - (missed * pointsEach);

		
	    
		// Call the superclass's setScore method to
	    
		// set the numeric score.
	    
		setScore(numericScore);
	    
	}

	
	
	//The getPointsEach method returns the pointsEach field.

	

	
	
	public double getPointsEach()
	
	{
	
		return pointsEach;
	    
	}

	
	
	// The getNumMissed method returns the numMissed field.

	

	
	
	public int getNumMissed()
	
	{
	
		return numMissed;
	    
	}
	
	
	
	
	
	public class GradedActivity {
	
		
	    
		private double score; // Numeric score

		
	    
		/*
	    
	     * The setScore method stores its argument in
	     * 
	     * the score field.
	     */
		

		
	    
		public void setScore(double s)
	    
		{
	    
			score = s;
	    }
		

		
	    
		/**
	    
	     * The getScore method returns the score field.
	     */
		

		
	    
		public double getScore()
	    
		{
	    
			return score;
	    }
		

		
	    
		/**
	    
	     * The getGrade method returns a letter grade
	     * 
	     * determined from the score field.
	     */
		

		
	    
		public char getGrade()
	    
		{
	    
			char letterGrade; // To hold the grade

			
	        
			if (score >= 90)
	        
				letterGrade = 'A';
	        else
	        	if (score >= 80)
	            
	        		letterGrade = 'B';
	        else if 
	        (score >= 70)
	        
	        	letterGrade = 'C';
	        else
	        	if (score >= 60)
	            
	        		letterGrade = 'D';
	        else
	        	
	            
	        	letterGrade = 'F';

			
	        
			return letterGrade;
	    }
		
	}
	

	
	
	public class PassFailActivity extends GradedActivity
	
	{
	
		private double minPassingScore; // Minimum passing score

		
	    
		public PassFailActivity(double mps)
	    
		{
	    
			minPassingScore = mps;
	    }
		

		

		
	    
		public char getGrade()
	    
		{
	    
			char letterGrade; // To hold the letter grade

			
	        
			if (super.getScore() >= minPassingScore)
	        
				letterGrade = 'P';
	        else
	        	
	            
	        	letterGrade = 'F';

			
	        
			return letterGrade;
	    }
		
	}
	

	
	
	public class PassFailExam extends PassFailActivity
	
	{
	
		private int numQuestions; // Number of questions
	    
		private double pointsEach; // Points for each question
	    
		private int numMissed;     // Number of questions missed

		

		
	    
		public PassFailExam(int questions, int missed,
	    
				double minPassing)
	    {
			
	        
			// Call the superclass constructor.
	        
			super(minPassing);

			
	        
			// Declare a local variable for the numeric score.
	        
			double numericScore;

			
	        
			// Set the numQuestions and numMissed fields.
	        
			numQuestions = questions;
	        
			numMissed = missed;

			
	        
			// Calculate the points for each question and
	        
			// the numeric score for this exam.
	        
			pointsEach = 100.0 / questions;
	        
			numericScore = 100.0 - (missed * pointsEach);

			
	        
			// Call the superclass's setScore method to
	        
			// set the numeric score.
	        
			setScore(numericScore);
	    }
		

		
	    
		// The getPointsEach method returns the pointsEach field.

		

		
	    
		public double getPointsEach()
	    
		{
	    
			return pointsEach;
	    }
		

		
	    
		//The getNumMissed method returns the numMissed field.

		

		
	    
		public int getNumMissed()
	    
		{
	    
			return numMissed;
	    }
		
	}	
}