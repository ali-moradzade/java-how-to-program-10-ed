package MyLine.Rectangle;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPenl extends JPanel
{
	private final Random randomNumbers = new Random();
	private final MyRectangle[] rectangles;
	
	public DrawPenl()
	{
		setBackground(Color.white);
		
		rectangles = new MyRectangle[1 + randomNumbers.nextInt(5)];
		
		for (int count = 0; count < rectangles.length; count++)
		{
			int x1 = randomNumbers.nextInt(300);
			int y1 = randomNumbers.nextInt(300);
			int x2 = randomNumbers.nextInt(300);
			int y2 = randomNumbers.nextInt(300);
			
			Color color = new Color(randomNumbers.nextInt(256), 
				randomNumbers.nextInt(256), randomNumbers.nextInt(256));
			boolean filled = randomNumbers.nextBoolean();
			
			rectangles[count] = new MyRectangle(x1, y1, x2, y2, color, filled);
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (MyRectangle rectangle : rectangles)
		{
			rectangle.draw(g);
		}
	}
}
