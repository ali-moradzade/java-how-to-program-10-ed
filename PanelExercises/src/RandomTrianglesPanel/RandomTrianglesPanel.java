package RandomTrianglesPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel;

public class RandomTrianglesPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random random = new Random();
		
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 1; i <= 20; i++)
		{
			int x = random.nextInt(getWidth());
			int y = random.nextInt(getHeight());
			int width = random.nextInt(getWidth());
			int height = random.nextInt(getHeight());

			width = (width + x > getWidth()) ? getWidth() - x : width;
			height = (height + y > getHeight()) ? getHeight() - y : height;

			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256),
				random.nextInt(256)));
			g2d.setStroke(new BasicStroke(random.nextFloat() * 50));
			g2d.draw(new Rectangle2D.Double(x, y, width, height));
		}
	}
}
