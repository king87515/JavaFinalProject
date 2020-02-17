package javafinal;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (Music.dttwt != null)
		{
			Music.dttwt.render(g);
		}
	}
	
}
