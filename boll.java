import javax.swing.*;
import java.applet.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class boll extends Applet implements MouseMotionListener
{
	int x,y,bx,by=500,score=0,speed=100,miss=4;// bx,by are coordinates of buckets
	// x and y are the co ordinates of boll
	int a[]={0,28,144,172},b[]={500,580,580,500},c[]={0,0,0,0};
	public void init( )
	{
		y=0;
		addMouseMotionListener(this);
		fixx();
	//	g.drawString("start game ",800,880);
		try		{Thread.sleep(2000);}
		catch(Exception e)	    {	}
	}
	
	/////////////////////////////////////////////
	void rectangle(Graphics g)
	{
		c[0]=0;
		c[1]=0;
		c[2]=0;
		c[3]=0;
		for(int i=0;i<4;i++)
		{
			c[i]=bx+a[i];
			//System.out.print(c[i]+"\t");
		}
		g.setColor(Color.GREEN);
		g.fillPolygon(c,b,4);
		/*
		g.setColor(new Color(195,195,195));
		g.fillRect(bx,500,140,90);*/
	}
	void score()
	{
		if(score>0)
		{
			if(score%50==0)
			{
				speed--;
			}
		}
	}
	
	//////////////////////////////////////
    public void paint(Graphics g)
	{
		String s="score : ";
		s=s+(score);
		circlea(g);
		g.setColor(Color.BLUE);
		g.drawString(s,1000,50);
		
		circlea(g);
		
		score();
		
		rectangle(g);
		try		{Thread.sleep(speed);}
		catch(Exception e)	    {	}

		System.out.println(x+"   "+y+"\t"+bx+"   "+by);
		
		String m="misses : ";
		m=m+(miss);
		
		g.setColor(Color.BLUE);
		g.drawString(m,1090,50);
		
		if(miss>=0)
		{
			repaint();
		}
	}
	//////////////////////////////////////
	 void fixx()	{	   x=(int)(1200*Math.random());	}
	/////////////////////////////////////////
	void check(Graphics g)
	{
	   if(y==500)
	   {
			if(x>=c[0])
			{
				if(x+5<=c[3])
				{
					g.setColor(new Color(185,122,87));
					g.fillOval(x,y,80,80);
					System.out.println("true\t");
					y=900;
					score++;
				}
				else
				{
					miss--;
				}
			}
			else
			{
				miss--;
			}
	   }
	   
	}
	/////////////////////////////////////
	void circlea(Graphics g)
   {
	   y=y+10;
	   {
		g.setColor(Color.RED);
		g.fillOval(x,y,80,80);   
	   }
	   check(g);
		if(y>=900)
		{
			fixx();
			y=0;
		}
		
   }
	
	public void mouseDragged(MouseEvent me){}
	public void mouseMoved(MouseEvent me)	{		bx=me.getX();	}
}	
/*
public class boll extends Applet implements MouseMotionListener
{
	int x,y,bx,by=500,score=0 ;// bx,by are coordinates of buckets
	// x and y are the co ordinates of boll
	int a[]={0,28,144,172},b[]={500,580,580,500};
	public void init()
	{
		x=0;
		y=0;
		addMouseMotionListener(this);
	}
	/////////////////////////////////////////////
	void rectangle(Graphics g)
	{
		g.setColor(new Color(195,195,195));
		g.fillRect(bx,500,140,90);
	}
	//////////////////////////////////////
    public void paint(Graphics g)
	{
		String s=" ";
		s=s+(score);
		circlea(g);
		g.setColor(Color.BLUE);
		g.drawString(s,800,50);
		
		rectangle(g);
		try		{Thread.sleep(100);}
		catch(Exception e)	    {	}

		System.out.println(x+"   "+y+"\t"+bx+"   "+by);
		repaint();
	}
	//////////////////////////////////////
	 void fixx()	{	   x=(int)(1200*Math.random());	}
	/////////////////////////////////////////
	void check(Graphics g)
	{
	   if(y==500)
	   {
			if(x>=bx)
			{
				if(x<=bx+140)
				{
					g.setColor(new Color(128,0,255));
					g.fillOval(x,y,80,80);
					System.out.println("true\t");
					y=900;
					score++;
				}
			}
	   }
	   
	}
	/////////////////////////////////////
	void circlea(Graphics g)
   {
	   y=y+10;
	   
	   {
		g.setColor(Color.RED);
		g.fillOval(x,y,80,80);   
	   }
	   check(g);
		if(y>=900)
		{
			fixx();
			y=0;
		}
		
   }
	
	public void mouseDragged(MouseEvent me){}
	public void mouseMoved(MouseEvent me)	{		bx=me.getX();	}
}	
*/