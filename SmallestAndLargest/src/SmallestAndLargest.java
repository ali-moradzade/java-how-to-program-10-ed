import java.util.Scanner;

public class SmallestAndLargest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int number1 = input.nextInt();
		
		System.out.print("Enter second integer: ");
		int number2 = input.nextInt();
		
		System.out.print("Enter third integer: ");
		int number3 = input.nextInt();
		
		int sum = number1 + number2 + number3;
		int product = number1 * number2 * number3;
		int average = (number1 + number2 + number3) / 3;
		int smallest = number1;
		int largest = number1;
		
		if (number2 > largest)
			largest = number2;
		
		if (number3 > largest)
			largest = number3;
		
		if (number2 < smallest)
			smallest = number2;
		
		if (number3 < smallest)
			smallest = number3;
		
		System.out.printf("%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n",
			"Sum is: ", sum,
			"Product is: ", product,
			"Integer average is: ", average,
			"Largest is: ", largest,
			"Smallest is: ", smallest);
	}
}
