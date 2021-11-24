package HomeSecurity;

import States.HomeSecurityState;
import application.Display;

public class SecuritySystemContext {
	private int timeLeft;
	private HomeSecurityState currentState;
	private static SecuritySystemContext instance;
	private Display display;

	private SecuritySystemContext() {
		display = new Display();
		display.setSecuritySystem(this);
		timeLeft = 0;
	}

	//singleton
	public static SecuritySystemContext getInstance() {
		if (instance == null) {
			return instance = new SecuritySystemContext();
		}
		return instance;
	}

	public void changeCurrentState(HomeSecurityState state) {
		currentState = state;
	}

	public void clockTicked() {

	}

	//gets reference to Displa0 GUI object
	public void setDisplay(Display display) {
		this.display = display;
	}

	public void zonesOpen() {
		currentState.zonesOpen();
	}

	public void zonesClose() {
		currentState.zonesClose();
	}

	public void pressStay() {
		currentState.pressStay();
	}

	public void pressCancel() {
		currentState.pressCancel();
	}

	public void pressAway() {
		currentState.pressAway();
	}

	public void motionDetected() {
		currentState.motionDetected();
	}

	public void passwordCorrect() {
		currentState.passwordCorrect();
	}

	public void passwordIncorrect() {
		currentState.passwordIncorrect();
	}

	public void timerRunsOut() {
		currentState.timerRunsOut();
	}
}
