package Time2;

public class TimeTest
{
	public static void main(String[] args)
	{
		Time time = new Time();
		
		for (int i = 0; i < 24 * 60 + 1 + 1 + 1; i++)
		{
			System.out.printf("%s%n%s%n%n",
				time.toUniversalString(), time.toString());
			
			time.incrementMinute();
		}
	}
}
