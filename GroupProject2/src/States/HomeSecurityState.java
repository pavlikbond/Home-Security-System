package States;

import HomeSecurity.SecuritySystemContext;

public abstract class HomeSecurityState {
	protected static SecuritySystemContext context;

	protected HomeSecurityState() {
		context = SecuritySystemContext.getInstance();
	}

	public void zonesOpen() {
	};

	public void zonesClose() {
	};

	public void pressStay() {
	};

	public void pressCancel() {
	};

	public void pressAway() {
	};

	public void motionDetected() {
	};

	public void passwordCorrect() {
	};

	public void passwordIncorrect() {
	};

	public void timerRunsOut() {
	};
}
