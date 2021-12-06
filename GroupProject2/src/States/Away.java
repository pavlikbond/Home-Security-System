package States;

import HomeSecurity.SecuritySystemContext;

public class Away extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Away(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {
		securitySystem.changeCurrentState(securitySystem.getWarning());
		securitySystem.getDisplay().timer();
		// securitySystem.displayState();
	}

	@Override
	public void motionDetected() {
		securitySystem.changeCurrentState(securitySystem.getWarning());
		securitySystem.getDisplay().timer();
		// securitySystem.displayState();
	}

	@Override
	public void passwordCorrect() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
		// securitySystem.displayState();
	}

	@Override
	public String toString() {
		return "Away";
	}

}
