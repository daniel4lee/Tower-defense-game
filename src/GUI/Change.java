package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Change implements ActionListener, ChangeListener {
	Boolean isRollover = false;
	ImageIcon playti = new ImageIcon("buttonplayt.png");
	ImageIcon helpti = new ImageIcon("buttonhelpt.png");
	ImageIcon quitti = new ImageIcon("buttonquitt.png");
	

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == "m->p") {
			read r = new read();
			menu.layback.remove(Main.m.back);
			menu.layback.remove(Main.m.help);
			menu.layback.remove(Main.m.play);
			menu.layback.remove(Main.m.quit);
			Main.f.repaint();

			menu.layback.add(Main.p.army, new Integer(1));
			menu.layback.add(Main.p.map, new Integer(2));
			menu.layback.add(Main.p.back, new Integer(3));
			menu.layback.add(Main.p.quit, new Integer(3));
			menu.layback.add(Main.p.help, new Integer(3));
			menu.layback.add(Main.p.black, new Integer(2));
		}
		if (cmd == "m->h") {
			menu.layback.remove(Main.m.back);
			menu.layback.remove(Main.m.help);
			menu.layback.remove(Main.m.play);
			menu.layback.remove(Main.m.quit);
			Main.f.repaint();
			menu.layback.add(Main.h.help, new Integer(1));
			menu.layback.add(Main.h.next, new Integer(2));
			menu.layback.add(Main.h.back, new Integer(2));

		}
		if (cmd == "m->q") {
			Main.opt = JOptionPane.showConfirmDialog(Main.f, "You want to quit?", "Exit", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (Main.opt == JOptionPane.YES_OPTION)
				Main.f.dispose();
		}
		//////////
		if (cmd == "p->m") {
			Main.opt = JOptionPane.showConfirmDialog(Main.f, "You want back to menu?", "Exit",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (Main.opt == JOptionPane.YES_OPTION) {
				menu.layback.remove(Main.p.army);
				menu.layback.remove(Main.p.map);
				menu.layback.remove(Main.p.help);
				menu.layback.remove(Main.p.back);
				menu.layback.remove(Main.p.quit);
				menu.layback.remove(Main.p.shooter);
				menu.layback.remove(Main.p.test);
				menu.layback.remove(Main.p.enemy);
				menu.layback.remove(Main.p.Bullet);
				menu.layback.remove(Main.p.black);
				for (int i = 0; i < 11; i++) {
					for (int j = 0; j < 22; j++) {
						Main.p.shooterarr[i][j].setIcon(Main.p.clear);

					}
				}
				Main.f.repaint();
				menu.layback.add(Main.m.play, new Integer(3));
				menu.layback.add(Main.m.help, new Integer(3));
				menu.layback.add(Main.m.quit, new Integer(3));
				menu.layback.add(Main.m.back, new Integer(1));
			}
		}
		if (cmd == "p->h") {
			menu.layback.remove(Main.p.army);
			menu.layback.remove(Main.p.map);
			menu.layback.remove(Main.p.help);
			menu.layback.remove(Main.p.back);
			menu.layback.remove(Main.p.quit);
			menu.layback.remove(Main.p.shooter);
			menu.layback.remove(Main.p.test);
			menu.layback.remove(Main.p.enemy);
			menu.layback.remove(Main.p.Bullet);
			menu.layback.remove(Main.p.black);
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 22; j++) {
					Main.p.shooterarr[i][j].setIcon(Main.p.clear);

				}
			}
			Main.f.repaint();
			Main.f.repaint();
			menu.layback.add(Main.h.help, new Integer(1));
			menu.layback.add(Main.h.next, new Integer(2));
			menu.layback.add(Main.h.back, new Integer(2));
		}
		if (cmd == "p->q") {
			Main.opt = JOptionPane.showConfirmDialog(Main.f, "You want to quit?", "Exit", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (Main.opt == JOptionPane.YES_OPTION)
				Main.f.dispose();
		}
		if (cmd == "next" &&Main.nexttimes == 1) {
			Main.h.helpl.setIcon(Main.h.helpi2);
			Main.nexttimes = 2;
		} else if (cmd == "next" && Main.nexttimes == 0) {
			Main.h.helpl.setIcon(Main.h.helpi1);
			Main.nexttimes = 1;
		}
		if (cmd == "back" && Main.nexttimes == 0) {
			menu.layback.add(Main.m.play, new Integer(3));
			menu.layback.add(Main.m.help, new Integer(3));
			menu.layback.add(Main.m.quit, new Integer(3));
			menu.layback.add(Main.m.back, new Integer(1));
			Main.f.repaint();
			menu.layback.remove(Main.h.help);
			menu.layback.remove(Main.h.next);
			menu.layback.remove(Main.h.back);
			
		}
		if (cmd == "back" && Main.nexttimes == 1) {
			Main.h.helpl.setIcon(Main.h.helpi);
			Main.nexttimes = 0;
		}
		if (cmd == "back" && Main.nexttimes == 2) {
			Main.h.helpl.setIcon(Main.h.helpi1);
			Main.nexttimes = 1;
		}

	}

	public void stateChanged(ChangeEvent e) {
		ButtonModel model = (ButtonModel) e.getSource();
		/*******************************************************************/
		if (model.isPressed()) {
			if (model.getActionCommand().equals("m->p")) {
				Main.m.btnplay.setIcon(playti);
			} else if (model.getActionCommand().equals("m->h")) {
				Main.m.btnhelp.setIcon(helpti);
			} else if (model.getActionCommand().equals("m->q")) {
				Main.m.btnquit.setIcon(quitti);
			}
		} else if (model.isRollover() && !isRollover) {
			if (model.getActionCommand().equals("m->p")) {
				Main.m.btnplay.setIcon(playti);
			} else if (model.getActionCommand().equals("m->h")) {
				Main.m.btnhelp.setIcon(helpti);
			} else if (model.getActionCommand().equals("m->q")) {
				Main.m.btnquit.setIcon(quitti);
			}
			/*******************************************************************/
			isRollover = true;
		} else if (model.isArmed()) {
		} else {
			if (model.getActionCommand().equals("m->p")) {
				Main.m.btnplay.setIcon(Main.m.playi);
			} else if (model.getActionCommand().equals("m->h")) {
				Main.m.btnhelp.setIcon(Main.m.helpi);
			} else if (model.getActionCommand().equals("m->q")) {
				Main.m.btnquit.setIcon(Main.m.quiti);
			}
			/*******************************************************************/
			isRollover = false;
		}
	}
}
