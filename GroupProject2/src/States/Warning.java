package States;

import HomeSecurity.SecuritySystemContext;

public class Warning extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Warning(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {
		// TODO Auto-generated method stub

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
		securitySystem.getDisplay().getTimer().stop();
		// securitySystem.displayState();
	}

	@Override
	public void timerRunsOut() {
		securitySystem.changeCurrentState(securitySystem.getAlerted());
		// securitySystem.displayState();
	}

	@Override
	public String toString() {
		return "Warning";
	}
}
