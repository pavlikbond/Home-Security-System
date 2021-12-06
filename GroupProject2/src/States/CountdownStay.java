package States;

import HomeSecurity.SecuritySystemContext;

public class CountdownStay extends HomeSecurityState {
	SecuritySystemContext securitySystem;

	public CountdownStay(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void timerZoneOpen() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
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
