package ConcentricCircles2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class CirclesPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		int radius = 10;
		
		for (int i = 0; i < 10; i++)
		{
			g2d.draw(new Ellipse2D.Double(centerX - i * radius, centerY - i * radius, 
				2 * i * radius, 2 * i * radius));
		}
	}
}
