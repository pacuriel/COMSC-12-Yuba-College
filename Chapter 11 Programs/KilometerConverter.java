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

public class KilometerConverter extends Application {

	// Fields
	private TextField kiloTextField;
	private Label resultLabel;
	
	public static void main(String[] args) {

		//Launch application
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		Label promptLabel = new Label("Enter a distance in kilometers:");
		
		kiloTextField = new TextField();
		
		Button calcButton = new Button("Convert");
		
		calcButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				double kilometers = Double.parseDouble(kiloTextField.getText());
				
				double miles = kilometers * 0.6214;
				
				resultLabel.setText(String.format("%,.2f miles", miles));
			}
		});
		
		resultLabel = new Label();
		
		HBox hbox = new HBox(10, promptLabel, kiloTextField);
		
		VBox vbox = new VBox(10, hbox, calcButton, resultLabel);
		
		vbox.setAlignment(Pos.CENTER);
		
		vbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(vbox);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Kilometer to Mile Converter");
		
		primaryStage.show();
	}
}