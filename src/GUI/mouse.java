package GUI;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class mouse extends MouseAdapter {
	public static int turretx = 0;
	public static int turrety = 0;
	long startTime = System.currentTimeMillis();

	mouse() {
	}

	public void mouseClicked(MouseEvent e) {
		Main.p.test.remove(Main.p.shooterl);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 22; j++) {
				if (e.getSource() == Main.p.grounds[i][j] && '0' == Main.p.map1[i][j] && Main.money >= 100) {
					// Main.p.test.remove(Main.p.shooterl);
					menu.layback.add(Main.p.Bullet, new Integer(6));
					turretx = j;
					turrety = i;
					Main.p.shooterarr[i][j].setIcon(Main.p.basic);
					Turret t = new Turret();
					t.start();
					Main.money = Main.money - 100;
					Main.p.moneycount.setText("$: "+Main.money);
				}
				if (Main.money < 100) {
					while (System.currentTimeMillis() - startTime < 1500) {
						///your money is not enough
						Main.p.moneycount.setText("$: "+(100-Main.money));
					}
					Main.p.moneycount.setText("$: "+Main.money);
				}
			}
		}
		Main.p.test.remove(Main.p.shooterl);
	}

	public void mouseExited(MouseEvent e) {
		Main.p.test.remove(Main.p.shooterl);
		Main.f.repaint();
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 22; j++) {
				if (e.getSource() == Main.p.grounds[i][j] && '0' == Main.p.map1[i][j]) {
					Main.p.shooterl.setBounds(j * 50, i * 50, 50, 50);
					Main.p.test.add(Main.p.shooterl);
				}
			}
		}

	}

	public void mouseMoved(MouseEvent e) {

	}
}
