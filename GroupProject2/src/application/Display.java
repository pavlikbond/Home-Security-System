package application;

import HomeSecurity.SecuritySystem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application {

	private SecuritySystem securitySystem;

	public SecuritySystem getSecuritySystem() {
		return securitySystem;
	}

	public void setSecuritySystem(SecuritySystem securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setTitle("Security System");
			GridPane mainPane = new GridPane();

			//Here is the Number Pad, I do have two blank buttons on there though. Got to fix that
			String[] keys = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
			GridPane numPad = new GridPane();
			for (int i = 0; i < 9; i++) {
				Button button = new Button(keys[i]);
				numPad.add(button, i % 3, (int) Math.ceil(i / 3));
			}
			Button button0 = new Button("0");
			numPad.add(button0, 1, 3);

			TextField text = new TextField();
			text.setPromptText("Password goes here?");
			text.setPrefHeight(100);
			text.setPrefWidth(400);

			//checkboxes and a few buttons
			CheckBox zone1 = new CheckBox("Zone 1");
			CheckBox zone2 = new CheckBox("Zone 2");
			CheckBox zone3 = new CheckBox("Zone 3");

			Button stay = new Button("Stay");
			Button away = new Button("Away");
			Button cancel = new Button("Cancel");

			GridPane zones = new GridPane();
			zones.add(zone1, 0, 0);
			zones.add(zone2, 1, 0);
			zones.add(zone3, 2, 0);
			zones.add(stay, 3, 0);
			zones.add(away, 4, 0);
			zones.add(cancel, 5, 0);
			zones.setHgap(10);

			Text status = new Text("Status: Armed");

			mainPane.add(numPad, 0, 0);
			mainPane.add(text, 1, 0);
			mainPane.add(zones, 0, 1, 2, 1);
			mainPane.add(new Button("Motion Detector"), 0, 2);
			mainPane.add(status, 0, 3);

			scene = new Scene(mainPane, 500, 220);

			//			root.setLeft(numPad);
			//			root.setRight(text);
			primaryStage.setScene(scene);
			primaryStage.show();

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
