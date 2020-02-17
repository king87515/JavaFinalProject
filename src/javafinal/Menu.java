package javafinal;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	ImageIcon img1 = new ImageIcon("start.png");
	ImageIcon img2 = new ImageIcon("help.png");
	ImageIcon img3 = new ImageIcon("exit.png");
	Image mouseimg = new ImageIcon("mouse.png").getImage();
	JButton start = new JButton(img1);
	JButton help = new JButton(img2);
	JButton exit = new JButton(img3);
	private ButtonHandler handler = new ButtonHandler();
	JLabel img = new JLabel(new ImageIcon("back.jpg"));
	Cursor cursor =  Toolkit.getDefaultToolkit().createCustomCursor(mouseimg,new Point(10,20), "");
	
	public Menu() {
		
		
		frame = new JFrame("音樂HarHar玩");
		frame.setLocation(250,150);
		frame.setSize(1200, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		start.setBounds(350, 200, 500, 100);//x,y,寬,高
		frame.add(start);
		help.setBounds(350, 300, 500, 100);
		frame.add(help);
		exit.setBounds(350, 400, 500, 100);
		frame.add(exit);
		frame.add(img);
		frame.setVisible(true);
		
		start.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ImageIcon start2 = new ImageIcon("start2.png");
		    	start.setIcon(start2);
		    	start.setCursor(cursor);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	start.setIcon(img1);
		    	start.setCursor(cursor);
		    }
		});
		help.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ImageIcon help2 = new ImageIcon("help2.png");
		    	help.setIcon(help2);
		    	help.setCursor(cursor);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	help.setIcon(img2);
		    	help.setCursor(cursor);
		    }
		});
		exit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	ImageIcon exit2 = new ImageIcon("exit2.png");
		    	exit.setIcon(exit2);
		    	exit.setCursor(cursor);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	exit.setIcon(img3);
		    	exit.setCursor(cursor);
		    }
		    
		});
		
		start.addActionListener(handler);
		help.addActionListener(handler);
		exit.addActionListener(handler);
		frame.setCursor(cursor);
		
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			if (E.getSource() == start) {
				frame.getContentPane().removeAll();
				new Music(frame);
			} else if (E.getSource() == help) {
				frame.getContentPane().removeAll();
				new Help(frame);

			} else if (E.getSource() == exit) {
				frame.dispose();
				return;
			}

		}
	}

	public static void main(String[] args) {
		
		new Menu();
		Music.maintableBGtop.setVisible(true);
	        Music.maintableBGdown.setVisible(true);   
			while(true){
				Music.maintableBGtop.stepTheBall();
				Music.maintableBGdown.stepTheBall();
	        }
		
	}
}
