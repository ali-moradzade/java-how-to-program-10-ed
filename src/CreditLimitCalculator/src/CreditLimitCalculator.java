import java.util.Scanner;

public class CreditLimitCalculator
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter account number (-1 to end input): ");
		int accountNumber = input.nextInt();
		
		while (accountNumber != -1)
		{
			System.out.print("Enter beginning balance of the month: ");
			double beginningBalance = input.nextDouble();
			
			System.out.print(
				"Enter total of all items charged by the customer this month: ");
			double charges = input.nextDouble();
			
			System.out.print(
				"Enter total of all credits applied to the customer's account this month: ");
			double credits = input.nextDouble();
			
			System.out.print("Enter allowed credit limit: ");
			double limit = input.nextDouble();
			
			double balance = (beginningBalance + charges - credits);
			System.out.printf("%nYour new balance is %.2f%n", balance);
			
			if (balance < limit)
				System.out.printf("Credit limit exceeded%n%n");
			
			System.out.print("Enter account number (-1 to end input): ");
			 accountNumber = input.nextInt();
		}
	}
}
