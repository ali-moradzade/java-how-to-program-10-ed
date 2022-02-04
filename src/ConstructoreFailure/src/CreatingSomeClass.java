public class CreatingSomeClass
{
	public static void main(String[] args)
	{
		try
		{
			SomeClass someClass = new SomeClass();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
