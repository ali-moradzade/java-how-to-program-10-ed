package TurtleGraphics;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class TurtleShape
{
	private int radius;
	private final BasicStroke basicStroke;
	private int x;
	private int y;
	private final Graphics2D g2d;
	
	public TurtleShape(Graphics2D g2d)
	{
		this.g2d = g2d;
		
		radius = 10;
		basicStroke = new BasicStroke(6.0f);
		x = 0;
		y = 0;
		
		g2d.setStroke(basicStroke);
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	public int getRadius()
	{
		return radius;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}
	
	public void drawRightDirection()
	{
		g2d.translate(x, y);
		
		g2d.fill(new Rectangle2D.Double(0, 0, 3 * radius, radius));
		g2d.draw(new Ellipse2D.Double(0, radius, 3 * radius, 2 * radius));
		g2d.fill(new Rectangle2D.Double(0, 3 * radius, 3 * radius, radius));
		g2d.fill(new Rectangle2D.Double(1.5 * radius, 1.5 * radius, 3 * radius, radius));
		
		g2d.translate(-x, -y);
	}
	
	public void drawDownDirection()
	{
		g2d.translate(x, y);
		
		g2d.fill(new Rectangle2D.Double(0, 0, radius, 3 * radius));
		g2d.draw(new Ellipse2D.Double(radius, 0, 2 * radius, 3 * radius));
		g2d.fill(new Rectangle2D.Double(3 * radius, 0, radius, 3 * radius));
		g2d.fill(new Rectangle2D.Double(1.5 * radius, 1.5 * radius, radius, 3 * radius));
		
		g2d.translate(-x, -y);
	}
	
	public void drawUpDirection()
	{
		g2d.translate(x, y);
		
		g2d.fill(new Rectangle2D.Double(0, 1.5 * radius, radius, 3 * radius));
		g2d.draw(new Ellipse2D.Double(radius, 1.5 * radius, 2 * radius, 3 * radius));
		g2d.fill(new Rectangle2D.Double(3 * radius, 1.5 * radius, radius, 3 * radius));
		g2d.fill(new Rectangle2D.Double(1.5 * radius, 0, radius, 3 * radius));
		
		g2d.translate(-x, -y);
	}
	
	public void drawLeftDirection()
	{
		g2d.translate(x, y);
		
		g2d.fill(new Rectangle2D.Double(1.5 * radius, 0, 3 * radius, radius));
		g2d.draw(new Ellipse2D.Double(1.5 * radius, radius, 3 * radius, 2 * radius));
		g2d.fill(new Rectangle2D.Double(1.5 * radius, 3 * radius, 3 * radius, radius));
		g2d.fill(new Rectangle2D.Double(0, 1.5 * radius, 3 * radius, radius));
		
		g2d.translate(-x, -y);
	}
	
//	@Override
//	public void paintComponent(Graphics g)
//	{
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		
//		int radius = 10;
//		BasicStroke basicStroke = new BasicStroke(6.0f);
//
//		g2d.setStroke(basicStroke);
//		
//		drawDownDirection(g2d, radius);
//		g2d.translate(5 * radius, 0);
//		
//		drawUpDirection(g2d, radius);
//		g2d.translate(0, 5 * radius);
//		
//		drawRightDirection(g2d, radius);
//		g2d.translate(-5 * radius, 0);
//		
//		drawLeftDirection(g2d, radius);
//	}
}