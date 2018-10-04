package GUI;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Enemy extends Thread {

	public JLabel enemyl = new JLabel();
	public int count = 0;
	Boolean stop = false;

	@Override
	public void run() {
		enemywalk ew = new enemywalk(stop);
		Timer timerw = new Timer(550,ew);
		ew.gettimer(timerw);
		timerw.start();
	}

}
