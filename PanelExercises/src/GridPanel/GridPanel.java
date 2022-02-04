package GridPanel;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GridPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int xPace = getWidth() / 8;
		int yPace = getHeight() / 8;

		for (int i = 1; i <= 8; i++)
		{
			g.drawLine(0, i * yPace, getWidth(), i * yPace);
			g.drawLine(i * xPace, 0, i * xPace, getHeight());
		}
	}
}
