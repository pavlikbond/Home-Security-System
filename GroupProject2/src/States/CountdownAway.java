package States;

import HomeSecurity.SecuritySystemContext;

public class CountdownAway extends HomeSecurityState {
	SecuritySystemContext securitySystem;

	public CountdownAway(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {

	}

	@Override
	public void timerZoneOpen() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
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
		securitySystem.changeCurrentState(securitySystem.getAway());
	}

	@Override
	public String toString() {
		return "Countdown";
	}
}
