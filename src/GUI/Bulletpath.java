package GUI;

import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JLabel;
import java.util.Timer;
import javafx.util.Pair;

public class Bulletpath extends TimerTask {

	int amount;
	int displacement;
	JLabel bullet;
	double x, x1;
	double y, y1;
	int straight = 0;
	Timer t;
	ArrayList<Pair<Double, Double>> sorted;
int xc=0;
int yc=0;
	public Bulletpath(int a, int b, JLabel c, double x1, double y1, double e, double f, Timer t,int xc,int yc) {
		super();
		this.amount = a;
		this.displacement = b;
		this.bullet = c;
		this.x1 = x1;
		this.y1 = y1;
		this.x = e;
		this.y = f;
		this.straight = (int) f * 50;
		this.t = t;
		this.xc=yc;
		this.yc=xc;
	}

	public int function(double a, double b, double c, double d, double x) {
		return (int) (((c - d) / (a - b)) * (x - a) + c);
	}

	@Override
	public void run() {
		Main.p.shooterarr[(int) (xc)][(int) (yc)].setIcon(Main.p.basic);
		Main.p.Bullet.repaint();
		if (x * 50 < x1) {
			Main.p.shooterarr[(int) (xc)][(int) (yc)].setIcon(Main.p.shooterr);
			if (Math.abs(x1 - displacement) < 10 && Math.abs(y1 - function(x1, x * 50, y1, y * 50, displacement)) < 10) {
				for (int i = 0; i < Main.i; i++) {
					if (50 * (Main.arr.get(0).get(i) + 0.5) == x1 && 50 * (Main.arr.get(1).get(i) + 0.5) == y1) {
						Main.arr.get(0).set(i, 1000);
						Main.arr.get(1).set(i, 1000);
						Main.money = Main.money + 5;
						Main.p.moneycount.setText("$: "  + Main.money);
						Main.p.Bullet.remove(bullet);
						t.cancel();
					}
				}
			} // 射到
			else if (displacement < 0 || displacement > 1100 || function(x1, x * 50, y1, y * 50, displacement) > 550
					|| function(x1, x * 50, y1, y * 50, displacement) < 0) {
				Main.p.Bullet.remove(bullet);
				t.cancel();
			} // stop
			else {
				displacement = displacement + 10;
				bullet.setBounds(displacement, function(x1, x * 50, y1, y * 50, displacement), 50, 50);
				Main.p.Bullet.add(bullet);
			}
		} else if (x * 50 > x1) {
			Main.p.shooterarr[(int) (xc)][(int) (yc)].setIcon(Main.p.shooterL);
			if (Math.abs(x1 - displacement) < 10 && Math.abs(y1 - function(x1, x * 50, y1, y * 50, displacement)) < 10) {
				for (int i = 0; i < Main.i; i++) {
					if (50 * (Main.arr.get(0).get(i) + 0.5) == x1 && 50 * (Main.arr.get(1).get(i) + 0.5) == y1) {
						Main.arr.get(0).set(i, 1000);
						Main.arr.get(1).set(i, 1000);
						Main.money = Main.money + 5;
						Main.p.moneycount.setText("$: " + Main.money);
						Main.p.Bullet.remove(bullet);
						t.cancel();
					}

				}
			} // 射到
			else if (displacement < 0 || displacement > 1100 || function(x1, x * 50, y1, y * 50, displacement) > 550
					|| function(x1, x * 50, y1, y * 50, displacement) < 0) {
				Main.p.Bullet.remove(bullet);
				t.cancel();
			} else {
				displacement = displacement - 10;
				bullet.setBounds(displacement, function(x1, x * 50, y1, y * 50, displacement), 50, 50);
				Main.p.Bullet.add(bullet);
			}
		} else if (Math.abs(x * 50 - x1)<1&& y1 - y * 50 > 0) {
			Main.p.shooterarr[(int) (xc)][(int) (yc)].setIcon(Main.p.shooterd);
			if (Math.abs(x1 - 50*x) < 10 && Math.abs(y1 - straight) < 10) {
				for (int i = 0; i < Main.i; i++) {
					if (50 * (Main.arr.get(0).get(i) + 0.5) == x1 && 50 * (Main.arr.get(1).get(i) + 0.5) == y1) {
						Main.arr.get(0).set(i, 1000);
						Main.arr.get(1).set(i, 1000);
						Main.money = Main.money + 5;
						Main.p.moneycount.setText("$: "  + Main.money);
						Main.p.Bullet.remove(bullet);
						t.cancel();
					}
				}
			} // 射到
			else if (displacement < 0 || displacement > 1100 || function(x1, x * 50, y1, y * 50, displacement) > 550
					|| function(x1, x * 50, y1, y * 50, displacement) < 0) {
				Main.p.Bullet.remove(bullet);
				t.cancel();
			} else {
				straight = straight + 10;
				bullet.setBounds((int) x * 50, straight, 50, 50);
				Main.p.Bullet.add(bullet);
			}

		} else if (Math.abs(x * 50 - x1)<1 && y1 - y * 50 < 0) {
			Main.p.shooterarr[(int) (xc)][(int) (yc)].setIcon(Main.p.shooteru);
			if (Math.abs(x1 - 50*x) < 10 && Math.abs(y1 - straight) < 10) {
				for (int i = 0; i < Main.i; i++) {
					if (50 * (Main.arr.get(0).get(i) + 0.5) == x1 && 50 * (Main.arr.get(1).get(i) + 0.5) == y1) {
						Main.p.Bullet.remove(bullet);
						Main.arr.get(0).set(i, 1000);
						Main.arr.get(1).set(i, 1000);
						Main.money = Main.money + 5;
						Main.p.moneycount.setText("$: "  + Main.money);
						t.cancel();
					}
				}
			} // 射到
			else if (displacement < 0 || displacement > 1100 || function(x1, x * 50, y1, y * 50, displacement) > 550
					|| function(x1, x * 50, y1, y * 50, displacement) < 0) {
				Main.p.Bullet.remove(bullet);
				t.cancel();
			} else {
				straight = straight - 10;
				bullet.setBounds((int) x * 50, straight, 50, 50);
				Main.p.Bullet.add(bullet);
			}

		}

	}

}
