package IntegerValueOfACharacter;

public class CharacterSet
{
	public static void main(String[] args)
	{
		System.out.printf("The character %c has the value %d%n", 'A', (int) 'A');
		System.out.printf("The character %c has the value %d%n", 'a', (int) 'a');
		System.out.printf("The character %c has the value %d%n", 'B', (int) 'B');
		System.out.printf("The character %c has the value %d%n", '-', (int) '-');
		System.out.printf("The character %c has the value %d%n", '+', (int) '+');
		System.out.printf("The character %c has the value %d%n", '=', (int) '=');
		System.out.printf("The character \"%c\" has the value %d%n", ' ', (int) ' ');
	}
}
