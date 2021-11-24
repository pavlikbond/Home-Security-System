package HomeSecurity;

public class Clock implements Runnable {
	private static SecuritySystemContext securitySystem;

	public Clock() {
		securitySystem = SecuritySystemContext.getInstance();
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				securitySystem.clockTicked();
			}
		} catch (InterruptedException ie) {
		}
	}
}
