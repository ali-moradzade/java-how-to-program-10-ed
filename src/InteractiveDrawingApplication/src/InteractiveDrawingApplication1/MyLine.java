package InteractiveDrawingApplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyLine extends MyShape
{
	public MyLine()
	{
		this(0, 0, 0, 0, Color.black, new BasicStroke());
	}

	public MyLine(int x1, int y1, int x2, int y2, Paint color, Stroke stroke)
	{
		super(x1, y1, x2, y2, color, stroke);
	}
		
	@Override
	public void draw(Graphics2D g)
	{
		g.setPaint(getPaint());
		g.setStroke(getStroke());
		
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
