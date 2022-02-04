package GridPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Grid2JPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int xPace = getWidth() / 8;
		int yPace = getHeight() / 8;

		for (int i = 1; i <= 8; i++)
		{
			g2d.draw(new Line2D.Double(0, i * yPace, getWidth(), i * yPace));
			g2d.draw(new Line2D.Double(i * xPace, 0, i * xPace, getHeight()));
		}
	}
}
