package DateAndTime;

public class DateAndTimeTest
{
	public static void main(String[] args)
	{
		DateAndTime dateAndTime = new DateAndTime(0, 0, 0, 1, 1, 1);
		
		for (int i = 0; i < 365 + 1; i++)
		{
			dateAndTime.incrementDay();
			
			System.out.printf("%s%n%s%n%n",
				dateAndTime.toUniversalString(), dateAndTime.toString());
		}
	}
}
