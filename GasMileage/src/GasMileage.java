import java.util.Scanner;

public class GasMileage
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double totalMilesDriven = 0;
		double totalGallonsUsed = 0;
		
		System.out.print("Enter miles driven for this trip (-1 to end input): ");
		double miles = input.nextDouble();
		
		while (miles != -1)
		{
			System.out.print("Enter gallons used for this trip: ");
			double gallons = input.nextDouble();
			
			totalMilesDriven += miles;
			totalGallonsUsed += gallons;
			
			System.out.printf("The miles per gallon for this trip is %.2f%n%n",
				miles / gallons);
			
			System.out.print("Enter miles driven for this trip (-1 to end input): ");
			 miles = input.nextDouble();
		}
		
		if (totalMilesDriven != 0.0)
		{
			System.out.printf("%nTotal miles per gallon for all trips is %.2f%n",
				totalMilesDriven / totalGallonsUsed);
		}
		else
			System.out.println("No miles driven!");
	}
}
