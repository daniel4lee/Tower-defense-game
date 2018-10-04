package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;
import javafx.util.*;
import javax.swing.JLabel;

public class Turret_ai implements ActionListener {
	double x = 0;
	double y = 0;
	int xc=0;
	int yc=0;
	static int amount = 0;
	int displacement = 0;
	JLabel bullet = new JLabel();

	boolean inregion = false;

	Turret_ai() {
		x = mouse.turretx + 0.5;
		xc=mouse.turretx;
		yc=mouse.turrety;
		displacement = mouse.turretx * 50 + 25;
		y = mouse.turrety + 0.5;
		bullet.setIcon(Main.p.bulleti);
		
	}

	public double distance(double a, double b, double c, double d) {
		return Math.pow((Math.pow(a - b, 2) + Math.pow(c - d, 2)), 0.5);
	}

	public int function(double a, double b, double c, double d, double x) {
		return (int) (((c - d) / (a - b)) * (x - a) + c);
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<Pair<Double, Double>> sorted = new ArrayList<>();
		if (Main.i != 0) {
			for (int i = 0; i < Main.i; i++) {
				if (distance(Main.arr.get(0).get(i) + 0.5, x, Main.arr.get(1).get(i) + 0.5, y) < 3) {
					sorted.add(new Pair<>((double) (Main.arr.get(0).get(i) + 0.5),
							(double) (Main.arr.get(1).get(i) + 0.5)));
					amount++;
					inregion = true;
				}
				Comparator<Pair<Double, Double>> cmprtr = new Comparator<Pair<Double, Double>>() {
					@Override
					public int compare(Pair<Double, Double> o1, Pair<Double, Double> o2) {
						if (o1.getKey() < o2.getKey()) {
							return -1;
						} else {
							return 1;
						}
					}
				};
				Collections.sort(sorted, cmprtr);
			}
		}
		if (inregion == true) {
			Timer ballistic = new Timer();
			ballistic.scheduleAtFixedRate(new Bulletpath(amount, displacement, bullet,
					sorted.get(amount - 1).getKey() * 50, sorted.get(amount - 1).getValue() * 50, x, y,ballistic, xc, yc), 10, 20);
			// s/p
			sorted.removeAll(sorted);
			inregion = false;
			amount = 0;
		}
	}

	public static void Sort(double[][] array) {
		for (int i = array[0].length - 1; i > 0; --i)
			for (int j = 0; j < i; ++j)
				if (array[0][j] > array[0][j + 1])
					Swap(array, j, j + 1);
	}

	private static void Swap(double[][] array, int indexA, int indexB) {
		double tmp = array[0][indexA];
		array[0][indexA] = array[0][indexB];
		array[0][indexB] = tmp;
	}

}
