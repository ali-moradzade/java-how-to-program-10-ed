package CirclesPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import static java.lang.Math.PI;
import javax.swing.JPanel;

public class CirclesPanel extends JPanel
{
	private final int centerX;
	private final int centerY;
	private final int radius;

	public CirclesPanel(int centerX, int centerY, int radius)
	{
//		if (radius <= 0)
//			throw new IllegalArgumentException("radius must be > 0");
//		
//		if (centerX < 0 || centerY < 0)
//			throw new IllegalArgumentException(
//				"center x and/or center y must be >= 0");
//		
//		if (centerX + 2 * radius > getWidth() || centerY + 2 * radius > getHeight())
//			throw new IllegalArgumentException(
//				"centerX and/or centerY can not be displayed with specified radius");
//		
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.draw(new Ellipse2D.Double(centerX - radius, centerY - radius, 
			2 * radius, 2 * radius));
		
		String string = 
			" Radius: " + radius + "; Diameter: " + 2 * radius + "; Circumference: " + 
			2 * PI * radius + "; Area: " + 2 * PI * radius;
			
		g2d.drawString(string, 0, getHeight() - g2d.getFontMetrics().getDescent());
	}
}
