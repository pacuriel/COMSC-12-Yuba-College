import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TravelExpenses extends Application{
	
	private Label resultLabel;
		
	// Main method
	public static void main(String[] args) {

		//Launching the application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		// Creating a label to use as a heading
		Label heading = new Label("This application will calculate a businessperson's travel expenses." +
		" \n\t    For any prompts that don't apply, please enter 0. \n\n" + 
				"The company reimburses travel expenses according to the following policy:\n" + 
				"• $47 per day for meals\n" + 
				"• Parking fees, up to $20.00 per day\n" + 
				"• Taxi charges up to $40.00 per day\n" + 
				"• Lodging charges up to $195.00 per day\n" + 
				"• If a private vehicle is used, $0.42 per mile driven");
			
		// Creating prompt labels to instruct user
		Label daysPromptLabel = new Label("Enter the number of days on the trip:");
		Label airfarePromptLabel = new Label("Enter the amount of airfare, if any:");
		Label carRentalFeesPromptLabel = new Label("Enter the amount of car rental fees, if any:");
		Label milesDrivenPromptLabel = new Label("Enter the number of miles driven in a private vehicle, if any:");
		Label parkingFeesPromptLabel = new Label("Enter the amount of parking fees, if any:");
		Label taxiChargesPromptLabel = new Label("Enter the amount of taxi charges, if any:");
		Label conferenceFeesPromptLabel = new Label("Enter the amount of conference registration " +
		"fees, if any:");		
		Label lodgingChargesPromptLabel = new Label("Enter the amount of lodging charges per night:");
		
		// Creating text fields for prompt labels
		TextField daysTextField = new TextField();
		TextField airfareTextField = new TextField();
		TextField carRentalFeesTextField = new TextField();
		TextField milesDrivenTextField = new TextField();
		TextField parkingFeesTextField = new TextField();
		TextField taxiChargesTextField = new TextField();
		TextField conferenceFeesTextField = new TextField();
		TextField lodgingChargesTextField = new TextField();
		
		// Creating a button to calculate expenses
		Button calcButton = new Button("Calculate");
			
		// Creating an event handler
		calcButton.setOnAction(new EventHandler<ActionEvent>() {
				
			@Override
			public void handle(ActionEvent event) {
					
				// Declaring double variable to store user text field input
				double days = Double.parseDouble(daysTextField.getText());
				double airfare = Double.parseDouble(airfareTextField.getText());
				double carRentalFees = Double.parseDouble(carRentalFeesTextField.getText());
				double milesDriven = Double.parseDouble(milesDrivenTextField.getText());				
				double parkingFees = Double.parseDouble(parkingFeesTextField.getText());				
				double taxiCharges = Double.parseDouble(taxiChargesTextField.getText());				
				double conferenceFees = Double.parseDouble(conferenceFeesTextField.getText());				
				double lodgingCharges = Double.parseDouble(lodgingChargesTextField.getText());

				// Adding the total expenses paid by the businessperson
				double totalExpenses = days + airfare + carRentalFees + milesDriven + parkingFees
						+ taxiCharges + conferenceFees + lodgingCharges;
				
				// Declaring and initializing the total of allowable expenses
				double totalAllowableExpenses = ((47 * days) + airfare + carRentalFees + 
						(milesDriven * 0.42) + (20 * days) + (40 * days) + conferenceFees + 
						(195 * days));
				
				// Declaring the amount that will be reimbursed
				double totalReimbursement = 0;
				
				//if-else-if statements to correctly calculate reimbursement
				if ((parkingFees / days) > 20 && (taxiCharges / days) > 40 && lodgingCharges > 195) {
					
					
					
					totalReimbursement = ((47 * days) + ((20 * days) - (parkingFees / days)) + 
							((40 * days) - (taxiCharges / days)) + ((195 * days) - 
							(lodgingCharges / days)) + (milesDriven * 0.42));
				}
				else if ((parkingFees / days) <= 20 && (taxiCharges / days) <= 40 && lodgingCharges <= 195) {
					totalReimbursement = ((47 * days) + parkingFees + taxiCharges + lodgingCharges + 
							(milesDriven * 0.42));
				}
				
				// Calculating excess businessperson must pay
				double excess = totalExpenses - totalAllowableExpenses;
				
				// Calculating amount saved
				double amountSaved = totalAllowableExpenses - totalExpenses;
				
				// Displaying the results
				resultLabel.setText(String.format("Total of trip expenses: $%,.2f", totalExpenses +
						"\nTotal allowable expenses: $%,.2f", totalAllowableExpenses +
						"\nTotal businessperson will be reimbursed: $%,.2f", totalReimbursement +
						"\nThe bussinessperson must pay an excess of: $%,.2f", excess +
						"\nTotal amount saved by the business person: $%,.2f", amountSaved));
			}
		});
			
		// Empty label to display the result
		Label resultLabel = new Label();
		
		// Putting the prompt labels in a VBox
		VBox vbox1 = new VBox(20, daysPromptLabel, airfarePromptLabel, carRentalFeesPromptLabel,
				milesDrivenPromptLabel, parkingFeesPromptLabel, taxiChargesPromptLabel, 
				conferenceFeesPromptLabel, lodgingChargesPromptLabel);
		
		// Aligning vbox1 to the center left
		vbox1.setAlignment(Pos.CENTER_LEFT);
		
		// Putting the text fields in a VBox
		VBox vbox2 = new VBox(12, daysTextField, airfareTextField, carRentalFeesTextField,
				milesDrivenTextField, parkingFeesTextField, taxiChargesTextField,
				conferenceFeesTextField, lodgingChargesTextField);
		
		// Aligning vbox2 to the center left
		vbox2.setAlignment(Pos.CENTER_LEFT);
		
		// Putting vbox1 and vbox2 in a HBox
		HBox hbox = new HBox(10, vbox1, vbox2);
		
		// Aligning hbox to the center
		hbox.setAlignment(Pos.CENTER);
		
		// Putting the heading, hbox, calcbutton, and resultlabel in a main VBox
		VBox vboxMain = new VBox(20, heading, hbox, calcButton, resultLabel);
		
		// Aligning the main VBox to the top center
		vboxMain.setAlignment(Pos.TOP_CENTER);
		
		// Setting the main VBox's padding
		vboxMain.setPadding(new Insets(10));
		
		// Creating a scene
		Scene scene = new Scene(vboxMain, 700, 700);
			
		// Adding the scene to the stage
		primaryStage.setScene(scene);
		
		// Setting the stage title
		primaryStage.setTitle("Travel Expenses Calculator");
		
		// Showing the window
		primaryStage.show();
	}
}