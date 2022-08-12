// Import Scanner class to read user input
import java.util.Scanner;

public class ParkingTicket {
	
	// Creating ParkedCar class
    public class ParkedCar {

    	// Declaring variables
    	String make, model, color, licenseNumber;
    	int minutesParked;

    	// Using this.variableName to make easier to access
    	public ParkedCar(String make, String model, String color, String licensenumber, int minutes) {

    		this.make = make;
    		this.model = model;
    		this.color = color;
    		this.licenseNumber = licensenumber;
    		this.minutesParked = minutes;
    	}

    	// Using getVariable name methods to return 
    	// the variable's value
    	public String getMake() {

    		return make;
    	}

    	public String getModel() {

    		return model;
    	}

    	public String getColor() {

    		return color;
    	}
    	
    	public String getLicenseNumber() {

    		return licenseNumber;
    	}

    	public int getMinutesParked() {

    		return minutesParked;
    	}
    }

    // Creating ParkingMeter class
    public class ParkingMeter {

    	// Declaring ParkingMeter class variables
    	int minutes;

    	// Using this.varibleName to make easier to access
    	public ParkingMeter(int minutes) {

    		this.minutes = minutes;
    	}

    	// getMinutes method to return minutes
    	public int getMinutes() {

    		return minutes;
    	}
    }

    // ParkingTicket class from textbook (had to rename
    // Ticket because I messed up naming the class)
    public class Ticket {

    	// Declaring variables (some with a final keyword to
    	// ensure their values don't change)
    	final int firstHourFine = 25;
    	final int additionalHourFine = 10;
    	int fineAmount;    	
    	ParkedCar illegalCar;
    	PoliceOfficer officer;

    	// Using this keyword to make easier to access
    	public Ticket(ParkedCar car, PoliceOfficer officer) {

    		this.illegalCar = car;
    		this.officer = officer;

    		// Initializing fine amount to 0
    		fineAmount = 0;
       }

    	// Calculating fine
    	public void calculateFine(int minsPurchased) {
    		
    		int hours = (illegalCar.getMinutesParked() - minsPurchased)/60;
    		
    		// if statement to round up to the next hour
    		if((illegalCar.getMinutesParked() - minsPurchased) % 60 > 0) {

    			hours++;

    			// Equating to find final cost of fine
    			fineAmount = firstHourFine + ((hours-1) * additionalHourFine);
    		}
    	}

    	// Generating a parking ticket ticket by writing what will display
    	public void generateParkingTicket() {
    	   
    		System.out.println("Fined amount: $" + fineAmount);
    		
    		System.out.println("Car issued to: " + illegalCar.getColor() + " " + illegalCar.getMake()
    			+ " " + illegalCar.getModel() + ", license #: " + illegalCar.getLicenseNumber());

    		System.out.println("Issued by officer: " + officer.getName() + ", badge #: " + officer.getBadgeNumber());
    	}
    }
    
    // PoliceOfficer class
    public class PoliceOfficer {
    	
    	// Declaring variables
    	String name;
    	int badgeNumber;
    	Ticket ticket;

    	// this keyword to make easier to access
    	public PoliceOfficer(String name, int number) {
    		
    		this.name = name;
    		this.badgeNumber = number;
    	}

    	// getName method to return officer's name
    	public String getName() {
    		
    		return name;
    	}
    	
    	// getBadgeNumber method to return badge #
    	public int getBadgeNumber() {
    		
    		return badgeNumber;
    	}
    	
    	// Officer checking to see if vehicle is illegally parked
    	public void check(ParkedCar car, ParkingMeter meter) {
    		
    		if(car.getMinutesParked() > meter.getMinutes()) {
    			
    			ticket = new Ticket(car, this);
    			ticket.calculateFine(meter.getMinutes());
    			ticket.generateParkingTicket();
    		}
    	}
    }
    
    // Main method
    public static void main(String[] args) {
    	
    	ParkingTicket simulator = new ParkingTicket();
    	
    	// Scanner class to read user input
    	Scanner keyboard = new Scanner(System.in);
    	
    	// Declaring variables
    	String make, model, license, color, officerName;
    	int minParked, minPurchased, badgeNumber;
    	
    	// Display header
    	System.out.println("Parking Ticket Simulator");
    	
    	// Car data header
    	System.out.println("\n---------" + "\n" + "Car Data" + "\n" + "---------\n");
    	
    	// Asking user to input car data such as make, 
    	// model, color, license #, minutes parked
    	System.out.print("Enter car make: ");
    	make = keyboard.nextLine();

    	System.out.print("Enter car model: ");
    	model = keyboard.nextLine();

    	System.out.print("Enter car color: ");
    	color = keyboard.nextLine();

    	System.out.print("Enter car license number: ");
    	license = keyboard.nextLine();

    	System.out.print("Enter minutes car has been parked: ");
    	minParked = keyboard.nextInt();

    	// Removing the extra new line
    	keyboard.nextLine();

    	// Meter data header
    	System.out.println("\n---------" + "\n" + "Meter Data" + "\n" + "---------\n");

    	// Asking user to enter minutes purchased at parking meter
    	System.out.print("Enter minutes purchased by driver: ");
    	minPurchased = keyboard.nextInt();

    	//Removing the extra new line
    	keyboard.nextLine();
    	
    	// Police officer data header
    	System.out.println("\n---------" + "\n" + "Police Officer Data" + "\n" + "---------\n");

    	// Asking user to input data about the police officer such as
    	// their name and badge #
    	System.out.print("Enter police officer's name: ");
    	officerName = keyboard.nextLine();

    	System.out.print("Enter police officer's badge number: ");
    	badgeNumber = keyboard.nextInt();

    	keyboard.nextLine();

    	// Parking ticket header
    	System.out.println("\n---------------------" + "\n" + "Parking Ticket Issued" + "\n" + "---------------------\n");

    	ParkingTicket.PoliceOfficer officer = simulator.new PoliceOfficer(officerName, badgeNumber);
    	ParkingTicket.ParkingMeter meter = simulator.new ParkingMeter(minPurchased);
    	ParkingTicket.ParkedCar parkedCar = simulator.new ParkedCar(make, model, color, license, minParked);
    	officer.check(parkedCar, meter);
    }
}