package DrawingSpiralsPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.JPanel;

public class DrawingSpiralsPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int radius = 20;
		
		int[] xPoints = {getWidth() / 2 + radius, getWidth() / 2 + radius};
		int[] yPoints = {getHeight() / 2, getHeight() / 2 + radius};
		
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath star = new GeneralPath();
		
		star.moveTo(xPoints[0], yPoints[0]);
		
		for (int count = 0; count < xPoints.length; count++)
		{
			star.lineTo(xPoints[count], yPoints[count]);
		}
		
		star.closePath();
		
//		g2d.translate(getWidth() / 2, getHeight() / 2);
		
		for (int count = 0; count < 5; count++)
		{
			g2d.rotate(Math.PI / 10.0);
			
			g2d.fill(star);
		}
	}
}
