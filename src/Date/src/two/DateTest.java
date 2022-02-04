package two;

public class DateTest
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 365; i++)
		{
			Date date = new Date(i + 1, 2000);
			date.displayDate();
		}
	}
}
