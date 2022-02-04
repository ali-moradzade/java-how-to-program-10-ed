package MyLine.MyShape2;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;

public class MyBoundedShape extends MyShape
{
	private boolean filled;

	public MyBoundedShape()
	{
		this(0, 0, 0, 0, Color.black, false);
	}
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled)
	{
		super(x1, y1, x2, y2, color);
		
		this.filled = filled;
	}

	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.setColor(getColor());
		
		if (filled)
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
	
	public int getUpperLeftX()
	{
		return (getX1() < getX2()) ? getX1() : getX2();
	}
	
	public int getUpperLeftY()
	{
		return (getY1() < getY2()) ? getY1() : getY2();
	}
	
	public int getWidth()
	{
		return abs(getX2() - getX1());
	}
	
	public int getHeight()
	{
		return abs(getY2() - getY1());
	}
}
