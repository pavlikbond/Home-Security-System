package States;

import HomeSecurity.SecuritySystemContext;

public class CountdownStay extends HomeSecurityState {
	SecuritySystemContext securitySystem;

	public CountdownStay(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {

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

	}

	@Override
	public void timerRunsOut() {
		// if doors are open when timers runs out, change state to disarmed
		securitySystem.changeCurrentState(securitySystem.getStay());
	}

	@Override
	public String toString() {
		return "Countdown";
	}
}
