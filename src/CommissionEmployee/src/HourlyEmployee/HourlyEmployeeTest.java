package HourlyEmployee;

public class HourlyEmployeeTest
{
	public static void main(String[] args)
	{
		HourlyEmployee employee = 
			new HourlyEmployee("Sue", "Jones", "222-22-2222", 40, 1000);
		
		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", 
			employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", 
			employee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", 
			employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Hours worked is",
			employee.getHours());
		System.out.printf("%s %.2f%n", "wage is",
			employee.getWage());
		
		employee.setWage(5000);
		employee.setHours(45);
		
		System.out.printf("%n%s:%n%n%s%n",
			"Updated employee information obtained by toString", employee);
	}
}
