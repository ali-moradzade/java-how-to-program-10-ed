import java.util.Scanner;

public class Values
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter five integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		int number4 = input.nextInt();
		int number5 = input.nextInt();
		
		int positives = 0;
		int negatives = 0;
		int zeros = 0;
		
		if (number1 > 0)
			positives = positives + 1;
		
		if (number1 < 0)
			negatives = negatives + 1;
		
		if (number1 == 0)
			zeros = zeros + 1;
		
		if (number2 > 0)
			positives = positives + 1;
		
		if (number2 < 0)
			negatives = negatives + 1;
		
		if (number2 == 0)
			zeros = zeros + 1;
		
		if (number3 > 0)
			positives = positives + 1;
		
		if (number3 < 0)
			negatives = negatives + 1;
		
		if (number3 == 0)
			zeros = zeros + 1;
		
		if (number4 > 0)
			positives = positives + 1;
		
		if (number4 < 0)
			negatives = negatives + 1;
		
		if (number4 == 0)
			zeros = zeros + 1;
		
		if (number5 > 0)
			positives = positives + 1;
		
		if (number5 < 0)
			negatives = negatives + 1;
		
		if (number5 == 0)
			zeros = zeros + 1;
		
		System.out.printf("%s%d%n%s%d%n%s%d%n",
			"positives: ", positives,
			"negatives: ", negatives,
			"zeros: ", zeros);
	}
}
