package DateAndTime;

public class DateAndTime
{
	private final Date date;
	private final Time time;
	
	public DateAndTime(int second, int minute, int hour, int month, int day, int year)
	{
		date = new Date(month, day, year);
		time = new Time(hour, minute, second);
	}
	
	public void incrementSecond()
	{
		time.tick();
		checkNextDay();
	}
	
	public void incrementMinte()
	{
		time.incrementMinute();
		checkNextDay();
	}
	
	public void incrementHour()
	{
		time.incrementHour();
		checkNextDay();
	}
	
	public void incrementDay()
	{
		date.nextDay();
	}
	
	private void checkNextDay()
	{
		if (time.wentToNextDay())
		{
			date.nextDay();
		}
	}
	
	public String toUniversalString()
	{
		return String.format("%s; %s", time.toUniversalString(), date);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s; %s", time, date);
	}
}
