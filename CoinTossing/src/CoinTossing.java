import java.util.Scanner;
import java.util.Random;

public class CoinTossing
{
	private enum Coin {HEAD, TAIL};
	private enum Menu {TOSS_COIN, EXIT};
	
	private static int headCount = 0;
	private static int tailCount = 0;
	
	public static void main(String[] args)
	{
		Menu status = showMenu();
		
		while (status == Menu.TOSS_COIN)
		{
			Coin coin = flip();
			
			showInformation(coin);
			
			status = showMenu(); 
		}
	}
	
	public static Coin flip()
	{
		Random randomNumbers = new Random();
		
		return (randomNumbers.nextBoolean() ? Coin.HEAD : Coin.TAIL);
	}
	
	public static Menu showMenu()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n%s%n%s%n? ",
			"Choose your option:",
			"1 -- toss coin",
			"2 -- exit");
		
		return (input.nextInt() == 1) ? Menu.TOSS_COIN : Menu.EXIT;
	}
	
	public static void showInformation(Coin coin)
	{
		if (coin == Coin.HEAD)
			headCount++;
		else
			tailCount++;
		
		System.out.printf("%n%s%d%n%s%d%n%n",
			"heads: ", headCount,
			"tails: ", tailCount);
	}
}
