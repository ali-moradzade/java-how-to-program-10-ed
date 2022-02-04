package MyLine.Oval;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;

public class MyOval
{
	private int x1; 
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	private boolean filled;

	public MyOval()
	{
		this(0, 0, 0, 0, Color.black, false);
	}
	
	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.filled = filled;
	}

	public void setX1(int x1)
	{
		if (x1 > 0)
			this.x1 = x1;
	}
	
	public int getX1()
	{
		return x1;
	}

	public void setY1(int y1)
	{
		if (y1 > 0)
			this.y1 = y1;
	}
	
	public int getY1()
	{
		return y1;
	}

	public void setX2(int x2)
	{
		if (x2 > 0)
			this.x2 = x2;
	}
	
	public int getX2()
	{
		return x2;
	}
	
	public void setY2(int y2)
	{
		if (y2 > 0)
			this.y2 = y2;
	}
	
	public int getY2()
	{
		return y2;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}

	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color);
		
		if (filled)
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
	
	private int getUpperLeftX()
	{
		return (getX1() < getX2()) ? getX1() : getX2();
	}
	
	private int getUpperLeftY()
	{
		return (getY1() < getY2()) ? getY1() : getY2();
	}
	
	private int getWidth()
	{
		return abs(getX2() - getX1());
	}
	
	private int getHeight()
	{
		return abs(getY2() - getY1());
	}
}
