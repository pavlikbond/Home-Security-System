package States;

import HomeSecurity.SecuritySystemContext;

public class Warning extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Warning(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
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
