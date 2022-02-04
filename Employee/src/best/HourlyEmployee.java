package best;

public class HourlyEmployee extends Employee
{
	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, 
		String socialSecurityNumber, Date birthDate, double wage, double hours)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);
		
		if (wage < 0.0)
			throw new IllegalArgumentException("wage per hour must be >= 0.0");
		
		if (hours < 0.0 || hours > 168)
			throw new IllegalArgumentException("hours worked must be >= 0 and <= 168");
		
		this.wage = wage;
		this.hours = hours;
	}

	public void setWage(double wage)
	{
		if (wage < 0.0)
			throw new IllegalArgumentException("wage per hour must be >= 0.0");
		
		this.wage = wage;
	}

	public double getWage()
	{
		return wage;
	}
	
	public void setHours(double hours)
	{
		if (hours < 0.0 || hours > 168)
			throw new IllegalArgumentException("hours worked must be >= 0 and <= 168");
		
		this.hours = hours;
	}

	public double getHours()
	{
		return hours;
	
	}

	@Override
	public double earnings()
	{
		return (getHours() <= 40) ? (getHours() * getWage()) : 
			((getHours() - 40) * 1.5 + 40) * getWage();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
			"hourly employee", super.toString(),
			"wage per hour", getWage(),
			"hours worked", getHours());
	}
}
