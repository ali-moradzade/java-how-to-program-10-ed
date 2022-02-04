package Employee;

public class Employee
{
	private String firstName;
	private String lastName;
	private double salary;
	private String department;

	public Employee(String firstName, String lastName,
		double salary, String department)
	{
		if (salary < 0.0)
			throw new IllegalArgumentException("salary must be >= 0.0");
			
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLastName()
	{
		return lastName;
	}
	
	public void setSalary(double salary)
	{
		if (salary < 0.0)
			throw new IllegalArgumentException("salary must be >= 0.0");
		
		this.salary = salary;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getDepartment()
	{
		return department;
	}
	
	public String getName()
	{
		return String.format("%-8s %-8s", getFirstName(), getLastName());
	}
	
	@Override
	public String toString()
	{
		return String.format("%-8s %-8s %8.2f  %s",
			getFirstName(), getLastName(), getSalary(), getDepartment());
	}
}