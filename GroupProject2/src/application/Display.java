package application;

import java.util.concurrent.CountDownLatch;

import HomeSecurity.SecuritySystemContext;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Display extends Application implements EventHandler<ActionEvent> {
	public static final CountDownLatch latch = new CountDownLatch(1);
	public static Display display = null;

	private Integer time;

	private static SecuritySystemContext securitySystem;
	private CheckBox zone1 = new CheckBox("Zone 1");
	private CheckBox zone2 = new CheckBox("Zone 2");
	private CheckBox zone3 = new CheckBox("Zone 3");

	private Button stay = new Button("Stay");
	private Button away = new Button("Away");
	private Button cancel = new Button("Cancel");
	private Button motionBtn;
	private TextField text;

	private Button button0 = new Button("0");
	private Button button1 = new Button("1");
	private Button button2 = new Button("2");
	private Button button3 = new Button("3");
	private Button button4 = new Button("4");
	private Button button5 = new Button("5");
	private Button button6 = new Button("6");
	private Button button7 = new Button("7");
	private Button button8 = new Button("8");
	private Button button9 = new Button("9");
	private final String checkPassword = "14741";
	private String password = "";
	Timeline timer;

	public SecuritySystemContext getSecuritySystem() {
		return securitySystem;
	}

	public void setSecuritySystem(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setTitle("Security System");
			GridPane mainPane = new GridPane();

			// Here is the Number Pad, I do have two blank buttons on there though. Got to
			// fix that
			GridPane numPad = new GridPane();

			button0.setOnAction(this);
			button1.setOnAction(this);
			button2.setOnAction(this);
			button3.setOnAction(this);
			button4.setOnAction(this);
			button5.setOnAction(this);
			button6.setOnAction(this);
			button7.setOnAction(this);
			button8.setOnAction(this);
			button9.setOnAction(this);

			numPad.add(button1, 0, 0);
			numPad.add(button2, 1, 0);
			numPad.add(button3, 2, 0);
			numPad.add(button4, 0, 1);
			numPad.add(button5, 1, 1);
			numPad.add(button6, 2, 1);
			numPad.add(button7, 0, 2);
			numPad.add(button8, 1, 2);
			numPad.add(button9, 2, 2);
			numPad.add(button0, 1, 3);

			text = new TextField();
			text.setText("Disarmed");
			text.setPrefHeight(100);
			text.setPrefWidth(400);

			GridPane zones = new GridPane();
			zones.add(zone1, 0, 0);
			zones.add(zone2, 1, 0);
			zones.add(zone3, 2, 0);
			zones.add(stay, 3, 0);
			zones.add(away, 4, 0);
			zones.add(cancel, 5, 0);
			zones.setHgap(10);

			motionBtn = new Button("Motion Detector");

			mainPane.add(numPad, 0, 0);
			mainPane.add(text, 1, 0);
			mainPane.add(zones, 0, 1, 2, 1);
			mainPane.add(motionBtn, 0, 2);

			// action listeners
			zone1.setOnAction(this);
			zone2.setOnAction(this);
			zone3.setOnAction(this);
			stay.setOnAction(this);
			away.setOnAction(this);
			cancel.setOnAction(this);
			motionBtn.setOnAction(this);

			scene = new Scene(mainPane, 500, 220);

			primaryStage.setScene(scene);
			primaryStage.show();

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in launch");
		}

		securitySystem.setDisplay(this);
	}

	@Override
	public void handle(ActionEvent event) {
		// button 0
		if (event.getSource().equals(button0) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 1
		else if (event.getSource().equals(button1) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 2
		else if (event.getSource().equals(button2) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 3
		else if (event.getSource().equals(button3) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 4
		else if (event.getSource().equals(button4) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 5
		else if (event.getSource().equals(button5) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 6
		else if (event.getSource().equals(button6) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 7
		else if (event.getSource().equals(button7) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 8
		else if (event.getSource().equals(button8) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// button 9
		else if (event.getSource().equals(button9) && allowPasword()) {
			String value = ((Button) event.getSource()).getText();
			password += value;
			text.setText(password);
			verifyPassword();
		}
		// Stay
		else if (event.getSource().equals(stay)) {
			if (securitySystem.isDoorOpen()) {
				securitySystem.pressStay();
			}
			resetPassword();
		}
		// Away
		else if (event.getSource().equals(away)) {
			if (securitySystem.isDoorOpen()) {
				securitySystem.pressAway();
			}
			resetPassword();
		}
		// Motion Detected
		else if (event.getSource().equals(motionBtn)) {
			securitySystem.motionDetected();
			text.setText(securitySystem.getCurrentState().toString());
		}
		// Zone Change
		else if (event.getSource().equals(zone1) || event.getSource().equals(zone2)
				|| event.getSource().equals(zone3)) {
			securitySystem.setDoorsOpen(isAnyDoorOpen());
			securitySystem.zonesOpen();
			text.setText(securitySystem.getCurrentState().toString());
		}
		//if cancel is pressed
		else if (event.getSource().equals(cancel) && allowPasword()) {
			if (!text.getText().equals("Password is incorrect!")) {
				text.setText("Enter Password");
			} else {
				text.setText(securitySystem.getCurrentState().toString());
			}
		}
	}

	// To reset password
	public void resetPassword() {
		password = "";
	}

	// Compares the password and displays correct or incorrect
	public void verifyPassword() {
		if (password.length() >= 5) {
			if (password.equals(checkPassword)) {
				text.setText("Password was correct!");
				securitySystem.passwordCorrect();
				text.setText(securitySystem.getCurrentState().toString());
				resetPassword();
			} else {
				text.setText("Password is incorrect!");
				resetPassword();
			}
		}
	}

	//check if in countdown, if so return false, which will not allow cancel button to work
	private boolean allowPasword() {
		if (securitySystem.getCurrentState().toString().equals("Countdown")) {
			return false;
		}
		return true;
	}

	//checks to see if any of the doors are open
	private boolean isAnyDoorOpen() {
		if (zone1.isSelected() && zone2.isSelected() && zone3.isSelected()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		securitySystem = SecuritySystemContext.getInstance();
		securitySystem.makeStates();
		Application.launch(args);
	}

	//timer method
	public void timer() {

		timer = new Timeline();
		timer.setCycleCount(Timeline.INDEFINITE);
		time = 10;

		text.setText(time.toString());
		timer.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				time--;
				text.setText(time.toString());

				if (time <= 0) {
					timer.stop();
					if (isAnyDoorOpen() || securitySystem.getCurrentState().toString().compareTo("Warning") == 0) {
						securitySystem.timerRunsOut();
						text.setText(securitySystem.getCurrentState().toString());
					} else {
						securitySystem.timerZoneOpen();
						text.setText(securitySystem.getCurrentState().toString());
					}
				}
			}
		}));

		timer.playFromStart();
	}

	public Timeline getTimer() {
		return timer;
	}

}