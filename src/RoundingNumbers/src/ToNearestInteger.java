import java.util.Scanner;

public class ToNearestInteger
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a floating-point number: ");
		double number = input.nextDouble();
		
		System.out.printf("Rounded number to nearest integer is %d%n", 
			roundToInteger(number));
	}
	
	public static int roundToInteger(double number)
	{
		return (int) Math.floor(number + 0.5);
	}
}
