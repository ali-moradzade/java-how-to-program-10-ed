public class TabularOutput
{
	public static void main(String[] args)
	{
		System.out.println("N\t10*N\t100*N\t");
		int count = 1;
		
		while (count <= 5)
		{
			System.out.printf("%d\t%d\t%d%n", count, 10 * count, 100 * count);
			count++;
		}
	}
}
