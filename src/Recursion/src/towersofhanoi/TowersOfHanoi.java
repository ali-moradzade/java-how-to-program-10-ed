package towersofhanoi;

public class TowersOfHanoi
{
	public static void solveTowers(int disks, int sourcePeg,
		int destinationPeg, int tempPeg)
	{
		if (disks == 1)
		{
			System.out.printf("%d --> %d%n", sourcePeg, destinationPeg);
			return;
		}
		
		solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);
		
		System.out.printf("%d --> %d%n", sourcePeg, destinationPeg);
		solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
	}

	public static void main(String[] args)
	{
		int sourcePeg = 1;
		int tempPeg = 2;
		int destinationPeg = 3;
		int totalDisks = 64;
		
		solveTowers(totalDisks, sourcePeg, destinationPeg, tempPeg);
	}
}
