package States;

import HomeSecurity.SecuritySystemContext;

public class Alerted extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Alerted(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void passwordCorrect() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());
	}

	@Override
	public String toString() {
		return "Alerted";
	}

}
