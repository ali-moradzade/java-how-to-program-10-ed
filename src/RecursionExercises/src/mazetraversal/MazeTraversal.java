package mazetraversal;

import java.awt.Point;
import java.util.Arrays;
import java.util.Random;

public class MazeTraversal
{
	public static void main(String[] args)
	{
		solveMaze();
	}
	
	public static void solveMaze()
	{
		char[][] board = mazeGenerator2(15);
		
		System.out.println("The original maze is:");
		displayMaze(board);
		
		if (mazeTraversal(board, 2, 0) == false)
		{
			System.out.printf("%nSolution does not exist.%n");
			return;
		}
		
		System.out.printf("%nSolved maze is:%n");
		displayMaze(board);
	}
	
	public static boolean mazeTraversal(char[][] board, int row, int col)
	{
		if (col == board.length - 1)
			return true;
		
		board[row][col] = 'x';
		
		if (canGoRight(board, row, col))
		{
			board[row][col + 1] = 'x';
			
			if (mazeTraversal(board, row, col + 1))
				return true;
			
			board[row][col + 1] = '.';
		}
		
		if (canGoUp(board, row, col))
		{
			board[row - 1][col] = 'x';
			
			if (mazeTraversal(board, row - 1, col))
				return true;
			
			board[row - 1][col] = '.';
		}
		
		if (canGoDown(board, row, col))
		{
			board[row + 1][col] = 'x';
			
			if (mazeTraversal(board, row + 1, col))
				return true;
			
			board[row + 1][col] = '.';
		}
		
		if (canGoLeft(board, row, col))
		{
			board[row][col - 1] = 'x';
			
			if (mazeTraversal(board, row, col - 1))
				return true;
			
			board[row][col - 1] = '.';
		}
		
		return false;
	}
	
	private static boolean canGoUp(char[][] board, int row, int col)
	{
		if (row - 1 < 0)
			return false;
		
		return board[row - 1][col] == '.';
	}
	
	private static boolean canGoDown(char[][] board, int row, int col)
	{
		if (row + 1 >= board.length)
			return false;
		
		return board[row + 1][col] == '.';
	}
	
	private static boolean canGoRight(char[][] board, int row, int col)
	{
		if (col + 1 >= board.length)
			return false;
		
		return board[row][col + 1] == '.';
	}
	
	private static boolean canGoLeft(char[][] board, int row, int col)
	{
		if (col - 1 < 0)
			return false;
		
		return board[row][col - 1] == '.';
	}
	
	public static void displayMaze(char[][] board)
	{
		for (char[] row : board)
		{
			for (char c : row)
			{
				System.out.printf(" %c ", c);
			}
			
			System.out.println();
		}
	}
	
	public static char[][] mazeGenerator1()
	{
		char[][] board =
			{{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
			 {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
			 {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
			 {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
			 {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
			 {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
			 {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
			 {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
			 {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
			 {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
			 {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
			 {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};
		
		return board;
	}
	
	public static char[][] mazeGenerator2(int size)
	{
		Random random = new Random();
		char[][] board = new char[size][size];

		for (char[] row : board)
		{
			Arrays.fill(row, '#');
		}
		
		char[] characters = {'.', '#'};
		
		for (int row = 1; row < size - 1; row++)
		{
			for (int col = 1; col < size - 1; col++)
			{
				board[row][col] = characters[random.nextInt(characters.length)];
			}
		}
		
		Point start = new Point(1 + random.nextInt(size - 2), 0);
		Point end = new Point(1 + random.nextInt(size - 2), size - 1);
		
		board[start.x][start.y] = '.';
		board[start.x][start.y + 1] = '.';
		
		board[end.x][end.y] = '.';
		board[end.x][end.y - 1] = '.';
		
		return board;
	}
}
