package States;

import HomeSecurity.SecuritySystemContext;

public class Disarmed extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Disarmed(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void pressStay() {
		securitySystem.changeCurrentState(securitySystem.getCountdownStay());
		securitySystem.getDisplay().timer();
	}

	@Override
	public void pressAway() {
		securitySystem.changeCurrentState(securitySystem.getCountdownAway());
		securitySystem.getDisplay().timer();
	}

	@Override
	public String toString() {
		return "Disarmed";
	}

}
