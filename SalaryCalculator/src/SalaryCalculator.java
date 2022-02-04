import java.util.Scanner;

public class SalaryCalculator
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter hours worked this week (-1 to end input): ");
		double hours = input.nextDouble();
		
		while (hours != -1)
		{
			System.out.print("Enter hourly rate for this employee: ");
			double rate = input.nextDouble();
			
			double salary = calculateSalary(hours, rate);
			System.out.printf("Employees gross pay is %.2f%n%n", salary);
			
			System.out.print("Enter hours worked this week (-1 to end input): ");
			 hours = input.nextDouble();
		}
	}
	
	public static double calculateSalary(double hours, double rate)
	{
		return (hours > 40) ? (40 * rate + (hours - 40) * rate * 1.5) : (hours * rate); 
	}
}
