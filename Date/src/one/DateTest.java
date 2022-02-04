package one;

public class DateTest
{
	public static void main(String[] args) 
	{
		Date date = new Date(1, 1, 1);
		
		for (int i = 0; i < 366; i++)
		{
			System.out.println(date);
			date.nextDay();
		}
	}
}
