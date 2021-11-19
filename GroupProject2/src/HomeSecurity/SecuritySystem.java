package HomeSecurity;

import application.Display;

public class SecuritySystem {
	public enum States {
		ZONES_CLOSED_STATE, ZONES_OPEN_STATE, PASSWORD_CORRECT_STATE, PASSWORD_INCORRECT_STATE, DISARMED_STATE,
		ARMED_STATE, ALERTED_STATE,
	};

	private int timeLeft;
	private States currentState;
	private static SecuritySystem instance;
	private Display display;

	private SecuritySystem() {
		currentState = States.DISARMED_STATE;
		display = new Display();
		display.setSecuritySystem(this);
		timeLeft = 0;
	}

	//singleton
	public static SecuritySystem getInstance() {
		if (instance == null) {
			return instance = new SecuritySystem();
		}
		return instance;
	}

	public void clockTicked() {
		//TODO? possibly don't need this
	}
}
