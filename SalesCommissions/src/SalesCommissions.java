import java.util.Scanner;

public class SalesCommissions
{
	private static final int[] frequency = new int[11];
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s%n? ",
			"Enter gross sales (or -1 to end data):");
		double grossSale = input.nextDouble();
		
		while (grossSale >= 0)
		{
			double salary = calculateSalary(grossSale);
			
			if (salary <= 1000)
				++frequency[(int) salary / 100];
			else
				++frequency[10];
			
			System.out.print("? ");
			grossSale = input.nextDouble();
		}
		
		outputBarChart();
	}
	
	public static double calculateSalary(double grossSale)
	{
		return 200.0 + 0.09 * grossSale;
	}
	
	public static void outputBarChart()
	{
		System.out.printf("%nSalary distribution for this inputs is:%n");
		
		for (int counter = 2; counter < frequency.length; counter++)
		{
			if (counter == 10)
				System.out.print("over 1000: ");
			else
				System.out.printf("%3d -%4d: ", 100 * counter, 100 * counter + 99);
			
			for (int i = 0; i < frequency[counter]; i++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
