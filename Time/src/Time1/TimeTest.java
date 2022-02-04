package Time1;

public class TimeTest
{
	public static void main(String[] args)
	{
		Time t1 = new Time();
		Time t2 = new Time(2);
		Time t3 = new Time(21, 34);
		Time t4 = new Time(12, 25, 42);
		Time t5 = new Time(t4);
		
		displayTime("t1: all default arguments", t1);
		displayTime("t2: hour specified; default minute and second", t2);
		displayTime("t3: hour and minute specified; default second", t3);
		displayTime("t4: hour, minute and second specified", t4);
		displayTime("t5: Time object t4 specified", t5);
		
		try
		{
			Time t6 = new Time(27, 74, 99);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("%nException while initializing t6: %s%n",
				e.getMessage());
		}
	}
	
	private static void displayTime(String header, Time t)
	{
		System.out.printf("%s%n   %s%n   %s%n",
			header, t.toUniversalString(), t.toString());
	}
}
