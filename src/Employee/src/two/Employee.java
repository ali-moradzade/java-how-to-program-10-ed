package two;

public abstract class Employee
{
	private final Date birthDate;
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber, 
		Date birthDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = birthDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	public Date getBirthDate()
	{
		return birthDate;
	}
	
	public abstract double earnings();
	
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %s%n%s: %s",
			getFirstName(), getLastName(),
			"social security number", getSocialSecurityNumber(),
			"birth date", getBirthDate());
	}
}
