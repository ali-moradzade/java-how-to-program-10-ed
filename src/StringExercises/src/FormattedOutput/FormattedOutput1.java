package FormattedOutput;

public class FormattedOutput1
{
	public static void main(String[] args)
	{
		int count = 1;
		
		while (count <= 20)
		{
			System.out.print(count);
			
			if (count % 5 == 0)
				System.out.println();
			else
				System.out.print('\t');
			
			count++;
		}
	}
}
