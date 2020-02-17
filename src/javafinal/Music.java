package javafinal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Music extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread th1;
	static Volume volume = new Volume();
	JLabel TableList = new JLabel("--------列表--------");
	//JPanel maintable = new JPanel();
	JPanel maintable = new JPanel();
	public static MyPanel maintableBGtop = new MyPanel(30,900,200);
	public static MyPanel maintableBGdown = new MyPanel(30,900,252);
	JPanel ListPanel = new JPanel();
	JPanel instruPanel = new JPanel();
	JPanel playPanel = new JPanel();
	JButton BPiano = new JButton("鋼琴");
	JButton BGuitar = new JButton("吉他");
	JButton BBass = new JButton("Bass");
	JButton BDrum = new JButton("鼓組");
	JButton BBack = new JButton("返回");
	JButton save = new JButton("儲存");
	JButton clear = new JButton("清空");
	JButton load = new JButton("匯入");
	JButton mGame = new JButton("遊戲");
	JButton Volumebut = new JButton("🔊");
	JButton Pause = new JButton("II");
	JButton Stop = new JButton("■");
	JButton loop = new JButton("🔁");
	JButton Play = new JButton("▶");	
	Image mouseimg = new ImageIcon("mouse2.png").getImage();
	Image mouseimg2 = new ImageIcon("mouse.png").getImage();
	Cursor cursor =  Toolkit.getDefaultToolkit().createCustomCursor(mouseimg,new Point(10,20), "");
	Cursor cursor2 =  Toolkit.getDefaultToolkit().createCustomCursor(mouseimg2,new Point(10,20), "");
	static JCheckBox tempo = new JCheckBox("節拍器");
	static Boolean controlstop =false;
	static Boolean controlpause = false;
	static Boolean controlloop = false;
	
	static MyTable guitartable = new MyTable();
	static MyTable pianotable = new MyTable();
	static MyTable basstable = new MyTable();
	static MyTable drumtable = new MyTable();

	JFrame frame;
	public static DontTouchTheWhiteTile dttwt;
	private ButtonHandler handler = new ButtonHandler();
	
	public Music(JFrame frame) {
		this.frame=frame;	
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(2, 40, 77));
		maintable.setBounds(302, 183, 900, 240);
		maintableBGtop.setBounds(302, 3, 900, 180);/********/
		maintableBGdown.setBounds(302, 423, 900, 172);/********/
		ListPanel.setBounds(2, 3, 298, 50);
		ListPanel.setBackground(new Color(214,220,231));//豆
		maintable.setBackground(new Color(0,0,0));//豆
		maintableBGtop.setBackground(new Color(0,0,0));//豆
		maintableBGdown.setBackground(new Color(0,0,0));//豆
		TableList.setBounds(30, 100, 200, 50);
		TableList.setFont(new Font("微軟正黑體", 1, 35));
		ListPanel.add(TableList);
		
		String textguitar = "./guitar/Acoustic Guitar";
		guitartable.getTable().setGridColor(Color.BLACK);
		guitartable.setText(textguitar);
		guitartable.addListener(maintable);
		guitartable.setTable();
		
		String textpiano = "./piano/Piano";
		pianotable.getTable().setGridColor(Color.BLACK);
		pianotable.setText(textpiano);
		pianotable.addListener(maintable);
		pianotable.setTable();
		
		String textbass = "./bass/Bass";
		basstable.getTable().setGridColor(Color.BLACK);
		basstable.setText(textbass);
		basstable.addListener(maintable);
		basstable.setTable();
		
		String textdrum = "./drum/";
		drumtable.getTable().setGridColor(Color.BLACK);
		drumtable.setText(textdrum);
		drumtable.addListener(maintable);
		drumtable.setTable();
		
		maintable.setLayout(null);
	
		
		instruPanel.setBounds(2, 50, 298, 548);
		instruPanel.setLayout(new GridLayout(5, 1, 0, 10));
		instruPanel.setBackground(new Color(214,220,231));
		BPiano.setBackground(new Color(2, 40, 77));
		BPiano.setFont(new Font("微軟正黑體", 1, 30));
		BPiano.setForeground(new Color(0, 255, 247));
		BPiano.setCursor(cursor2);
		BGuitar.setBackground(new Color(2, 40, 77));
		BGuitar.setForeground(new Color(0, 255, 247));
		BGuitar.setFont(new Font("微軟正黑體", 1, 30));
		BGuitar.setCursor(cursor2);
		BDrum.setBackground(new Color(2, 40, 77));
		BDrum.setForeground(new Color(0, 255, 247));
		BDrum.setFont(new Font("微軟正黑體", 1, 30));
		BDrum.setCursor(cursor2);
		BBass.setBackground(new Color(2, 40, 77));
		BBass.setForeground(new Color(0, 255, 247));
		BBass.setFont(new Font("微軟正黑體", 1, 30));
		BBass.setCursor(cursor2);
		BBack.setBackground(new Color(2, 40, 77));
		BBack.setForeground(new Color(0, 255, 247));
		BBack.setFont(new Font("微軟正黑體", 1, 30));
		BBack.setCursor(cursor2);
		load.setBackground(new Color(2, 40, 77));
		load.setForeground(new Color(0, 255, 247));
		load.setFont(new Font("微軟正黑體", 1, 30));
		load.setCursor(cursor2);
		save.setBackground(new Color(2, 40, 77));
		save.setForeground(new Color(0, 255, 247));
		save.setFont(new Font("微軟正黑體", 1, 30));
		save.setCursor(cursor2);
		mGame.setBackground(new Color(2, 40, 77));
		mGame.setForeground(new Color(0, 255, 247));
		mGame.setFont(new Font("微軟正黑體", 1, 30));
		mGame.setCursor(cursor2);
		clear.setBackground(new Color(2, 40, 77));
		clear.setForeground(new Color(0, 255, 247));
		clear.setFont(new Font("微軟正黑體", 1, 30));
		clear.setCursor(cursor2);
		
		instruPanel.add(BPiano);
		instruPanel.add(BGuitar);
		instruPanel.add(BDrum);
		instruPanel.add(BBass);
		instruPanel.add(load);	
		instruPanel.add(save);
		instruPanel.add(mGame);
		instruPanel.add(clear);
		instruPanel.add(BBack);
		
		mGame.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.setVisible(false);
						dttwt = new DontTouchTheWhiteTile(frame);
					}
				});
		
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder builder = new StringBuilder();
				builder.append("G\n");

				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showOpenDialog(null);
				FileReader file = null;
				if (retrival == JFileChooser.APPROVE_OPTION)
					try {
						file = new FileReader(chooser.getSelectedFile());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				String[][] title1 = new String[15][17];
				String[][] title2 = new String[15][17];
				String[][] title3 = new String[15][17];
				String[][] title4 = new String[15][17];
				BufferedReader reader = new BufferedReader(file);
				String line = "";
				int row = 0;
				try {
					reader.readLine(); // consume first line and ignore

					int counter = 0;

					while (counter != 15 && (line = reader.readLine()) != null) {
						String[] cols = line.split(" "); // note that if you have used space as separator you have to
															// split on " "
						int col = 1;
						for (String c : cols) {
							title1[row][col] = c;
							builder.append(c);
							builder.append(" ");
							col++;
						}
						row++;
						counter++;
						builder.append("\n");
					}
					reader.readLine(); // consume first line and ignore

					row = 0;

					counter = 0;
					builder.append("P\n");
					while (counter != 15 && (line = reader.readLine()) != null) {
						String[] cols = line.split(" "); // note that if you have used space as separator you have to
															// split on " "
						int col = 1;
						for (String c : cols) {
							title2[row][col] = c;
							builder.append(c);
							builder.append(" ");
							col++;
						}
						row++;
						counter++;
						builder.append("\n");
					}
					reader.readLine(); // consume first line and ignore
					row = 0;
					counter = 0;
					builder.append("B\n");
					while (counter != 15 && (line = reader.readLine()) != null) {
						String[] cols = line.split(" "); // note that if you have used space as separator you have to
															// split on " "
						int col = 1;
						for (String c : cols) {
							title3[row][col] = c;
							builder.append(c);
							builder.append(" ");
							col++;
						}
						row++;
						counter++;
						builder.append("\n");
					}
					reader.readLine(); // consume first line and ignore
					row = 0;
					counter = 0;
					builder.append("D\n");
					while (counter != 15 && (line = reader.readLine()) != null) {
						String[] cols = line.split(" "); // note that if you have used space as separator you have to
															// split on " "
						int col = 1;
						for (String c : cols) {
							title4[row][col] = c;
							builder.append(c);
							builder.append(" ");
							col++;
						}
						row++;
						builder.append("\n");
						counter++;
					}

					System.out.println(builder);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					reader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				guitartable.settitle(title1);
				pianotable.settitle(title2);
				basstable.settitle(title3);
				drumtable.settitle(title4);
				pianotable.refreshTable(maintable);
			}

		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {

					Object[][] title1 = guitartable.getTitle();
					Object[][] title2 = pianotable.getTitle();
					Object[][] title3 = basstable.getTitle();
					Object[][] title4 = drumtable.getTitle();
					StringBuilder builder = new StringBuilder();
					builder.append("G\n");
					for (int i = 0; i < 15; i++)// for each row
					{
						for (int j = 1; j < 17; j++)// for each column
						{

							if (title1[i][j] != "") {
								builder.append("T");// append to the output string
								// System.out.println("T");
							} else if (title1[i][j] == "") {
								builder.append("F");// append to the output string
								// System.out.println("F");
							}

							if (j < 17)// if this is not the last row element
								builder.append(" ");// then add comma (if you don't like commas you can use spaces)
						}
						// System.out.println(builder);
						builder.append("\n");// append new line at the end of the row
					}
					builder.append("P\n");
					for (int i = 0; i < 15; i++)// for each row
					{
						for (int j = 1; j < 17; j++)// for each column
						{

							if (title2[i][j] != "") {
								builder.append("T");// append to the output string
								// System.out.println("T");
							} else if (title2[i][j] == "") {
								builder.append("F");// append to the output string
								// System.out.println("F");
							}

							if (j < 17)// if this is not the last row element
								builder.append(" ");// then add comma (if you don't like commas you can use spaces)
						}
						// System.out.println(builder);
						builder.append("\n");// append new line at the end of the row
					}
					builder.append("B\n");
					for (int i = 0; i < 15; i++)// for each row
					{
						for (int j = 1; j < 17; j++)// for each column
						{

							if (title3[i][j] != "") {
								builder.append("T");// append to the output string
								// System.out.println("T");
							} else if (title3[i][j] == "") {
								builder.append("F");// append to the output string
								// System.out.println("F");
							}

							if (j < 17)// if this is not the last row element
								builder.append(" ");// then add comma (if you don't like commas you can use spaces)
						}
						// System.out.println(builder);
						builder.append("\n");// append new line at the end of the row
					}

					builder.append("D\n");
					for (int i = 0; i < 15; i++)// for each row
					{
						for (int j = 1; j < 17; j++)// for each column
						{

							if (title4[i][j] != "") {
								builder.append("T");// append to the output string
								// System.out.println("T");
							} else if (title4[i][j] == "") {
								builder.append("F");// append to the output string
								// System.out.println("F");
							}

							if (j < 17)// if this is not the last row element
								builder.append(" ");// then add comma (if you don't like commas you can use spaces)
						}
						// System.out.println(builder);
						builder.append("\n");// append new line at the end of the row
					}

					BufferedWriter writer;
					try {
						writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile() + ".txt"));
						writer.write(builder.toString());// save the string representation of the board
						writer.close();
					} catch (IOException e1) {

						e1.printStackTrace();
					}

				}

			}
		});

		BGuitar.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						BGuitar.setForeground(Color.red);
						BDrum.setForeground(new Color(0, 255, 247));
						BBass.setForeground(new Color(0, 255, 247));
						BPiano.setForeground(new Color(0, 255, 247));
		
						guitartable.refreshTable(maintable);
					}
				});
		BPiano.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				BPiano.setForeground(Color.red);
				BDrum.setForeground(new Color(0, 255, 247));
				BBass.setForeground(new Color(0, 255, 247));
				BGuitar.setForeground(new Color(0, 255, 247));
				pianotable.refreshTable(maintable);
			}
		});
		BBass.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				BBass.setForeground(Color.red);
				BDrum.setForeground(new Color(0, 255, 247));
				BGuitar.setForeground(new Color(0, 255, 247));
				BPiano.setForeground(new Color(0, 255, 247));
				basstable.refreshTable(maintable);
			}
		});
		BDrum.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				BDrum.setForeground(Color.red);
				BGuitar.setForeground(new Color(0, 255, 247));
				BBass.setForeground(new Color(0, 255, 247));
				BPiano.setForeground(new Color(0, 255, 247));
				drumtable.refreshTable(maintable);
			}
		});
		Volumebut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				volume.show();
			}
		});
		BBack.addActionListener(handler);
		Play.addActionListener(handler);
		Pause.addActionListener(handler);
		Stop.addActionListener(handler);
		clear.addActionListener(handler);
		loop.addActionListener(handler);
		
		playPanel.setBounds(2,600,1198,74);
		playPanel.setBackground(new Color(214,220,231));
		
		Play.setBackground(new Color(2, 40, 77));
		Play.setForeground(new Color(0, 255, 247));
		Play.setFont(new Font("", 1, 30));
		Play.setCursor(cursor2);
		
		Pause.setBackground(new Color(2, 40, 77));
		Pause.setForeground(new Color(0, 255, 247));
		Pause.setFont(new Font("微軟正黑體", 1, 30));
		Pause.setCursor(cursor2);
		
		Stop.setBackground(new Color(2, 40, 77));
		Stop.setForeground(new Color(0, 255, 247));
		Stop.setFont(new Font("", 1, 30));
		Stop.setCursor(cursor2);
		
		tempo.setBackground(new Color(2, 40, 77));
		tempo.setForeground(new Color(0, 255, 247));
		tempo.setFont(new Font("微軟正黑體", 1, 30));
		tempo.setCursor(cursor2);
		
		loop.setBackground(new Color(2, 40, 77));
		loop.setForeground(new Color(0, 255, 247));
		loop.setFont(new Font("", 1, 30));
		loop.setCursor(cursor2);
		
		Volumebut.setBackground(new Color(2, 40, 77));
		Volumebut.setForeground(new Color(0, 255, 247));
		Volumebut.setFont(new Font("", 1, 30));
		Volumebut.setCursor(cursor2);
		
		playPanel.add(Play);
		playPanel.add(Pause);
		playPanel.add(Stop);
		playPanel.add(tempo);
		playPanel.add(Volumebut);
		playPanel.add(loop);
		
		ListPanel.setCursor(cursor);
		instruPanel.setCursor(cursor);
		playPanel.setCursor(cursor);
		frame.add(ListPanel);
		frame.add(instruPanel);
		frame.add(maintableBGtop);
		frame.add(maintableBGdown);
		frame.add(maintable);
		frame.add(playPanel);
		frame.setVisible(true);
		
	}
	
	
	private class ButtonHandler implements ActionListener 
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent E) 
		{
			if (E.getSource() == BBack) 
				{
					frame.dispose();
					new Menu();
				}
			if(E.getSource()== Play)
				{
					if(controlpause)
					{
					th1.resume();
					Play.setEnabled(false);
					}
					else
					{
					th1 = new MyThread();
					Play.setEnabled(false);
					controlstop = false;
					th1.start();
					}
					
				}
			if(E.getSource() == Pause)
			{
				th1.suspend();
				controlpause = true;
				Play.setEnabled(true);
			}
			if(E.getSource() == Stop)
			{
				if(controlpause)
				{
					th1.stop();
					controlpause = false;
				}
				else 
				controlstop=true;	
				if(controlloop)
				{
					controlloop = false;
					loop.setBackground(new Color(2, 40, 77));
				}
				Play.setEnabled(true);
			}
			if(E.getSource() == clear)
			{
				guitartable.clear();
				pianotable .clear();
				drumtable.clear();
				basstable.clear();
				maintable.removeAll();
				maintable.repaint();
			}
			if(E.getSource() == loop)
			{
				if(controlloop)
				{
					loop.setBackground(new Color(2, 40, 77));
					controlloop = false;
				}
				else
				{
				loop.setBackground(new Color(255, 40, 77));
				controlloop = true;
				}
			}
			
		}
	}
	

	synchronized public static void play() 
	{

		String text1 = "./guitar/Acoustic Guitar";
		String text2 = "./Piano/piano";
		String text3 = "./Bass/bass";
		String text4 = "./drum/";
		String path;
		Object[][] title1 = guitartable.getTitle();
		Object[][] title2 = pianotable.getTitle();
		Object[][] title3 = basstable.getTitle();
		Object[][] title4 = drumtable.getTitle();
		
		for(int i=1;i<17;i++)
		{
			
			if(tempo.isSelected())
			try {
			MyTable.play("Audio 1.wav",volume.getMetronomeVolume());    
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int j=0;j<15;j++)
			{
				if(title1[j][i] != "")
				{
					path = text1 + title1[j][0] +".wav";
					try {
						MyTable.play(path,volume.getGuitarVolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(title2[j][i] != "")
				{
					path = text2 + title2[j][0] +".wav";
					try {
						MyTable.play(path,volume.getPianoVolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(title3[j][i] != "")
				{
					path = text3+ title1[j][0] +".wav";
					try {
						MyTable.play(path,volume.getBassVolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(title4[j][i] != "")
				{
					path = text4 + title1[j][0] +".wav";
					try {
						MyTable.play(path,volume.getDrumVolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(volume.getSpeed());			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(controlstop==true)
				break;
		}
	}
}
