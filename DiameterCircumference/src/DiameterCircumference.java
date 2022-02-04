import java.util.Scanner;

public class DiameterCircumference
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter radius of circle: ");
		int radius = scanner.nextInt();
		
		System.out.printf("%s%d%n%s%f%n%s%f%n",
			"Diameter: ", 2 * radius,
			"Circumference: ", 2 * Math.PI * radius,
			"Area: ", Math.PI * radius * radius);
	}
}
