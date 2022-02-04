public class FacebookMembers
{
	public static void main(String[] args)
	{
		long currentMembers;
		long principle = 1000000;
		double rate = 0.04;
		
		System.out.printf("%s%10s%n", "Month", "Memebers");
		
		for (int month = 1; month <= 8 * 12; month++)
		{
			currentMembers = (long) (principle * Math.pow(1 + rate, month));
			
			System.out.printf("%5d%10d%n", month, currentMembers);
		}
	}
}
