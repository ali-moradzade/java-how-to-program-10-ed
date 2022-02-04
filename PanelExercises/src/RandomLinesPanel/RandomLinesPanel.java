package RandomLinesPanel;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import java.util.Random;

public class RandomLinesPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Random randomNumbers = new Random();
		
		for (int i = 0; i < 15; i++)
		{
			int x1 = randomNumbers.nextInt(getWidth());
			int y1 = randomNumbers.nextInt(getHeight());
			int x2 = randomNumbers.nextInt(getWidth());
			int y2 = randomNumbers.nextInt(getHeight());
			BasicStroke basicStroke =
				new BasicStroke((10 + randomNumbers.nextInt(100)) / 10.0f);
				
			g2d.setStroke(basicStroke);
			g2d.setColor(new Color(randomNumbers.nextInt(256),
				randomNumbers.nextInt(256), randomNumbers.nextInt(256)));
			g2d.draw(new Line2D.Double(x1, y1, x2, y2));
		}
	}
}