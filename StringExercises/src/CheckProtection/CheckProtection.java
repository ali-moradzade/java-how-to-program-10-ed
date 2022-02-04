package CheckProtection;

import java.util.Scanner;

public class CheckProtection
{
	private static final int LENGTH = 9;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter check amount:");
		double amount = input.nextDouble();
		
		String amountString = convertToCheckProtectionFormat(amount);
		System.out.printf("%nProtected amount format is: %s%n", amountString);
	}
	
	public static String convertToCheckProtectionFormat(double amount)
	{
		String amountString = String.valueOf(amount);
		StringBuilder protectedFormat = new StringBuilder();
		
		if (amountString.length() > LENGTH)
			return null;
		
		int asterisks = LENGTH - amountString.length();
		
		for (int i = 0; i < asterisks; i++)
		{
			protectedFormat.append("*");
		}
		
		protectedFormat.append(amountString);
		
		return protectedFormat.toString();
	}
}
