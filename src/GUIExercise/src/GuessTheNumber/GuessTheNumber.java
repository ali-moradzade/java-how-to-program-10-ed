package GuessTheNumber;

import java.util.Random;

public class GuessTheNumber
{
	private final Random randomNumbers;
	private int number;
	
	public GuessTheNumber()
	{
		randomNumbers = new Random();
		number = 1 + randomNumbers.nextInt(1000);
	}
	
	public int getTheNumber(int guessedNumber)
	{
		if (guessedNumber < number)
			return Guess.TOO_LOW;
		else if (guessedNumber > number)
			return Guess.TOO_HIGH;
		
		return Guess.CORRECT;
	}
	
	public void startNewGame()
	{
		number = 1 + randomNumbers.nextInt(1000);
	}
}
