package DrawingSpiralsPanel.square;

import java.awt.Graphics;
import javax.swing.JPanel;

public class SquareSpiral extends JPanel
{
	private enum Direction {UP, DOWN, LEF, RIGHT};
	private Direction direction;
	private int length;
	private int firstX;
	private int firstY;
		
	public SquareSpiral()
	{
		firstX = 200;
		firstY = 200;
		direction = Direction.DOWN;
		length = 10;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		draw(g);
	}
	
	public void changeDirection()
	{
		switch (direction)
		{
			case UP:
				direction = Direction.RIGHT;
				break;
			case RIGHT:
				direction = Direction.DOWN;
				break;
			case DOWN:
				direction = Direction.LEF;
				break;
			case LEF:
				direction = Direction.UP;
				break;
		}
	}
	
	public void incerease()
	{
		length += 20;
	}
	
	public void draw(Graphics g)
	{
		for (int counter = 1; counter <= 10; counter++)
		{
			switch (direction)
			{
				case UP:
					g.drawLine(firstX, firstY, firstX, firstY - length);
					firstY = firstY - length;
					break;
				case RIGHT:
					g.drawLine(firstX, firstY, firstX + length, firstY);
					firstX = firstX + length;
					break;
				case DOWN:
					g.drawLine(firstX, firstY, firstX, firstY + length);
					firstY = firstY + length;
					break;
				case LEF:
					g.drawLine(firstX, firstY, firstX - length, firstY);
					firstX = firstX - length;
					break;
			}
			
			changeDirection();
			
			if (counter % 2 == 0)
				incerease();
		}
	}
}
