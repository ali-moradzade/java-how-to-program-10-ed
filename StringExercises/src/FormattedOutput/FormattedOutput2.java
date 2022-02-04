package FormattedOutput;

public class FormattedOutput2
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 20; i++)
		{
			System.out.printf("%d%s", i, (i % 5 == 0 ? "\n" : "\t"));
		}
	}
}
