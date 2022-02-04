package MyLine.DrawPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import MyLine.Oval.MyOval;
import MyLine.Rectangle.MyRectangle;
import MyLine.MyLine.MyLine;

public class DrawPanel extends JPanel
{
	private final Random randomNumbers = new Random();
	private final MyLine[] lines;
	private final MyOval[] ovals;
	private final MyRectangle[] rectangles;
	
	public DrawPanel()
	{
		setBackground(Color.white);
		int randomSize = 5 + randomNumbers.nextInt(5);
		
		lines = new MyLine[randomSize];
		ovals = new MyOval[randomSize];
		rectangles = new MyRectangle[randomSize];
		
		for (int count = 0; count < randomSize; count++)
		{
			int lineX1 = randomNumbers.nextInt(300);
			int lineY1 = randomNumbers.nextInt(300);
			int lineX2 = randomNumbers.nextInt(300);
			int lineY2 = randomNumbers.nextInt(300);
			
			Color lineColor = new Color(randomNumbers.nextInt(256), 
				randomNumbers.nextInt(256), randomNumbers.nextInt(256));
			
			lines[count] = new MyLine(lineX1, lineY1, lineX2, lineY2, lineColor);
			
			int ovalX1 = randomNumbers.nextInt(300);
			int ovalY1 = randomNumbers.nextInt(300);
			int ovalX2 = randomNumbers.nextInt(300);
			int ovalY2 = randomNumbers.nextInt(300);
			
			Color ovalColor = new Color(randomNumbers.nextInt(256), 
				randomNumbers.nextInt(256), randomNumbers.nextInt(256));
			boolean ovalFilled = randomNumbers.nextBoolean();
			
			ovals[count] = new MyOval(ovalX1, ovalY1, ovalX2, ovalY2, ovalColor, ovalFilled);
			
			int rectangleX1 = randomNumbers.nextInt(300);
			int rectangleY1 = randomNumbers.nextInt(300);
			int rectangleX2 = randomNumbers.nextInt(300);
			int rectangleY2 = randomNumbers.nextInt(300);
			
			Color rectangleColor = new Color(randomNumbers.nextInt(256), 
				randomNumbers.nextInt(256), randomNumbers.nextInt(256));
			boolean rectangleFilled = randomNumbers.nextBoolean();
			
			rectangles[count] = new MyRectangle(rectangleX1, rectangleY1,
				rectangleX2, rectangleY2, rectangleColor, rectangleFilled);
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (MyLine line : lines)
		{
			line.draw(g);
		}
		
		for (MyOval oval : ovals)
		{
			oval.draw(g);
		}
		
		for (MyRectangle rectangle : rectangles)
		{
			rectangle.draw(g);
		}
	}
}

