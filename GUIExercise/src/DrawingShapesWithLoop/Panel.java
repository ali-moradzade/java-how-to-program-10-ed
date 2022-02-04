package DrawingShapesWithLoop;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel
{
	private static final int	LENGTH_OF_STEPS = 15;
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		int horizentalStep = width / LENGTH_OF_STEPS;
		int verticalStep = height / LENGTH_OF_STEPS;
		
		for (int i = 0; i < LENGTH_OF_STEPS; i++)
		{
			g.drawLine(0, 0, height - i * verticalStep, i * horizentalStep);
			g.drawLine(0, height, width - i * horizentalStep, height - i * verticalStep);
			g.drawLine(width, 0, i * horizentalStep, i * verticalStep);
			g.drawLine(width, height, i * horizentalStep, height - i * verticalStep);
		}
	}
}
