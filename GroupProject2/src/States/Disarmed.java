package States;

import HomeSecurity.SecuritySystemContext;

public class Disarmed extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Disarmed(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	// displayState causes an error for some reason so I commented it out for now.
	@Override
	public void pressStay() {
		securitySystem.changeCurrentState(securitySystem.getCountdownStay());
		securitySystem.getDisplay().timer();
		// securitySystem.displayState();
	}

	@Override
	public void pressAway() {
		securitySystem.changeCurrentState(securitySystem.getCountdownAway());
		securitySystem.getDisplay().timer();
		// securitySystem.displayState();
	}

	@Override
	public String toString() {
		return "Disarmed";
	}

}
