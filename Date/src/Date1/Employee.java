package Date1;

public class Employee
{
	private final String firstName;
	private final String lastName;
	private final Date birthDate;
	private final Date hireDate;
	
	public Employee(String firstName, String lastName,
		Date birthDate, Date hireDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s, %s Hired: %s Birthday: %s",
			lastName, firstName, hireDate, birthDate);
	}
}
