package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLabel;

public class function implements ActionListener {
	public boolean timertrigger = false;
	Timer timer = new Timer();
	long time = 2000;
	int count = 0;
	long startTime = System.currentTimeMillis();
	TimerTask task = new TimerTask() {
		public void run() {
			Enemy enemy = new Enemy();
			enemy.start();
			Main.i = Main.i + 1;
			if (count++ == 9) {
				time = time - 1000; // change the delay time
				timer.cancel();
				count = 0;
				update();
			}
		}
	};

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == "basic" && timertrigger == false && Main.money >= 100) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 22; j++) {
					Main.p.grounds[i][j].addMouseListener(new mouse());
					menu.layback.add(Main.p.shooter, new Integer(4));
					menu.layback.add(Main.p.test, new Integer(5));
				}
			}
		}
		if (cmd == "start" && timertrigger == false) {
			menu.layback.add(Main.p.enemy, new Integer(6));
			timertrigger = true;
			timer.scheduleAtFixedRate(task, 0, (long) time); // s/p

		}
		if (timertrigger == true) {
		}
	}

	public void update() {
		Timer t = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Enemy enemy = new Enemy();
				enemy.start();
				Main.i = Main.i + 1;
				if (count++ == 9) {
					if (time == 100) {
						t.cancel();
						count = 0;
						update();
					} else  {
						time = time - 100; // change the delay time
						t.cancel();
						count = 0;
						update();
					}
				}
			}
		};
		t.scheduleAtFixedRate(task, time + 500, time);
	}

}
