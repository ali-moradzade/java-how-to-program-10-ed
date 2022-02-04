package DateAndTime;

public class Date
{
	private int month;
	private int day;
	private int year;
	
	private static final int[] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int month, int day, int year)
	{
		if (year <= 0 || year > 2020)
			throw new IllegalArgumentException("year (" + year + ") must be 1-2020");
		
		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");
		
		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException("day (" + day + 
				") out-of-range for the specified month and year");
		
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void nextDay()
	{
		if (day + 1 > daysPerMonth[month])
		{
			day = 1;
			month++;
			
			if (month > 12)
			{
				month = 1;
				year++;
			}
		}
		else
			day++;
	}
	
	@Override
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}
}
