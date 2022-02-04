public class EmployeeTest
{
	public static void main(String[] args) 
	{
		Employee employee1 = new Employee("John", "Green", 125.5);
		Employee employee2 = new Employee("Jane", "Blue", 500.3);
		
		System.out.printf("Showing employees attributes:%n%n");
		
		displayEmployee(employee1);
		System.out.println();
		
		displayEmployee(employee2);
	}
	
	public static void displayEmployee(Employee employee)
	{
		System.out.printf("%s%s%n%s%s%n%s%.2f%n%s%.2f%n",
			"First name: ", employee.getFirstName(),
			"Last name: ", employee.getLastName(),
			"Monthly salary: ", employee.getMonthlySalary(),
			"Yearly salary: ", employee.getYearlySalary());
	}
}
