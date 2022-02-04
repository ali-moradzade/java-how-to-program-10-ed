public class DeckOfCardsTest
{
	private static final int	NUMBER_OF_CARDS = 52;
	
	public static void main(String[] args)
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		showCards(myDeckOfCards);
	}
	
	public static void showCards(DeckOfCards deck)
	{
		for (int i = 1; i <= NUMBER_OF_CARDS; i++)
		{
			System.out.printf("%-19s", deck.dealCard());

			if (i % 4 == 0)
				System.out.println();
		}
	}
}
