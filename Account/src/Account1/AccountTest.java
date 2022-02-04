package Account1;

public class AccountTest
{
	public static void main(String[] args)
	{
		Account account1 = new Account("Jane Green");
		Account account2 = new Account("John Blue");
		
		System.out.printf("%s%s%n%s%s%n",
			"account1 name is: ", account1.getName(),
			"account2 name is: ", account2.getName());
	}
}
