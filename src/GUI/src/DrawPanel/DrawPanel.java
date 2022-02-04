package DrawPanel;

import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.drawLine(0, 0, width, height);
		g.drawLine(0, height, width, 0);
	}
}
