import java.util.Scanner;

public class SalesCommissionCalculator
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the gross sales for this week (-1 to end input): ");
		double grossSales = input.nextDouble();
		
		while (grossSales != -1)
		{
			double salary = 200.0 + 0.09 * grossSales;
			System.out.printf("Your salary for this week is %.2f%n%n", salary);
			
			System.out.print("Enter the gross sales for this week (-1 to end input): ");
			 grossSales = input.nextDouble();
		}
	}
}
