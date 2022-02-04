package one;

public class Employee
{
	private static int count = 0;
	private String firstName;
	private String lastName;
	
	public Employee(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		++count;
		System.out.printf("Employee constructor: %s %s; count = %d%n",
			firstName, lastName, count);
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public static int getCount()
	{
		return count;
	}
}
