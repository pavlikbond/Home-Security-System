package States;

import HomeSecurity.SecuritySystemContext;

public class Stay extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Stay(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {
		securitySystem.changeCurrentState(securitySystem.getAlerted());
		// securitySystem.displayState();
	}

	@Override
	public void timerZoneOpen() {

	}

	@Override
	public void pressStay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressAway() {
		// TODO Auto-generated method stub

	}

	@Override
	public void motionDetected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void passwordCorrect() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
		// securitySystem.displayState();
	}

	@Override
	public void timerRunsOut() {
		// if doors are open when timers runs out, change state to disarmed

		// securitySystem.displayState();
	}

	@Override
	public String toString() {
		return "Stay";
	}
}
