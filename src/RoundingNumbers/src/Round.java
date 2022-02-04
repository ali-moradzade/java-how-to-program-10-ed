import java.util.Scanner;

public class Round
{
	private static int placeOfRound = 1;
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a floating-point number: ");
		double number = input.nextDouble();
		
		System.out.print("Enter a number of precision: ");
		placeOfRound = input.nextInt();
		
		System.out.printf("Rounded number to specific number is %f%n", 
			round(number));
	}
	
	public static double round(double number)
	{
		return Math.floor(number * Math.pow(10, placeOfRound) + 0.5) / 
			Math.pow(10, placeOfRound);
	}
}
