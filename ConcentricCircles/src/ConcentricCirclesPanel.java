import java.awt.Graphics;
import javax.swing.JPanel;

public class ConcentricCirclesPanel extends JPanel
{
	private static final int RADIUS = 15;
	private static final int LENGTH_OF_CIRCLES = 10;
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		for (int i = 1; i <= LENGTH_OF_CIRCLES; i++)
		{
			g.drawOval(width / 2 - i * RADIUS, height / 2 - i * RADIUS, 
				i * 2 * RADIUS, i * 2 * RADIUS);
		}
	}
}
