import java.util.Scanner;

public class OddOrEven
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		
		if (number % 2 == 0)
			System.out.printf("%d is an even integer.%n", number);
		
		if (number % 2 != 0)
			System.out.printf("%d is an odd integer.%n", number);
	}
}
