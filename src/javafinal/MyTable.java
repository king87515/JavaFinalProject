package javafinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	static String[] columnNames = {"","","","","","","","","","","","","","","","",""};
	String text;


	Object[][] title = {
    		{"C5","","","","","","","","","","","","","","","",""},
    		{"B4","","","","","","","","","","","","","","","",""},
    		{"A4","","","","","","","","","","","","","","","",""},
    		{"G4","","","","","","","","","","","","","","","",""},
    		{"F4","","","","","","","","","","","","","","","",""},
    		{"E4","","","","","","","","","","","","","","","",""},
    		{"D4","","","","","","","","","","","","","","","",""},
    		{"C4","","","","","","","","","","","","","","","",""},
    		{"B3","","","","","","","","","","","","","","","",""},
    		{"A3","","","","","","","","","","","","","","","",""},
    		{"G3","","","","","","","","","","","","","","","",""},
    		{"F3","","","","","","","","","","","","","","","",""},
    		{"E3","","","","","","","","","","","","","","","",""},
    		{"D3","","","","","","","","","","","","","","","",""},
    		{"C3","","","","","","","","","","","","","","","",""}
    };
	DefaultTableModel tableModel = new DefaultTableModel(title,columnNames);
	
	public MyTable()
	{
		table  = new JTable(tableModel);
		
	}
	
	public JTable getTable()
	{
		return table;
	}
	
	
	
	public Object[][] getTitle()
	{
		return title;
	}
	
	public void settitle(String[][] src) {

		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 17; j++) {

				if (src[i][j].equals("T")) {
					title[i][j] = "    ♪";
					// System.out.printf("%s ",title[i][j]);
				} else if (src[i][j].equals("F")) {

					title[i][j] = "";
					// System.out.printf("%s ",title[i][j]);
				}
			}
			System.out.println("");
		}

	}

	public void setText(String text)
	{
		this.text = text;
	}
	public void setTable() 
	{
		table.setEnabled(false);
		table.setFont(new Font("", 1, 18));
		table.setColumnSelectionAllowed(true);
		table.setBackground(new Color(0,0,0));
		table.setForeground(Color.WHITE);
		table.setGridColor(Color.WHITE);
	}
			
	public void addListener(JPanel maintable)
	{
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
					
					System.out.println("row" + table.rowAtPoint(e.getPoint()) + " col" + table.columnAtPoint(e.getPoint())
							+ " has been clicked!");
					if (table.columnAtPoint(e.getPoint()) == 0) {
						String filePath = text+ title[table.rowAtPoint(e.getPoint())][table.columnAtPoint(e.getPoint())] + ".wav";
						
						try {
							play(filePath,0);
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
						
					}
					
					if(title[table.rowAtPoint(e.getPoint())][table.columnAtPoint(e.getPoint())] == "")
    	        		title[table.rowAtPoint(e.getPoint())][table.columnAtPoint(e.getPoint())] = "    ♪";
    	        	else if(title[table.rowAtPoint(e.getPoint())][table.columnAtPoint(e.getPoint())] == "    ♪")
    	        		title[table.rowAtPoint(e.getPoint())][table.columnAtPoint(e.getPoint())] = "";
					maintable.remove(table);
					
    	        	DefaultTableModel tableModel2 = new DefaultTableModel(title,columnNames);
    	        	table = new JTable(tableModel2);
					
    	        	setTable();
    	        	addListener(maintable);
    	        	refreshTable(maintable);
					
				
				}
			
				
			}
		});
	}
	
	 public static void play(String filename,float volume) throws Exception 
	 {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.setFramePosition(0);

	        FloatControl gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(volume);
	        clip.start();
	       
	     
	 }
	

	 
	public void refreshTable(JPanel maintable)
	{
		maintable.remove(table);

		DefaultTableModel tableModel2 = new DefaultTableModel(title, columnNames);
		table = new JTable(tableModel2);
		setTable();
		addListener(maintable);
		maintable.removeAll();
		table.setBounds(0, 0, 900, 240);
		maintable.add(table);
		maintable.revalidate();
		maintable.repaint();
	}
	
	public void clear() {
		for (int i = 0; i < 15; i++) {
			for (int j = 1; j < 17; j++) {
				title[i][j] = "";
			}
		}
	}
	
}
	


