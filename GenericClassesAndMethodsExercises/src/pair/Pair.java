package pair;

public class Pair<F, S>
{
	private F firstElement;
	private S secondElement;
	
	public Pair(F firstElement, S secondElement)
	{
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	public void setFirstElement(F firstElement)
	{
		this.firstElement = firstElement;
	}

	public F getFirstElement()
	{
		return firstElement;
	}

	public void setSecondElement(S secondElement)
	{
		this.secondElement = secondElement;
	}

	public S getSecondElement()
	{
		return secondElement;
	}
}


