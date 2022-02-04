package InteractiveDrawingApplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyRectangle extends MyBoundedShape
{
	public MyRectangle()
	{
		this(0, 0, 0, 0, Color.black, new BasicStroke(), false);
	}
	
	public MyRectangle(int x1, int y1, int x2, int y2, Paint color, 
		Stroke stroke, boolean filled)
	{
		super(x1, y1, x2, y2, color, stroke, filled);
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		g.setPaint(getPaint());
		g.setStroke(getStroke());
		
		if (isFilled())
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}
