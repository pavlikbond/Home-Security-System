package States;

import HomeSecurity.SecuritySystemContext;

public class Disarmed extends HomeSecurityState {

	SecuritySystemContext securitySystem;

	public Disarmed(SecuritySystemContext securitySystem) {
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
		securitySystem.changeCurrentState(securitySystem.getStay());

	}

	@Override
	public void pressCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressAway() {
		securitySystem.changeCurrentState(securitySystem.getAway());

	}

	@Override
	public void motionDetected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void passwordCorrect() {
		// TODO Auto-generated method stub

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
