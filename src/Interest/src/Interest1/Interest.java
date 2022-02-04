package Interest1;

public class Interest
{
	public static void main(String[] args)
	{
		double amount;
		double principal = 1000.0;
		
		for (int rate = 5; rate <= 10; rate++)
		{
			System.out.printf("%s%.2f%n%s%25s%n", 
				"Rate: ", (double) rate / 100, "Year", "Amount on deposit");

			for (int year = 1; year <= 10; year++)
			{
				amount = principal * Math.pow(1.0 + rate, year);
				System.out.printf("%4d%,25.2f%n", year, amount);
			}
			
			System.out.println();
		}
	}
}
