package States;

import HomeSecurity.SecuritySystemContext;

public class CountdownAway extends HomeSecurityState {
	SecuritySystemContext securitySystem;

	public CountdownAway(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void timerZoneOpen() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
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
