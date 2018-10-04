package GUI;

import javax.swing.Timer;

public class Turret extends Thread {
	@Override
	public void run() {
		Turret_ai ai = new Turret_ai();
		Timer timerai = new Timer(1500, ai);
		timerai.start();

	}

}
