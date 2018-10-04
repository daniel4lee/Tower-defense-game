package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menu extends JPanel {
	public JLabel labelback,gameoverl;
	public static JLayeredPane layback;
	public JPanel back;
	public JPanel gameover;
	/// background

	/// title
	public JButton btnhelp, btnplay, btnsetting, btnquit;
	public JPanel help, play, setting, quit;
	/// btn
	public ImageIcon cover = new ImageIcon("cover.png");
	public ImageIcon test = new ImageIcon("test.jpg");
	public ImageIcon playi = new ImageIcon("buttonplay.png");
	public ImageIcon helpi = new ImageIcon("buttonhelp.png");
	public ImageIcon quiti = new ImageIcon("buttonquit.png");
	public ImageIcon gameoveri = new ImageIcon("gameover.png");

	menu() {

		//// background
		layback = new JLayeredPane();
		back = new JPanel();
		labelback = new JLabel();
		gameoverl = new JLabel();
		labelback.setIcon(cover);
		back.add(labelback);
		back.setBounds(0, -10, 1280, 720);
		layback.add(back, new Integer(1));
		
		//// title part
		//// button
		btnhelp = new JButton();
		btnplay = new JButton();
		btnquit = new JButton();
		help = new JPanel();
		play = new JPanel();
		quit = new JPanel();
		gameover = new JPanel();

		
		play.setOpaque(false);
		btnplay.setBorderPainted(false);
		btnplay.setFocusPainted(false);
		btnplay.setContentAreaFilled(false);
		btnplay.setOpaque(false);
		btnplay.setIcon(playi);
		play.add(btnplay);
		help.setOpaque(false);
		btnhelp.setBorderPainted(false);
		btnhelp.setFocusPainted(false);
		btnhelp.setContentAreaFilled(false);
		btnhelp.setOpaque(false);
		btnhelp.setIcon(helpi);
		help.add(btnhelp);
		quit.setOpaque(false);
		gameover.setOpaque(false);
		btnquit.setBorderPainted(false);
		btnquit.setFocusPainted(false);
		btnquit.setContentAreaFilled(false);
		btnquit.setOpaque(false);
		btnquit.setIcon(quiti);
		quit.add(btnquit);
		play.setBounds(930, 330, 300, 90);
		help.setBounds(930, 430, 300, 90);
		quit.setBounds(905, 530, 300, 90);
		gameover.setBounds(0,-10,1280,720);
		layback.add(play, new Integer(3));
		layback.add(help, new Integer(3));
		layback.add(quit, new Integer(3));
		///
		btnplay.setActionCommand("m->p");
		btnhelp.setActionCommand("m->h");
		btnquit.setActionCommand("m->q");
		btnplay.getModel().addChangeListener(new Change());
		btnplay.addActionListener(new Change());
		btnhelp.getModel().addChangeListener(new Change());
		btnhelp.addActionListener(new Change());
		btnquit.getModel().addChangeListener(new Change());
		btnquit.addActionListener(new Change());
		

	}
}
