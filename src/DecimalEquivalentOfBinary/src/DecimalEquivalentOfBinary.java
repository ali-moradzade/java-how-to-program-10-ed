import java.util.Scanner;

public class DecimalEquivalentOfBinary
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a binary number: ");
		int binary = input.nextInt();
		
		System.out.printf("Decimal equivalent of the number is %d%n",
			convertToDecimal(binary));
	}
	
	public static int convertToDecimal(int binary)
	{
		int counter = 0;
		int decimal = 0;
		
		while (binary > 0)
		{
			decimal += (int) ((binary % 10) * Math.pow(2, counter));
			binary /= 10;
			counter++;
		}
		
		return decimal;
	}
}
