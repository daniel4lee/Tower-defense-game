package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class play extends JPanel {
	Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 35);
	Font font2 = new Font(Font.DIALOG_INPUT, Font.BOLD, 19);
	// ************************************************************//
	JLabel[][] grounds = new JLabel[11][22];
	// ************************************************************//
	ImageIcon basic = new ImageIcon("shooter.png");
	ImageIcon shooterr= new ImageIcon("shooterr.png");
	ImageIcon shooteru= new ImageIcon("shooteru.png");
	ImageIcon shooterd= new ImageIcon("turrentd.png");
	ImageIcon shooterL= new ImageIcon("shooterl.png");
	ImageIcon enemyi = new ImageIcon("enemy.png");
	ImageIcon enemyi0 = new ImageIcon("enemy0.png");
	ImageIcon bulleti = new ImageIcon("bullet.png");
	ImageIcon moneyi = new ImageIcon("money.png");
	// ************************************************************//
	ImageIcon lifefull = new ImageIcon("live.png");
	ImageIcon life_1 = new ImageIcon("live-1.png");
	ImageIcon life_2 = new ImageIcon("live-2.png");
	ImageIcon life_3 = new ImageIcon("live-3.png");
	// ************************************************************//
	ImageIcon clear = new ImageIcon("clear.png");
	ImageIcon snow = new ImageIcon("snow.png");
	ImageIcon snow4 = new ImageIcon("snow4.png");
	ImageIcon snow2 = new ImageIcon("snow2.png");
	ImageIcon snow3 = new ImageIcon("snow3.png");
	ImageIcon snow5 = new ImageIcon("snow5.png");
	ImageIcon snow6 = new ImageIcon("snow6.png");
	ImageIcon home = new ImageIcon("home.png");
	//************************************************************//
	ImageIcon straight_ = new ImageIcon("straight_.png");
	ImageIcon straight1 = new ImageIcon("straight1.png");
	ImageIcon right = new ImageIcon("right.png");// -|
	ImageIcon right2 = new ImageIcon("right2.png");// |-
	ImageIcon right3 = new ImageIcon("right3.png");// |-
	ImageIcon right4 = new ImageIcon("right4.png");// _|
	//************************************************************//
	// ImageIcon
	int ran = 0;// random
	char[][] map1 = new char[11][22];
	JButton btnhelp, btnback, btnquit;
	JButton btnshooter, btnstart;
	//************************************************************//
	JLabel moneycount;
	JLabel money;
	//************************************************************//
	JLabel life;
	JLabel shooterl;
	JLabel[][] shooterarr = new JLabel[11][22];
	JPanel army, map, choose;
	JPanel help, back, quit;
	JPanel test = new JPanel();
	JPanel shooter = new JPanel();
	JPanel enemy = new JPanel();
	JPanel Bullet = new JPanel();
	JPanel black=new JPanel();
	
	//************************************************************//
	play() {

		shooterl = new JLabel();
		moneycount = new JLabel();
		money = new JLabel();
		life = new JLabel();
		shooter = new JPanel();
		Bullet = new JPanel();
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 22; j++) {

				shooterarr[i][j] = new JLabel();
			}
		}
		btnhelp = new JButton("Help");
		btnback = new JButton("back");
		btnquit = new JButton("Quit");
		btnshooter = new JButton("Start");
		btnstart = new JButton();
		army = new JPanel();
		map = new JPanel();
		//
		back = new JPanel();
		help = new JPanel();
		quit = new JPanel();
		////
		test.setLayout(new GridLayout(11, 22));//////////
		test.setOpaque(false);
		test.setBounds(0, 0, 1100, 550);
		shooter.setLayout(new GridLayout(11, 22));//////////
		shooter.setOpaque(false);
		shooter.setBounds(0, 0, 1100, 550);
		Bullet.setOpaque(false);
		Bullet.setBounds(0, 0, 1100, 550);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 22; j++) {
				shooter.add(shooterarr[i][j]);
			}
		}
		//////
		black.setBounds(1100, 0,180, 550);
		black.setBackground(Color.BLACK);
		map.setLayout(new GridLayout(11, 22));
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 22; j++) {
				ran = (int) (Math.random() * 3 + 0);
				if (ran == 0) {
					grounds[i][j] = new JLabel(snow);
					map.add(grounds[i][j]);
				}
				if (ran == 1) {
					grounds[i][j] = new JLabel(snow2);
					map.add(grounds[i][j]);
				}
				if (ran == 2) {
					grounds[i][j] = new JLabel(snow3);
					map.add(grounds[i][j]);
				}
			}
		}
		for (int i = 0; i < 11; i++) {
			for (int j = 1; j < 22; j++) {
				ran = (int) (Math.random() * 25);
				if (ran == 3) {
					grounds[i][j].setIcon(snow4);
				}
			}
		}
		for (int i = 0; i < 11; i++) {
			ran = (int) (Math.random() * 2 + 0);
			if (ran == 1) {
				grounds[i][0].setIcon(snow6);
			}
			if (ran == 0) {
				grounds[i][0].setIcon(snow5);
			}
		}
		////
		if (Main.level == 0) {
			for (int i = 0; i < 4; i++) {
				grounds[i][5].setIcon(straight1);
			}
			grounds[4][5].setIcon(right4);
			grounds[4][4].setIcon(straight_);
			grounds[4][3].setIcon(right2);
			for (int i = 5; i < 9; i++) {
				grounds[i][3].setIcon(straight1);
			}
			grounds[9][3].setIcon(right3);
			for (int i = 4; i < 13; i++) {
				grounds[9][i].setIcon(straight_);
			}
			grounds[9][13].setIcon(right4);
			for (int i = 8; i > 4; i--) {
				grounds[i][13].setIcon(straight1);
			}
			grounds[4][13].setIcon(right2);
		}
		for (int i = 14; i < 22; i++) {
			grounds[4][i].setIcon(straight_);
		}
		grounds[4][21].setIcon(home);
		map.setBounds(0, 0, 1100, 550);
		/////// map
		enemy.setLayout(null);
		enemy.setOpaque(false);
		enemy.setBounds(0, 0, 1100, 550);
		shooterl.setIcon(basic);
		money.setIcon(moneyi);
		life.setIcon(lifefull);
		///
		army.setLayout(null);
		btnshooter.setIcon(basic);
		btnshooter.addActionListener(new function());
		btnshooter.setActionCommand("basic");
		btnshooter.setBounds(50, 0, 90, 145);
		Main.money = 200;
		Main.life = 3;
		moneycount.setForeground(Color.YELLOW);
		moneycount.setFont(font);
		moneycount.setText("$: " + Main.money);
		money.setBounds(450, 0, 162, 145);
		life.setBounds(800,0,300,130);
		army.add(life);
		moneycount.setBounds(600, 0, 200, 145);
		army.add(money);
		army.add(moneycount);
		army.add(btnshooter);
		btnstart.setFont(font2);
		btnstart.setText("START");
		btnstart.addActionListener(new function());
		btnstart.setActionCommand("start");
		btnstart.setBounds(300, 0, 90, 145);
		army.add(btnstart);
		army.setBounds(0, 550, 1280, 170);
		army.setBackground(Color.black);
		/////
		back.setOpaque(false);
		help.setOpaque(false);
		quit.setOpaque(false);
		back.add(btnback);
		help.add(btnhelp);
		quit.add(btnquit);
		back.setBounds(1150, 100, 70, 40);
		help.setBounds(1150, 200, 70, 40);
		quit.setBounds(1150, 300, 70, 40);
		btnback.addActionListener(new Change());
		btnhelp.addActionListener(new Change());
		btnquit.addActionListener(new Change());
		btnback.setActionCommand("p->m");
		btnhelp.setActionCommand("p->h");
		btnquit.setActionCommand("p->q");

	}
}
