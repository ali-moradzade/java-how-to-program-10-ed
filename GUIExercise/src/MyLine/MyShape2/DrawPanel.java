package MyLine.MyShape2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private final Random randomNumbers = new Random();
	private final MyShape[] shapes;
	
	private final int lineCount;
	private final int ovalCount;
	private final int rectangleCount;
	
	public DrawPanel()
	{
		setBackground(Color.white);
		
		lineCount = 5 + randomNumbers.nextInt(5);
		ovalCount = 5 + randomNumbers.nextInt(5);
		rectangleCount = 5 + randomNumbers.nextInt(5);
		
		shapes = new MyShape[lineCount + ovalCount + rectangleCount];
		
		for (int count = 0; count < shapes.length; count++)
		{
			if (count < lineCount)
			{
				int lineX1 = randomNumbers.nextInt(500);
				int lineY1 = randomNumbers.nextInt(500);
				int lineX2 = randomNumbers.nextInt(500);
				int lineY2 = randomNumbers.nextInt(500);

				Color lineColor = new Color(randomNumbers.nextInt(256), 
					randomNumbers.nextInt(256), randomNumbers.nextInt(256));

				shapes[count] = new MyLine(lineX1, lineY1, lineX2, lineY2, lineColor);
			}
			else if (count < lineCount + ovalCount)
			{
				int ovalX1 = randomNumbers.nextInt(500);
				int ovalY1 = randomNumbers.nextInt(500);
				int ovalX2 = randomNumbers.nextInt(500);
				int ovalY2 = randomNumbers.nextInt(500);

				Color ovalColor = new Color(randomNumbers.nextInt(256), 
					randomNumbers.nextInt(256), randomNumbers.nextInt(256));
				boolean ovalFilled = randomNumbers.nextBoolean();

				shapes[count] = new MyOval(ovalX1, ovalY1, ovalX2, ovalY2, 
					ovalColor, ovalFilled);
			}
			else
			{
				int rectangleX1 = randomNumbers.nextInt(500);
				int rectangleY1 = randomNumbers.nextInt(500);
				int rectangleX2 = randomNumbers.nextInt(500);
				int rectangleY2 = randomNumbers.nextInt(500);

				Color rectangleColor = new Color(randomNumbers.nextInt(256), 
					randomNumbers.nextInt(256), randomNumbers.nextInt(256));
				boolean rectangleFilled = randomNumbers.nextBoolean();

				shapes[count] = new MyRectangle(rectangleX1, rectangleY1,
					rectangleX2, rectangleY2, rectangleColor, rectangleFilled);
			}
		}
	}
	
	public String labelText()
	{
		return String.format("Lines: %d, Ovals: %d, Rectangles: %d",
			lineCount, ovalCount, rectangleCount);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (MyShape shape : shapes)
		{
			shape.draw(g);
		}
	}
}

