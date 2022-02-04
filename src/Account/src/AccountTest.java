import java.util.Scanner;

public class AccountTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		Account myAccount = new Account();
		
		System.out.printf("Initial name is: %s%n%n", myAccount.getName());
		
		System.out.println("Please enter the name:");
		String name = input.nextLine();
		
		myAccount.setName(name);
		
		System.out.printf("%nName in object myAccount is: %n%s%n", 
			myAccount.getName());
	}
}
