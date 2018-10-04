package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class help extends JPanel {
	public JLabel helpl;
	public JPanel help,next,back;
	public ImageIcon helpi = new ImageIcon("help.png");
	public ImageIcon helpi1 = new ImageIcon("help1.png");
	public ImageIcon helpi2 = new ImageIcon("help2.png");
	JButton btnnext=new JButton("next");
	JButton btnback=new JButton("back");
	help() {
		helpl=new JLabel();
		help=new JPanel();
		next=new JPanel();
		back=new JPanel();
		helpl.setIcon(helpi);
		next.setOpaque(false);
		next.add(btnnext);
		next.setBounds(1100, 100, 100, 100);
		back.setOpaque(false);
		back.add(btnback);
		back.setBounds(1100, 300, 100, 100);
		help.add(helpl);
		help.setBounds(0,-10,1100,720);
		//nexttimes=0;
		btnback.addActionListener(new Change());
		btnback.setActionCommand("back");
		btnnext.addActionListener(new Change());
		btnnext.setActionCommand("next");
	}
}
