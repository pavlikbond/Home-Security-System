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
	public void passwordCorrect() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
		// securitySystem.displayState();
	}

	@Override
	public String toString() {
		return "Stay";
	}
}
