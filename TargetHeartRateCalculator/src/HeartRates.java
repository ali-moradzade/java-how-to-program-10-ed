public class HeartRates
{
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	HeartRates(String firstName, String lastName, Date dateOfBirth)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
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

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public int getAge(Date currentDate)
	{
		return currentDate.getYear() - getDateOfBirth().getYear();
	}
	
	public int getMaximumHeartRate(Date currentDate)
	{
		return 220 - getAge(currentDate);
	}
}
