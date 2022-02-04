package Time1;

public class Time
{
	private static final int SECONDS_PER_MINUTE = 60;
	private static final int MINUTES_PER_HOUR = 60;
	
	private int secondsFromMidnight;
	
	public Time()
	{
		this(0, 0, 0);
	}
	
	public Time(int hour)
	{
		this(hour, 0, 0);
	}
	
	public Time(int hour, int minute)
	{
		this(hour, minute, 0);
	}
	
	public Time(Time time)
	{
		this(time.getHour(), time.getMinute(), time.getSecond());
	}
	
	public Time(int hour, int minute, int second)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		
		secondsFromMidnight = ((hour * MINUTES_PER_HOUR) + minute) * 
			SECONDS_PER_MINUTE + second;
	}
	
	public void setTime(int hour, int minute, int second)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		
		secondsFromMidnight = ((hour * MINUTES_PER_HOUR) + minute) * 
			SECONDS_PER_MINUTE + second;
	}
	
	public void setHour(int hour)
	{
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");
		
		secondsFromMidnight -= getHour() * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
		secondsFromMidnight += hour * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
	}
	
	public void setMinute(int minute)
	{
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");
		
		secondsFromMidnight -= getMinute() * SECONDS_PER_MINUTE;
		secondsFromMidnight += minute * SECONDS_PER_MINUTE;
	}
	
	public void setSecond(int second)
	{
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");
		
		secondsFromMidnight -= getSecond();
		secondsFromMidnight += second;
	}

	public int getHour()
	{
		return secondsFromMidnight / (MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
	}

	public int getMinute()
	{
		return (secondsFromMidnight - 
			getHour() * (MINUTES_PER_HOUR * SECONDS_PER_MINUTE)) / 
			SECONDS_PER_MINUTE;
	}

	public int getSecond()
	{
		return secondsFromMidnight - 
			(getHour() * (MINUTES_PER_HOUR * SECONDS_PER_MINUTE) +
			getMinute() * SECONDS_PER_MINUTE);
	}
	
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}
	
	@Override
	public String toString()
	{
		return String.format("%d:%02d:%02d %s",
			((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
			getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
}