package Date1;

public class EmployeeTest
{
	public static void main(String[] args)
	{
		Date birth = new Date(7, 4, 1949);
		Date hire = new Date(3, 12, 1988);
		Employee employee = new Employee("Bob", "Blue", birth, hire);
		
		System.out.println(employee);
	}
}
