package application;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import HomeSecurity.SecuritySystemContext;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application implements EventHandler<ActionEvent> {
	public static final CountDownLatch latch = new CountDownLatch(1);
	public static Display display = null;

	private int time;

	private static SecuritySystemContext securitySystem;
	private CheckBox zone1 = new CheckBox("Zone 1");
	private CheckBox zone2 = new CheckBox("Zone 2");
	private CheckBox zone3 = new CheckBox("Zone 3");

	private Button stay = new Button("Stay");
	private Button away = new Button("Away");
	private Button cancel = new Button("Cancel");

	private Text timer = new Text("Timer: 00 seconds");

	public SecuritySystemContext getSecuritySystem() {
		return securitySystem;
	}

	public void setSecuritySystem(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	public static Display waitForDisplay() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return display;
	}

	public static void setDisplay(Display setDisplay) {
		display = setDisplay;
		latch.countDown();
	}

	public Display() {
		setDisplay(this);
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

			GridPane zones = new GridPane();
			zones.add(zone1, 0, 0);
			zones.add(zone2, 1, 0);
			zones.add(zone3, 2, 0);
			zones.add(stay, 3, 0);
			zones.add(away, 4, 0);
			zones.add(cancel, 5, 0);
			zones.add(timer, 6, 0);
			zones.setHgap(10);

			Button motionBtn = new Button("Motion Detector");
			Text status = new Text("Status: Armed");

			mainPane.add(numPad, 0, 0);
			mainPane.add(text, 1, 0);
			mainPane.add(zones, 0, 1, 2, 1);
			mainPane.add(motionBtn, 0, 2);
			mainPane.add(status, 0, 3);

			//action listeners
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
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource().equals(stay)) {
			//TODO
		}
		if (event.getSource().equals(away)) {
			//we might have to move timer into context and use clock class like in the book?
			time = 60;
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					if (time == 0) {
						timer.cancel();
					}
					displayTimer(time--);
				}
			}, 0, 1000);
		}
		if (event.getSource().equals(cancel)) {
			securitySystem.pressCancel();
		}
		if (event.getSource().equals(zone1) || event.getSource().equals(zone2) || event.getSource().equals(zone3)) {
			if (isAnyDoorOpen()) {
				securitySystem.zonesOpen();
			}
		}
	}

	private boolean isAnyDoorOpen() {
		if (!zone1.isSelected() || !zone2.isSelected() || !zone3.isSelected()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		securitySystem = SecuritySystemContext.getInstance();
		display.setsDisplay();
		Application.launch(args);
	}

	//sends a reference of itself to SS
	public void setsDisplay() {
		securitySystem.setDisplay(this);
	}

	//test method TODO: delete
	public void printStuff() {
		System.out.println("Calling method from outside class");
	}

	public void displayTimer(int seconds) {
		timer.setText("Timer: " + seconds + " seconds");
	}
}