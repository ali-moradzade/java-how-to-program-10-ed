import java.util.Scanner;

public class LargestAndSmallest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int number1 = input.nextInt();
		
		System.out.print("Enter second number: ");
		int number2 = input.nextInt();
		
		System.out.print("Enter third number: ");
		int number3 = input.nextInt();
		
		System.out.print("Enter fourth number: ");
		int number4 = input.nextInt();
		
		System.out.print("Enter fifth number: ");
		int number5 = input.nextInt();
		
		int smallest = number1;
		
		if (number2 < smallest)
			smallest = number2;
		
		if (number3 < smallest)
			smallest = number3;
		
		if (number4 < smallest)
			smallest = number4;
		
		if (number5 < smallest)
			smallest = number5;
		
		int largest = number1;
		
		if (number2 > largest)
			largest = number2;
		
		if (number3 > largest)
			largest = number3;
		
		if (number4 > largest)
			largest = number4;
		
		if (number5 > largest)
			largest = number5;
		
		System.out.printf("%n%s%d%n%s%d%n",
			"Largest: ", largest,
			"Smallest: ", smallest);
	}		
}
