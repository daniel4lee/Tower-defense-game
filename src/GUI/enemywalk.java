package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class enemywalk implements ActionListener {
	int x = 5;
	int y = 0;
	Enemy E = new Enemy();
	Timer toStop;
	char[][] temp = new char[11][22];
	long startTime = System.currentTimeMillis();
	Boolean stop;
	ImageIcon enemyil = new ImageIcon("enemyl.png");
	ImageIcon enemyiu = new ImageIcon("enemyu.png");
	ImageIcon enemyid = new ImageIcon("enemyd.png");
	enemywalk(Boolean a) {
		stop = a;
		E.count = Main.i - 1;
		Main.arr.get(0).add(x);
		Main.arr.get(1).add(y);
		E.enemyl.setIcon(Main.p.enemyi);
		for (int j = 0; j < 11; j++) {
			for (int i = 0; i < 22; i++) {
				temp[j][i] = Main.p.map1[j][i];
			}
		}
	}

	public void gettimer(Timer t) {
		toStop = t;
	}

	public void actionPerformed(ActionEvent e) {
		if (Main.arr.get(0).get(E.count) == 1000 && Main.arr.get(1).get(E.count) == 1000) {
			E.enemyl.setIcon(Main.p.enemyi0);
			Main.p.enemy.remove(E.enemyl);
			Main.f.repaint();
			E.interrupt();
			toStop.stop();
		} else if (x == 21) {
			Main.p.enemy.remove(E.enemyl);
			Main.f.repaint();
			E.interrupt();
			toStop.stop();
			Main.life = Main.life - 1;
			if (Main.life == 2) {
				Main.p.life.setIcon(Main.p.life_1);
			} else if (Main.life == 1) {
				Main.p.life.setIcon(Main.p.life_2);
			} else if (Main.life == 0) {
				Main.p.life.setIcon(Main.p.life_3);
				//// game over
				menu.layback.remove(Main.p.army);
				menu.layback.remove(Main.p.map);
				menu.layback.remove(Main.p.help);
				menu.layback.remove(Main.p.back);
				menu.layback.remove(Main.p.quit);
				menu.layback.remove(Main.p.shooter);
				menu.layback.remove(Main.p.test);
				menu.layback.remove(Main.p.enemy);
				menu.layback.remove(Main.p.Bullet);
				for (int i = 0; i < 11; i++) {
					for (int j = 0; j < 22; j++) {
						Main.p.shooterarr[i][j].setIcon(Main.p.clear);

					}
				}
				Main.m.gameoverl.setIcon(Main.m.gameoveri);
				Main.m.gameover.add(Main.m.gameoverl);
				menu.layback.add(Main.m.gameover,new Integer(5));
				
			}
		} else if (x != 21) {
			temp[y][x] = '0';
			if (x == 5 && y == 0) {

				E.enemyl.setBounds(50 * x, 50 * y, 50, 50);
				Main.p.enemy.add(E.enemyl);
			}
			if (x > 0 && temp[y][x - 1] != '0') {
				temp[y][x - 1] = '0';
				x = x - 1;

				Main.arr.get(0).set(E.count, x);
				Main.arr.get(1).set(E.count, y);
				E.enemyl.setBounds(50 * x, 50 * y, 50, 50);
				E.enemyl.setIcon(enemyil);
				Main.p.enemy.add(E.enemyl);

			} else if (temp[y][x + 1] != '0' && x + 1 < 22) {
				temp[y][x + 1] = '0';
				x = x + 1;
				Main.arr.get(0).set(E.count, x);
				Main.arr.get(1).set(E.count, y);
				E.enemyl.setBounds(50 * x, 50 * y, 50, 50);
				E.enemyl.setIcon(Main.p.enemyi);
				Main.p.enemy.add(E.enemyl);
			} else if (temp[y + 1][x] != '0' && y + 1 < 11) {
				temp[y + 1][x] = '0';
				y = y + 1;
				Main.arr.get(0).set(E.count, x);
				Main.arr.get(1).set(E.count, y);
				E.enemyl.setBounds(50 * x, 50 * y, 50, 50);
				E.enemyl.setIcon(enemyid);
				Main.p.enemy.add(E.enemyl);
			} else if (y > 0 && temp[y - 1][x] != '0') {
				temp[y - 1][x] = '0';
				y = y - 1;
				Main.arr.get(0).set(E.count, x);
				Main.arr.get(1).set(E.count, y);
				E.enemyl.setBounds(50 * x, 50 * y, 50, 50);
				E.enemyl.setIcon(enemyiu);
				Main.p.enemy.add(E.enemyl);
			}

		}
		try {
			E.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
