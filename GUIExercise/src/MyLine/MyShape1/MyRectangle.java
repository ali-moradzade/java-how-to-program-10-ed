package MyLine.MyShape1;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;

public class MyRectangle extends MyShape
{
	private boolean filled;

	public MyRectangle()
	{
		this(0, 0, 0, 0, Color.black, false);
	}
	
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled)
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
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
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
