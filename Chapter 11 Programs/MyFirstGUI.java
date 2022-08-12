import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class MyFirstGUI extends Application {

	private Label myLabel;
	
	public static void main(String[] args) {
		
		// Launch the application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		// Creating a Label control
		myLabel = new Label("Click the button to see a message.");
		
		// Creating a button control
		Button myButton = new Button("Click me!");
		
		// Registering the event handler
		myButton.setOnAction(new ButtonClickHandler());
		
		VBox vbox = new VBox(10, myLabel, myButton);
		
		Scene scene = new Scene(vbox, 300, 100);
		
		vbox.setAlignment(Pos.CENTER);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Button Demo");
		
		primaryStage.show();
	}
	
	// Event handler class for myButton
	class ButtonClickHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
			
			myLabel.setText("Thanks for clicking the button!");
		}
	}
}
