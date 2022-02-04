package eightqueens;

public class QueenProblem
{
	private static final int FILLED = 1;
	private static final int EMPTY = 0;
	
	private static final int QUEENS_NUMBER = 20;
	
	public static boolean isSafe(int[][] board, int currentRow, int currentCol)
	{
		for (int col = 0; col < currentCol; col++)
		{
			if (board[currentRow][col] == FILLED)
				return false;
		}
		
		int row;
		int col;
		
		for (col = currentCol, row = currentRow; col >= 0 && row >= 0; col--, row--)
		{
				if (board[row][col] == FILLED)
					return false;
		}
		
		for (col = currentCol, row = currentRow; col >= 0 && row < QUEENS_NUMBER;
															  col--, row++)
		{
				if (board[row][col] == FILLED)
					return false;
		}
		
		return true;
	}
	
	public static boolean putQueens(int[][] board, int col)
	{
		if (col >= QUEENS_NUMBER)
			return true;
		
		for (int row = 0; row < QUEENS_NUMBER; row++)
		{
			if (isSafe(board, row, col))
			{
				board[row][col] = FILLED;
				
				if (putQueens(board, col + 1))
					return true;
				
				board[row][col] = EMPTY;
			}
		}
		
		return false;
	}
	
	public static boolean solveQueens()
	{
		int[][] board = new int[QUEENS_NUMBER][QUEENS_NUMBER];
		
		if (putQueens(board, 0) == false)
		{
			System.out.println("Solution does not exist");
			return false;
		}
		
		printBoard(board);
		return true;
	}
	
	public static void printBoard(int[][] board)
	{
		for (int[] row : board)
		{
			for (int value : row)
			{
				System.out.printf(" %d ", value);
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		solveQueens();
	}
}
