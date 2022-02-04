package composition;

public class BasePlusCommissionEmployee 
{
	private double baseSalary;
	private final CommissionEmployee employee;

	public BasePlusCommissionEmployee(String firstName, String lastName, 
		String socialSecurityNumber, double grossSales, 
		double commissionRate, double baseSalary)
	{
		employee = new CommissionEmployee(firstName, lastName, socialSecurityNumber,
			grossSales, commissionRate);
		
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}

	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}
	
	public String getFirstName()
	{
		return employee.getFirstName();
	}
	
	public String getLastName()
	{
		return employee.getLastName();
	}
	
	public String getSocialSecurityNumber()
	{
		return employee.getSocialSecurityNumber();
	}
	
	public void setGrossSales(double grossSales)
	{
		employee.setGrossSales(grossSales);
	}
	
	public double getGrossSales()
	{
		return employee.getGrossSales();
	}
	
	public void setCommissionRate(double commissionRate)
	{
		employee.setCommissionRate(commissionRate);
	}
	
	public double getCommissionRate()
	{
		return employee.getCommissionRate();
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}

	public double earnings()
	{
		return getBaseSalary() + employee.earnings();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %.2f",
			"base-plus", employee.toString(),
			"base salary", getBaseSalary());
	}
}
