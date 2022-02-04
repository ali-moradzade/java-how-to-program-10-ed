package ScreenSaverPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JPanel;

public class ScreenSaverPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		
		for (int i = 0; i < 100; i++)
		{
			Color color = new Color(random.nextInt(256), random.nextInt(256), 
				random.nextInt(256));
			g2d.setColor(color);
			
			BasicStroke basicStroke = new BasicStroke(5 + 20 * random.nextFloat());
			g2d.setStroke(basicStroke);
			
			g2d.draw(new Line2D.Double(random.nextInt(getWidth()), 
				random.nextInt(getHeight()), random.nextInt(getWidth()),
				random.nextInt(getHeight())));
			
			repaint();
		}
	}
}
