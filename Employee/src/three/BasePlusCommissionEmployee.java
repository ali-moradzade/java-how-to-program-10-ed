package three;

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, 
		String socialSecurityNumber, double grossSales, 
		double commissionRate, double baseSalary)
	{
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}

	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("base salary must be >= 0.0");
		
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return getBaseSalary() + super.getPaymentAmount();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%,.2f",
			"base-salaried", super.toString(),
			"base salary", getBaseSalary());
	}
}
