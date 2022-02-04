package two;

public class SalariedEmployee extends Employee
{
	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName,
		String socialSecurityNumber, Date birthDate, double weeklySalary)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);
		
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("weekly salary must be >= 0");
		
		this.weeklySalary = weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary)
	{
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("weekly salary must be >= 0");
		
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	@Override
	public double earnings()
	{
		return getWeeklySalary();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%.2f",
			"salaried employee", super.toString(),
			"weekly salary", getWeeklySalary());
	}
}
