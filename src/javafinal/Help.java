package javafinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel lb;
	JFrame frame;
	ImageIcon back = new ImageIcon("back.png");
	JButton BtnBack = new JButton(back);
	private ButtonHandler handler = new ButtonHandler();
	
	public Help(JFrame frame) {
		super("操作說明");
		this.frame = frame;

		/*
		 * 背景
		 **/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(2, 40, 77));
		ImageIcon ic = new ImageIcon("help_bg.png");
		lb = new JLabel(ic);

		/*
		 * 返回按鈕
		 **/
		BtnBack.setBorderPainted(false);
		BtnBack.setBounds(5, 10, 90, 30);
		BtnBack.setBackground(new Color(2, 40, 77));
		BtnBack.setSize(90, 30);
		// BtnBack.setIcon(new
		// ImageIcon("D:\\00557103\\java_final_project\\java2018project-master\\demo1\\back.jpg"));
		frame.add(BtnBack);
		frame.add(lb);

		frame.setVisible(true);
		BtnBack.addActionListener(handler);
		BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ImageIcon back2 = new ImageIcon("back2.png");
		    	BtnBack.setIcon(back2);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	BtnBack.setIcon(back);
		    }
		});
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			if (E.getSource() == BtnBack) {
					frame.dispose();
					new Menu(); 
				
			}

		}
	}
}
