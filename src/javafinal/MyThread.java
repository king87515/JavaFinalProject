package javafinal;

public class MyThread extends Thread
{
	public void run()
	{
		int count=0;
		while(Music.controlloop || count==0)
		{
		Music.play();
		count=1;
		}
    }
}
