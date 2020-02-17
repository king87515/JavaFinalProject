package javafinal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DontTouchTheWhiteTile implements ActionListener, MouseListener {
	public final static int COLUMNS = 3, ROWS = 4, TILE_WIDTH = 175, TILE_HEIGHT = 200;
	//public static DontTouchTheWhiteTile dttwt;
	public ArrayList<Tile> tiles;
	public Renderer renderer;
	public Random random;
	JFrame originframe;
	JFrame frame;
	public int score, milSecDelay;
	public boolean gameOver;
	String [] path = {"./guitar/Acoustic Guitar",
				      "./piano/Piano",
				      "./bass/Bass",
					  "./drum/"};
	String [] melody = {"C5","B4","A4","G4","F4","E4","D4","C4","B3","A3","G3","F3","E3","D3","C3"};
	

	public DontTouchTheWhiteTile(JFrame myframe) {
		frame = new JFrame("Don't Touch The White Tile!");
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		random = new Random();
		originframe = myframe;
		
		frame.setLocation(620,30);
		frame.setBackground(new Color(214,220,231));
		frame.setSize(TILE_WIDTH * COLUMNS, TILE_HEIGHT * ROWS);
		frame.add(renderer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
		frame.setResizable(false);

		start();

		timer.start();
	}

	public void start() {
		score = 0;
		gameOver = false;
		tiles = new ArrayList<Tile>();

		for (int x = 0; x < COLUMNS; x++) {
			for (int y = 0; y < ROWS; y++) {
				boolean canBeBlack = true;

				for (Tile tile : tiles) {
					if (tile.y == y && tile.black) {
						canBeBlack = false;
					}
				}

				if (!canBeBlack) {
					tiles.add(new Tile(x, y, false));
				} else {
					tiles.add(new Tile(x, y, random.nextInt(2) == 0 || x == 2));
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();

		for (int i = 0; i < tiles.size(); i++) {
			Tile tile = tiles.get(i);

			if (tile.animateY < 0) {
				tile.animateY += TILE_HEIGHT / 5;
			}
		}

		milSecDelay++;
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, TILE_WIDTH * COLUMNS, TILE_HEIGHT * ROWS);

		g.setFont(new Font("Arial", 1, 100));

		if (!gameOver) {
			for (Tile tile : tiles) {
				g.setColor(tile.black ? Color.BLACK : Color.WHITE);
				g.fillRect(tile.x * TILE_WIDTH, tile.y * TILE_HEIGHT + tile.animateY, TILE_WIDTH, TILE_HEIGHT);
				g.setColor(tile.black ? Color.WHITE : Color.BLACK);
				g.drawRect(tile.x * TILE_WIDTH, tile.y * TILE_HEIGHT + tile.animateY, TILE_WIDTH, TILE_HEIGHT);
			}

			g.setColor(Color.RED);
			g.drawString(String.valueOf(score), TILE_WIDTH, 100);
		} else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", 1, 70));
			g.drawString("Game Over!", 70, TILE_HEIGHT);
			g.setFont(new Font("Microsoft JhengHei", 1, 70));
			g.drawString("返回",180, 570);
			g.drawRect(160, 500, 180, 80);
		}
	}
/*
	public static void main(String[] args) {
		dttwt = new DontTouchTheWhiteTile();
	}*/

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean clicked = false;
		int rPath = (int) (Math.random()*4);
		int rMelody = (int) (Math.random()*15);
		String filename = path[rPath]+melody[rMelody]+".wav";
		String har = "./drum/G4.wav";
		if (!gameOver) {
			while(filename.equals(har)) {
				System.out.println("same");
				rPath = (int) (Math.random()*4);
				rMelody = (int) (Math.random()*15);
				filename = path[rPath]+melody[rMelody]+".wav";
			}
			try {
				MyTable.play(filename, 6);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < tiles.size(); i++) {
				Tile tile = tiles.get(i);

				if (tile.pointInTile(e.getX(), e.getY()) && !clicked) {
					if (e.getY() > TILE_HEIGHT * (ROWS - 1)) {
						if (tile.black) {
							for (int j = 0; j < tiles.size(); j++) {
								if (tiles.get(j).y == ROWS) {
									tiles.remove(j);
								}

								tiles.get(j).y++;
								tiles.get(j).animateY -= TILE_HEIGHT;
							}

							score += Math.max(100 - milSecDelay, 10);

							System.out.println("You've scored " + Math.max(100 - milSecDelay, 10) + " points!");

							milSecDelay = 0;

							boolean canBeBlack = true;

							for (int x = 0; x < COLUMNS; x++) {
								boolean black = random.nextInt(2) == 0 || x == COLUMNS - 1;

								Tile newTile = null;

								if (canBeBlack && black) {
									newTile = new Tile(x, 0, true);
									canBeBlack = false;
								} else {
									newTile = new Tile(x, 0, false);
								}

								newTile.animateY -= TILE_HEIGHT;

								tiles.add(newTile);
							}
						} else {
							try {
								MyTable.play("./drum/G4.wav", 6);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							gameOver = true;
						}

						clicked = true;
					} else {
						try {
							MyTable.play("./drum/G4.wav", 6);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						gameOver = true;
					}
				}
			}
		} else {
			start();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(!gameOver && e.getX()>160 && e.getX()<340 && e.getY()>530 && e.getY()<610)
		{
			originframe.setVisible(true);
			frame.dispose();
		}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{


	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
