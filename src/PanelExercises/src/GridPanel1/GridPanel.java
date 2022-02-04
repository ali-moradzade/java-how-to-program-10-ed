package GridPanel1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class GridPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();
		
		int xPace = width / 5;
		int yPace = height / 5;
		
		for (int count = 1; count <= 5; count++)
		{
			g2d.draw(new Rectangle2D.Double(0, 0, count * xPace, count * yPace));
			g2d.draw(new Rectangle2D.Double(count * xPace, count * yPace,
				(5 - count) * xPace, (5 - count) * yPace));
		}
	}
}
