package FormattedOutput;

public class FormattedOutput
{
	public static void main(String[] args)
	{
		int counter = 1;
		
		while (counter <= 20)
		{
			System.out.printf("%d%s", counter, (counter % 5 == 0 ? "\n" : "\t"));
			counter++;
		}
	}
}
