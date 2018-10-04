	package GUI;

import javax.swing.JFrame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static final menu m = new menu();
	public static final JFrame f = new JFrame();
	public static final help h = new help();
	public static final play p = new play();
	public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	public static int opt = 0;
	public static int level = 0;
	public static int i = 0;
	public static int money;
	public static int life;
	public static int nexttimes = 0;
	public static void main(String args[]) {
		arr.add(new ArrayList<>());
		arr.add(new ArrayList<>());
		f.setTitle("Tower Defense");
		f.setSize(1280, 725);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.add(menu.layback);
		
	}
}
