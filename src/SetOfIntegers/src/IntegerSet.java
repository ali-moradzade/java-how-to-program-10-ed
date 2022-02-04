public class IntegerSet
{
	private static final int NUMBER_OF_INTEGERS = 101;
	private final boolean[] set;
	
	public IntegerSet()
	{
		set = new boolean[NUMBER_OF_INTEGERS];
	}
	
	public static IntegerSet union(IntegerSet firstSet, IntegerSet secondSet)
	{
		IntegerSet result = new IntegerSet();
		
		for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
		{
			result.set[i] = firstSet.set[i] || secondSet.set[i];
		}
		
		return result;
	}
	
	public static IntegerSet intersection(IntegerSet firstSet, IntegerSet secondSet)
	{
		IntegerSet result = new IntegerSet();
		
		for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
		{
			result.set[i] = firstSet.set[i] && secondSet.set[i];
		}
		
		return result;
	}
	
	public void insertElement(int element)
	{
		try
		{
			set[element] = true;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.printf("element %d is not in the range 0-100. Please try again.", 
				element);
		}
	}
	
	public void deleteElement(int element)
	{
		try
		{
			set[element] = false;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.printf("element %d is not in the range 0-100. Please try again.", 
				element);
		}
	}
	
	public boolean isEqualTo(IntegerSet checkingSet)
	{
		for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
		{
			if (checkingSet.set[i] != set[i])
				return false;
		}
		
		return true;
	}
	
	public boolean isEmpty()
	{
		for (boolean b : set)
		{
			if (b == true)
				return false;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("The set is: ");
		
		if (isEmpty())
			result.append("---\n");
		else
		{
			for (int i = 0; i < NUMBER_OF_INTEGERS; i++)
			{
				if (set[i] == true)
					result.append(String.format("%d ", i));
			}
			
			result.append("\n");
		}
		
		return result.toString();
	}
}
