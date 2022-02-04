package RandomChractersPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;


public class RandomChractersPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random random = new Random();
		
		String[] fontNames = 
		{"Serif", "SansSerif", "Monospaced", "Dialog", "DialongInput"};
		
		for (int i = 0; i < 100; i++)
		{
			int style;
			
			switch (random.nextInt(4))
			{
				case 0:
					style = Font.PLAIN;
					break;
				case 1:
					style = Font.BOLD;
					break;
				case 2:
					style = Font.ITALIC;
					break;
				default:
					style = Font.BOLD + Font.ITALIC;
					break;
			}
			
			Font font = new Font(fontNames[random.nextInt(fontNames.length)], 
				style, 10 + random.nextInt(14));
			Color color = new Color(random.nextInt(256), random.nextInt(256), 
				random.nextInt(256));
			char chracter = (char)(random.nextInt(26) + 'a');
			
			int x = random.nextInt(getWidth());
			int y = random.nextInt(getHeight());
			
			x = (x - 10 < 0) ? 10 : x;
			y = (y - 10 < 0) ? 10 : y;
			
			g.setFont(font);
			g.setColor(color);
			g.drawString(Character.toString(chracter), x, y);
		}
	}
}