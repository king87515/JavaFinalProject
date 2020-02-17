package javafinal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;


public class MyPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int FRAMEWIDTH;
    public final int FRAMEHEIGHT;

    private Ball[] ballArr;

    private Random random =new Random ();
    private Color[] colors={Color.RED,Color.blue,Color.yellow,Color.green}; 
    private int ballCnt;

    public MyPanel(int ballCnt,int FRAMEWIDTH,int FRAMEHEIGHT){
    	super();
    	this.FRAMEWIDTH=FRAMEWIDTH;
    	this.FRAMEHEIGHT=FRAMEHEIGHT;
        setSize(FRAMEWIDTH, FRAMEHEIGHT);

        ballArr = new Ball[ballCnt];
        this.ballCnt = ballCnt;
        @SuppressWarnings("unused")
		int c;

        for (int i=0; i < ballCnt; i++){
            int bcn =random.nextInt(colors.length);
            Color ballcolor=colors[bcn];
            ballArr[i] = new Ball(new Point(50,50),c=(int) (Math.random()*30+10)%8,ballcolor);


            int ddx = (int) (Math.random()*10+2)%8;
            int ddy = (int) (Math.random()*10+2)%8;         
            ballArr[i].setMotion(ddx, ddy); 
            //c++;
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        for (int i=0; i < ballCnt; i++){
            ballArr[i].paint(g);    
        }
    }

    public void stepTheBall(){
        for (int i=0; i < ballCnt; i++){        
            ballArr[i].move();

            Point loc = ballArr[i].getLocation();

            if (loc.x < ballArr[i].getRadius() ||
                loc.x > FRAMEWIDTH-ballArr[i].getRadius()){
                ballArr[i].reclectVert();
            }

            if (loc.y < ballArr[i].getRadius() ||
                    loc.y > FRAMEHEIGHT-ballArr[i].getRadius()){
                ballArr[i].reclectHoriz();
            }
        }   
        repaint();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  
}