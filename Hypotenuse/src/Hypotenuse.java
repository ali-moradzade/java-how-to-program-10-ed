import java.util.Scanner;

public class Hypotenuse
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first side of right triangle (or -1 to end input): ");
		double side1 = input.nextDouble();
		
		while (side1 != -1)
		{
			System.out.print("Enter second side of triangle: ");
			double side2 = input.nextDouble();
			
			System.out.printf("Hypotenuse is %.2f%n%n", hypotenuse(side1, side2));
			
			System.out.print("Enter first side of right triangle (or -1 to end input): ");
			side1 = input.nextDouble();
		}
	}
	
	public static double hypotenuse(double side1, double side2)
	{
		return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
	}
}
