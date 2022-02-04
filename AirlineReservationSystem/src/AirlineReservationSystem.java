import java.util.Scanner;

public class AirlineReservationSystem
{
	private final Scanner input;
	private final boolean[] filled;
	
	public AirlineReservationSystem()
	{
		input = new Scanner(System.in);
		filled = new boolean[11];
	}

	public void process()
	{
		while (isSeatFree())
		{
			processOrder();
		}
	}
	
	public void processOrder()
	{
		int choice = showMenu();
		int seatNumber;
		
		switch (choice)
		{
			case 1:
				if ((seatNumber = canGiveFirstClassSeat()) != -1)
				{
					filled[seatNumber] = true;
					System.out.printf("Your seat number is %d (First Class)%n",
						seatNumber);
				}
				else
				{
					if ((seatNumber = canGiveEconomySeat()) != -1)
					{
						System.out.print(
							"Is it acceptable to be placed in economy section (1: yes, 2: no): ");
						int acceptable = input.nextInt();
						
						if (acceptable == 1)
						{
							filled[seatNumber] = true;
							System.out.printf("Your seat number is %d (Economy)%n",
								seatNumber);
						}
						else
							System.out.println("Next flight leaves in 3 hours.");
					}
				}
				break;
			case 2:
				if ((seatNumber = canGiveEconomySeat()) != -1)
				{
					filled[seatNumber] = true;
					System.out.printf("Your seat number is %d (Economy)%n",
						seatNumber);
				}
				else
				{
					if ((seatNumber = canGiveFirstClassSeat()) != -1)
					{
						System.out.print(
							"Is it acceptable to be placed in First Class section (1: yes, 2: no): ");
						int acceptable = input.nextInt();
						
						if (acceptable == 1)
						{
							filled[seatNumber] = true;
							System.out.printf("Your seat number is %d (First Class)%n",
								seatNumber);
						}
						else
							System.out.println("Next flight leaves in 3 hours.");
					}
				}
				break;
		}
		
		System.out.println();
	}
	
	public int showMenu()
	{
		System.out.printf("%s%n%s? ",
			"Please type 1 for Fist Class",
			"Please type 2 for Economy");
		int order = input.nextInt();
		
		while (order != 1 && order != 2)
		{
			System.out.println("Invalud input.");
			System.out.printf("%s%n%s? ",
			"Please type 1 for Fist Class",
			"Please type 2 for Economy");
			
			order = input.nextInt();
		}
		
		return order;
	}
	
	public int canGiveFirstClassSeat()
	{
		for (int i = 1; i <= 5; i++)
		{
			if (filled[i] == false)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public int canGiveEconomySeat()
	{
		for (int i = 6; i < filled.length; i++)
		{
			if (filled[i] == false)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean isSeatFree()
	{
		for (int seat = 1; seat < filled.length; seat++)
		{
			if (filled[seat] == false)
				return true;
		}
		
		return false;
	}
}
