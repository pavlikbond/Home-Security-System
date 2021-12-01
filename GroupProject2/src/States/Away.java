package States;

import HomeSecurity.SecuritySystemContext;

public class Away extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Away(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {
		securitySystem.changeCurrentState(securitySystem.getCounting());

	}

	@Override
	public void zonesClose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressStay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressAway() {
		// TODO Auto-generated method stub

	}

	@Override
	public void motionDetected() {
		securitySystem.changeCurrentState(securitySystem.getCounting());

	}

	@Override
	public void passwordCorrect() {
		securitySystem.changeCurrentState(securitySystem.getDisarmed());

	}

	@Override
	public void passwordIncorrect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void timerRunsOut() {
		// TODO Auto-generated method stub

	}

}
