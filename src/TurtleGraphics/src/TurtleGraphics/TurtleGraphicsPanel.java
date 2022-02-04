package TurtleGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TurtleGraphicsPanel extends JPanel
{
	public enum Pen {UP, DOWN};
	public enum Direction {UP, DOWN, RIGHT, LEFT};

	private static final int PEN_UP = 1;
	private static final int PEN_DOWN = 2;
	
	public static final int TURN_RIGHT = 3;
	public static final int TURN_LEFT = 4;
	
	private static final int MOVE = 5;
	private static final int DISPLAY = 6;
	private static final int END_OF_DATA = 9;
	
	private final JTextArea textArea;
	private static Scanner input;
	private final int[][] floor;
	private Direction direction;
	private Pen pen;
	private int xPosition;
	private int yPosition;
	
	private static final int FLOOR_LENGTH = 25;
	private static final int RADIUS = 5;
	private static final int TRANSFORMER = 20;
	private static final int SCALE_TRANSLATOR = 20;
	private static final int TRANSITION_TRANSLATOR = 16;
	
	public TurtleGraphicsPanel(JTextArea textArea)
	{
		this.textArea = textArea;
		
		input = new Scanner(System.in);
		floor = new int[FLOOR_LENGTH][FLOOR_LENGTH];
		direction = Direction.DOWN;
		pen = Pen.DOWN;
		xPosition = 0;
		yPosition = 0;
		
		setBackground(Color.white);
	}
	
	public void changePen()
	{
		if (pen == Pen.UP)
			pen = Pen.DOWN;
		else
			pen = Pen.UP;
	}
	
	public void changeDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public void move()
	{
		switch (direction)
		{
			case UP:
				
				if (yPosition >= 0)
				{
					if (pen == Pen.DOWN)
						floor[xPosition][yPosition] = 1;
					
					yPosition--;
				}
				
				break;
			case DOWN:
				
				if (yPosition < floor.length)
				{
					if (pen == Pen.DOWN)
						floor[xPosition][yPosition] = 1;
					
					yPosition++;
				}

				break;
			case RIGHT:
				
				if (xPosition < floor.length)
				{
					if (pen == Pen.DOWN)
						floor[xPosition][yPosition] = 1;
					
					xPosition++;
				}
				
				break;
			case LEFT:
				
				if (xPosition >= 0)
				{
					if (pen == Pen.DOWN)
						floor[xPosition][yPosition] = 1;
					
					xPosition--;
				}
				
				break;
		}
		
		xPosition = (xPosition < 0) ? 0 : xPosition;
		xPosition = (xPosition >= FLOOR_LENGTH) ? FLOOR_LENGTH - 1 : xPosition;
		
		yPosition = (yPosition < 0) ? 0 : yPosition;
		yPosition = (yPosition >= FLOOR_LENGTH) ? FLOOR_LENGTH - 1 : yPosition;
		
		setStatus();
		repaint();
	}
	
	public void setStatus()
	{
		String result = "";
		
		result = String.format("pen is %s%n", 
			(pen == Pen.UP) ? "up" : "down");
		
		result += String.format("your turn is on %s%n", 
			direction.toString().toLowerCase());
		result += String.format("your position is on (%d, %d)", 
			xPosition, yPosition);
		
		textArea.setText(result);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		TurtleShape turtleShape = new TurtleShape(g2d);
		
		g2d.draw(new Rectangle2D.Double(2, 6, 
			FLOOR_LENGTH * TRANSFORMER  + TRANSITION_TRANSLATOR,
			FLOOR_LENGTH * TRANSFORMER + TRANSITION_TRANSLATOR));
		
		for (int i = 0; i < FLOOR_LENGTH; i++)
		{
			for (int j = 0; j < FLOOR_LENGTH; j++)
			{
				if (floor[i][j] == 1)
				{
					g2d.fill(new Ellipse2D.Double(
						i * TRANSFORMER + TRANSITION_TRANSLATOR,
						j * TRANSFORMER + TRANSITION_TRANSLATOR, 
						RADIUS, RADIUS));
				}
			}
		}
		
		switch (direction)
		{
			case UP:
				turtleShape.setX(xPosition * SCALE_TRANSLATOR);
				turtleShape.setY(yPosition * SCALE_TRANSLATOR);
				turtleShape.drawUpDirection();
				break;
			case RIGHT:
				turtleShape.setX(xPosition * SCALE_TRANSLATOR);
				turtleShape.setY(yPosition * SCALE_TRANSLATOR);
				turtleShape.drawRightDirection();
				break;
			case DOWN:
				turtleShape.setX(xPosition * SCALE_TRANSLATOR);
				turtleShape.setY(yPosition * SCALE_TRANSLATOR);
				turtleShape.drawDownDirection();
				break;
			case LEFT:
				turtleShape.setX(xPosition * SCALE_TRANSLATOR);
				turtleShape.setY(yPosition * SCALE_TRANSLATOR);
				turtleShape.drawLeftDirection();
				break;
		}
	}
}