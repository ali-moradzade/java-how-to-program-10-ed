package DrawRainBowPanel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawRainbowPanel extends JPanel
{
	private static final Color VIOLET = new Color(128, 0, 128);
	private static final Color INDIGO = new Color(75, 0, 130);
	
	private Color[] colors = {Color.white, Color.white, VIOLET, INDIGO, Color.blue,
		Color.green, Color.yellow, Color.orange, Color.red};
		
	public DrawRainbowPanel()
	{
		setBackground(Color.white);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int radius = getWidth() / 20;
		
		int centerX = getWidth() / 2;
		int centerY = getHeight() - 10;
		
		for (int counter = colors.length; counter > 0; counter--)
		{
			g.setColor(colors[counter - 1]);
			g.fillArc(centerX - counter * radius, centerY - counter * radius,
				2 * counter * radius, 2 * counter * radius, 0, 180);
		}
	}
}
