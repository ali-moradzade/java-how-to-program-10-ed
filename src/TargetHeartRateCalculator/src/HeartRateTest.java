import java.util.Scanner;

public class HeartRateTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter patient first name: ");
		String firstName = input.next();
		
		System.out.print("Enter patient last name: ");
		String lastName = input.next();
		
		System.out.print("Enter birth year of the patient: ");
		int year = input.nextInt();
		
		System.out.print("Enter birth month of the parient: ");
		int month = input.nextInt();
		
		System.out.print("Enter birth day of the patient: ");
		int day = input.nextInt();
		
		System.out.print("Enter the current year: ");
		int currentYear = input.nextInt();
		
		System.out.print("Enter the current month: ");
		int currentMonth = input.nextInt();
		
		System.out.print("Enter the current day: ");
		int currentDay = input.nextInt();
		
		Date currentDate = new Date(currentMonth, currentDay, currentYear);
		
		HeartRates heartRates = 
			new HeartRates(firstName, lastName, new Date(month, day, year));
		
		System.out.printf("%nInformaiton about the patient:%n%n");
		System.out.printf("%s%s%n%s%s%n%s%s%n%s%d%n",
			"First name: ", heartRates.getFirstName(),
			"Last name: ", heartRates.getLastName(),
			"Age: ", heartRates.getAge(currentDate),
			"Maximum heart rate: ", heartRates.getMaximumHeartRate(currentDate));
	}
}
