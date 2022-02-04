public class PythagoreanTiples
{
	public static void main(String[] args)
	{
		for (int side1 = 1; side1 <= 500; side1++)
		{
			for (int side2 = 1; side2 <= 500; side2++)
			{
				for (int side3 = 1; side3 <= 500; side3++)
				{
					if ((side1 * side1 + side2 * side2 == side3 * side3) ||
						(side3 * side3 + side2 * side2 == side1 * side1) ||
						(side1 * side1 + side3 * side3 == side2 * side2))
						System.out.printf("%d, %d, %d%n", side1, side2, side3);
				}
			}
		}
	}
}
