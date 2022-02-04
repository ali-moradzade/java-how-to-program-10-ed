package TokenizingTelephoneNumber;

import java.util.Scanner;

public class TelephoneTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a phone number in form (555) 555-5555:");
		String phoneNumber = input.nextLine();
		
		TelephoneNumber telephoneNumber = new TelephoneNumber(phoneNumber);
		
		System.out.printf("%s: %d%n%s: %d%n%s: %d%n%s: %d%n",
			"area code", telephoneNumber.getAreaCode(),
			"three digits", telephoneNumber.getThreeDigits(),
			"four digits", telephoneNumber.getFourDigits(),
			"phone number", telephoneNumber.getPhoneNumber());
	}
}
