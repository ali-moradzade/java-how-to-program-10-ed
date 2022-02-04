public abstract class TwoDimensionalShape extends Shape
{
	public abstract double getPerimeter();
	
	@Override
	public String toString()
	{
		return String.format("%s", "two-dimensional:");
	}
}
