package PrintingDatesInVariousFormats;

public class PrintingDates
{
	private static final String[] monthsName = 
		{"", "January", "February", "March", "April", "May", "June", "July", "August",
		 "September", "October", "November", "December"};
	
	public static void main(String[] args)
	{
		String date = "04/25/1955";
		System.out.printf("%s -> %s%n", date, convertToStringFormat(date));
	}
	
	public static String convertToStringFormat(String date)
	{
		String[] tokens = date.trim().split("/");
		
		String month = monthsName[Integer.parseInt(tokens[0])];
		String day = tokens[1];
		String year = tokens[2];
		
		return month + " " + day + ", " + year;
	}
}