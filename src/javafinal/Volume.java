package javafinal;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
public class Volume extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("調整音量及速度");
	JLabel guitarvol = new JLabel("吉他");
	JLabel pianovol = new JLabel("鋼琴");
	JLabel bassvol = new JLabel("貝斯");
	JLabel drumvol = new JLabel("打擊");
	JLabel metronomevol = new JLabel("節拍器");
	JLabel speed = new JLabel("速度");
	JPanel panel = new JPanel();
	JPanel blank = new JPanel();
	JButton confirm = new JButton("確認");
	JButton cancel = new JButton("取消");
	Image mouseimg = new ImageIcon("mouse2.png").getImage();
	Cursor cursor =  Toolkit.getDefaultToolkit().createCustomCursor(mouseimg,new Point(10,20), "");
	static float guitar=50;
	static float piano=50;
	static float bass=50;
	static float drum=50;
	static float metronome=50;
	static float speednum = 100;

	public Volume()
	{
		JSlider field1 = new JSlider();
		field1.setPaintTicks(false);
		field1.setPaintLabels(true);
		field1.setMajorTickSpacing(100);
		JSlider field2 = new JSlider();
		field2.setPaintTicks(false);
		field2.setPaintLabels(true);
		field2.setMajorTickSpacing(100);
		JSlider field3 = new JSlider();
		field3.setPaintTicks(false);
		field3.setPaintLabels(true);
		field3.setMajorTickSpacing(100);
		JSlider field4 = new JSlider();
		field4.setPaintTicks(false);
		field4.setPaintLabels(true);
		field4.setMajorTickSpacing(100);
		JSlider field5 = new JSlider();
		field5.setPaintTicks(false);
		field5.setPaintLabels(true);
		field5.setMajorTickSpacing(100);
		JSlider field6 = new JSlider();
		field6.setPaintTicks(false);
		field6.setPaintLabels(true);
		field6.setMajorTickSpacing(100);
		JLabel guitarvolnum = new JLabel();
		JLabel pianovolnum = new JLabel();
		JLabel bassvolnum = new JLabel();
		JLabel drumvolnum = new JLabel();
		JLabel metronomevolnum = new JLabel();
		JLabel speedtempo = new JLabel();
		ImageIcon img1 = new ImageIcon("./src/1.jpg");
		ImageIcon img2 = new ImageIcon("./src/2.jpg");
		ImageIcon img3 = new ImageIcon("./src/3.jpg");
		ImageIcon img4 = new ImageIcon("./src/4.jpg");
		ImageIcon img5 = new ImageIcon("./src/5.jpg");
		@SuppressWarnings("unused")
		ImageIcon img6 = new ImageIcon("./src/6.jpg");
		guitarvolnum.setIcon(img1);
		pianovolnum.setIcon(img2);
		bassvolnum.setIcon(img3);
		drumvolnum.setIcon(img4);
		metronomevolnum.setIcon(img5);
		frame.setLocation(700,400);
		frame.setSize(300,400);
		frame.setLayout(new GridLayout(7,3));
		frame.setVisible(false);
		frame.setResizable(false);
		frame.add(guitarvol);
		frame.add(guitarvolnum);
		frame.add(field1);
		frame.add(pianovol);
		frame.add(pianovolnum);
		frame.add(field2);
		frame.add(bassvol);
		frame.add(bassvolnum);
		frame.add(field3);
		frame.add(drumvol);
		frame.add(drumvolnum);
		frame.add(field4);
		frame.add(metronomevol);
		frame.add(metronomevolnum);
		frame.add(field5);
		frame.add(speed);
		frame.add(speedtempo);
		frame.add(field6);
		frame.add(blank);
		panel.add(confirm);
		blank.add(cancel);
		frame.add(panel);
		frame.setCursor(cursor);
		
		confirm.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						guitar = field1.getValue();
						piano = field2.getValue();
						bass = field3.getValue();
						drum = field4.getValue();
						metronome = field5.getValue();
						speednum = field6.getValue()+50;
						frame.dispose();
					}
			
				});

		cancel.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.dispose();
					}
			
				});
		
	}
	
	public void show()
	{
		frame.setVisible(true);
	}
	
	public float getGuitarVolume()
	{
		if(guitar-80>6)
			return 6;
		else if(guitar-80<-80)
			return -80;
		return guitar-80;
	}

	public float getPianoVolume()
	{
		if(piano-80>6)
			return 6;
		else if(piano-80<-80)
			return -80;
		return piano-80;
	}
	

	public float getBassVolume()
	{
		if(bass-80>6)
			return 6;
		else if(bass-80<-80)
			return -80;
		return bass-80;
	}
	

	public float getDrumVolume()
	{
		if(drum-80>6)
			return 6;
		else if(drum-80<-80)
			return -80;
		return drum-80;
	}
	

	public float getMetronomeVolume()
	{
		if(metronome-80>6)
			return 6;
		else if(metronome-80<-80)
			return -80;
		return metronome-80;
	}
	

	public int getSpeed()
	{
		return  (int) ((int)1000/(speednum/60));
	}
	
}
