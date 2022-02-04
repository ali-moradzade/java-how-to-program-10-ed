package HourlyEmployee;

public class HourlyEmployee	extends Employee
{
	private static final int HOURS_PER_DAY = 24;
	private static final int DAYS_PER_WEEK = 7;
	private double hours;
	private double wage;

	public HourlyEmployee(String firstName, String lastName, 
		String socialSecurityNumber, double hours, double wage)
	{
		super(firstName, lastName, socialSecurityNumber);
		
		if (hours < 0 || hours >= HOURS_PER_DAY * DAYS_PER_WEEK)
			throw new IllegalArgumentException("hours must fit in a week (in range 0-168)");
		
		if (wage < 0)
			throw new IllegalArgumentException("wage must be >= 0");
		
		this.hours = hours;
		this.wage = wage;
	}

	public void setHours(double hours)
	{
		if (hours < 0 || hours >= HOURS_PER_DAY * DAYS_PER_WEEK)
			throw new IllegalArgumentException("hours must fit in a week (in range 0-168)");
		
		this.hours = hours;
	}

	public double getHours()
	{
		return hours;
	}

	public void setWage(double wage)
	{
		if (wage < 0)
			throw new IllegalArgumentException("wage must be >= 0");
	
		this.wage = wage;
	}

	public double getWage()
	{
		return wage;
	}
	
	public double earnings()
	{
		return (getHours() > 40) ? ((getHours() - 40) * 1.5 + 40) * getWage() :
			getHours() * getWage();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: %.2f%n%s: %.2f",
			"hourly-employee", super.toString(),
			"hours", getHours(),
			"wage", getWage());
	}
}
