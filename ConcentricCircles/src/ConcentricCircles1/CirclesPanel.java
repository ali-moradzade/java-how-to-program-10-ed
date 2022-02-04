package ConcentricCircles1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class CirclesPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		int radius = 20;
		
		// chained circles
//		for (int i = 0; i < 10; i++)
//		{
//			g.drawArc(centerX - i * radius, centerY - i * radius, 
//				2 * radius, 2 * radius, 0, 360);
//		}
	
		for (int i = 0; i < 10; i++)
		{
			g.drawArc(centerX - i * radius, centerY - i * radius, 
				2 * i * radius, 2 * i * radius, 0, 360);
		}
	}
}
