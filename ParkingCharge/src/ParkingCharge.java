import java.util.Scanner;

public class ParkingCharge
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the hours: ");
		double hours = input.nextDouble();
		
		System.out.printf("Your parking charge is %.2f%n", calculateCharges(hours));
	}
	
	public static double calculateCharges(double hours)
	{
		if (hours <= 3.00)
			return 2.0;
		else if (hours <= 16 + 3)
			return 2 + (hours - 3) * 0.5;
		else
			return 10.00;
	}
}
