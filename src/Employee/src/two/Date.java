package two;

public class Date
{
	private int month;
	private int day;
	private int year;
	
	private static final int[] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] monthsName = 
		{"", "january", "february", "march", "april", "may", "june", "july", "august",
		 "september", "october", "november", "december"};
	
	public Date(int day, int year)
	{
		int total = 0;
		int month = -1;
		
		for (int i = 1; i < daysPerMonth.length; i++)
		{
			total += daysPerMonth[i];
			
			if (total >= day)
			{
				day = day + daysPerMonth[i] - total;
				month = i;
				break;
			}
		}
		
		validate(month, day, year);
		
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public Date(String monthString, int day, int year)
	{
		int month = -1;
		
		for (int i = 1; i < monthsName.length; i++)
		{
			if (monthString.toLowerCase().equals(monthsName[i]))
				month = i;
		}
		
		validate(month, day, year);
		
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public Date(int month, int day, int year)
	{
		validate(month, day, year);
		
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public static final void validate(int month, int day, int year)
	{
		if (year <= 0 || year > 2020)
			throw new IllegalArgumentException("year (" + year + ") must be 1-2020");
		
		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");
		
		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException("day (" + day + 
				") out-of-range for the specified month and year");
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
	
	public void displayDate()
	{
		System.out.println("Date of today:");
		System.out.printf("%s%n%s%n%s%n%n",
			format1String(),
			format2String(),
			format3String());
	}
	
	private String format1String()
	{
		return toString();
	}
	
	private String format2String()
	{
		return String.format("%s %d, %d",
			monthsName[getMonth()], getDay(), getYear());
	}
	
	private String format3String()
	{
		int total = 0;
		
		for (int i = 1; i <= month; i++)
		{
			total += daysPerMonth[i - 1];
		}
		
		return String.format("%d %d", getDay() + total, getYear());
	}
	
	@Override
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}
}
