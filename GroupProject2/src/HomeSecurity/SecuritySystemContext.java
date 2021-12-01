package HomeSecurity;

import States.Alerted;
import States.Away;
import States.Disarmed;
import States.HomeSecurityState;
import States.Stay;
import States.Warning;
import application.Display;

public class SecuritySystemContext {
	private int timeLeft;
	private HomeSecurityState currentState;
	private static SecuritySystemContext instance;
	private Display display;

	private HomeSecurityState alerted;
	private HomeSecurityState away;
	private HomeSecurityState warning;
	private HomeSecurityState disarmed;
	private HomeSecurityState stay;
	private boolean doorsOpen; //true means a door is open, false means a door is closed

	private SecuritySystemContext() {

		// this.alerted = new Alerted(this);
		// this.away = new Away(this);
		// this.counting = new Counting(this);
		// this.disarmed = new Disarmed(this);
		// this.stay = new Stay(this);
		// this.zonesClosed = new ZonesClosed(this);
		// this.zonesOpen = new ZonesOpen(this);
		// currentState = disarmed;
		display = new Display();
		display.setSecuritySystem(this);
		timeLeft = 0;
	}

	public void makeStates() {
		this.alerted = new Alerted(this);
		this.away = new Away(this);
		this.warning = new Warning(this);
		this.disarmed = new Disarmed(this);
		this.stay = new Stay(this);
		currentState = stay;
	}

	// singleton
	public static SecuritySystemContext getInstance() {
		if (instance == null) {
			return instance = new SecuritySystemContext();
		}
		return instance;
	}

	public void changeCurrentState(HomeSecurityState state) {
		currentState = state;
	}

	public HomeSecurityState getCurrentState() {
		return this.currentState;
	}

	public void clockTicked() {

	}

	// gets reference to Displa0 GUI object
	public void setDisplay(Display display) {
		this.display = display;
	}

	public void zonesOpen() {
		currentState.zonesOpen();
	}

	public void pressStay() {
		currentState.pressStay();
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

	public void timerRunsOut() {
		currentState.timerRunsOut();
	}

	public HomeSecurityState getAlerted() {
		return alerted;
	}

	public HomeSecurityState getAway() {
		return away;
	}

	public HomeSecurityState getWarning() {
		return warning;
	}

	public HomeSecurityState getDisarmed() {
		return disarmed;
	}

	public HomeSecurityState getStay() {
		return stay;
	}

	public void displayState() {
		display.display(currentState.toString());
	}

	public void setDoorsOpen(boolean status) {
		this.doorsOpen = status;
	}

	public boolean isDoorOpen() {
		return this.doorsOpen;
	}

}
