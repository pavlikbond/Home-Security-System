package States;

import HomeSecurity.SecuritySystemContext;

public class Alerted extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Alerted(SecuritySystemContext securitySystem) {
		this.securitySystem = securitySystem;
	}

	@Override
	public void zonesOpen() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
