import java.util.Scanner;

public class TurtleGraphics
{
	private enum Pen {UP, DOWN};
	private enum Direction {UP, DOWN, RIGHT, LEFT};

	private static final int PEN_UP = 1;
	private static final int PEN_DOWN = 2;
	
	private static final int TURN_RIGHT = 3;
	private static final int TURN_LEFT = 4;
	
	private static final int MOVE = 5;
	private static final int DISPLAY = 6;
	private static final int END_OF_DATA = 9;
	
	private static Scanner input;
	private final int[][] floor;
	private Direction direction;
	private Pen pen;
	private int xPosition;
	private int yPosition;
	
	private static final int FLOOR_LENGTH = 20;
	
	public TurtleGraphics()
	{
		input = new Scanner(System.in);
		floor = new int[FLOOR_LENGTH][FLOOR_LENGTH];
		direction = Direction.DOWN;
		pen = Pen.DOWN;
		xPosition = 0;
		yPosition = 0;
	}
	
	public int showMenu()
	{
		showStatus();
		
		System.out.printf("%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n%d%s%n? ",
			"Enter your command:",
			PEN_UP, " -- Pen up",
			PEN_DOWN, " -- Pen down",
			TURN_RIGHT, " -- Turn right", 
			TURN_LEFT, " -- Turn left",
			MOVE, " -- Move",
			DISPLAY, " -- display",
			END_OF_DATA, " -- End of data");
		int order = input.nextInt();
		
		while (order != PEN_UP && order != PEN_DOWN && order != TURN_RIGHT &&
			order != TURN_LEFT && order != DISPLAY && order != MOVE && 
			order != END_OF_DATA)
		{
			System.out.printf("%s%n? ",
				"Invalid input. please reneter your order.");
			order = input.nextInt();
		}
		
		return order;
	}
	
	public void processOrder()
	{
		int order = showMenu();
		
		while (order != END_OF_DATA)
		{
			floor[yPosition][xPosition] = 1;
			
			switch (order)
			{
				case PEN_UP:	 case PEN_DOWN:
					changePen();
					break;
				case TURN_RIGHT:
					changeDirection(TURN_RIGHT);
					break;
				case TURN_LEFT:
					changeDirection(TURN_LEFT);
					break;
				case MOVE:
					System.out.print("Enter the steps for turtle: ");
					int steps = input.nextInt();
					
					move(steps);
					
					break;
				case DISPLAY:
					display();
					break;
			}
			
			order = showMenu();
		}
	}
	
	public void changePen()
	{
		if (pen == Pen.UP)
			pen = Pen.DOWN;
		else
			pen = Pen.UP;
	}
	
	public void changeDirection(int result)
	{
		final Direction[] d =
			{Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT};
		
		if (result == TURN_RIGHT)
		{
			for (int i = 0; i < d.length; i++)
			{
				if (direction == d[i])
				{
					direction = d[(i + 1) % d.length];
					break;
				}
			}
		}
		else
		{
			for (int i = 0; i < d.length; i++)
			{
				if (direction == d[i])
				{
					direction = d[(i - 1 < 0 ? d.length - 1 : i - 1)];
					break;
				}
			}
		}
	}
	
	public void move(int steps)
	{
		switch (direction)
		{
			case UP:
				for (int i = 0; i < steps && yPosition >= 0; i++)
				{
					floor[yPosition][xPosition] = 1;
					yPosition--;
				}
				
				break;
			case DOWN:
				for (int i = 0; i < steps && yPosition < floor.length; i++)
				{
					floor[yPosition][xPosition] = 1;
					yPosition++;
				}

				break;
			case RIGHT:
				for (int i = 0; i < steps && xPosition < floor.length; i++)
				{
					floor[yPosition][xPosition] = 1;
					xPosition++;
				}
				
				break;
			case LEFT:
				for (int i = 0; i < steps && xPosition >= 0; i++)
				{
					floor[yPosition][xPosition] = 1;
					xPosition--;
				}
				
				break;
		}
		
		xPosition = (xPosition < 0) ? 0 : xPosition;
		xPosition = (xPosition >= FLOOR_LENGTH) ? FLOOR_LENGTH - 1 : xPosition;
		
		yPosition = (yPosition < 0) ? 0 : yPosition;
		yPosition = (yPosition >= FLOOR_LENGTH) ? FLOOR_LENGTH - 1 : yPosition;
		
	}
	
	public void display()
	{
		System.out.println();
		
		for (int[] row : floor)
		{
			for (int value : row)
			{
				System.out.print((value == 0) ? "." : "*");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void showStatus()
	{
		System.out.printf("pen is %s%n", 
			(pen == Pen.UP) ? "up" : "down");
		System.out.printf("your turn is on %s%n", 
			direction.toString().toLowerCase());
		System.out.printf("your position is on (%d, %d)%n%n", xPosition, yPosition);
	}
}
