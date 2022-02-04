public class Cube extends ThreeDimensionalShape
{
	private double side;
	
	public Cube(double side)
	{
		if (side <= 0.0)
			throw new IllegalArgumentException("side must be > 0.0");
		
		this.side = side;
	}

	public void setSide(double side)
	{
		if (side <= 0.0)
			throw new IllegalArgumentException("side must be > 0.0");
		
		this.side = side;
	}

	public double getSide()
	{
		return side;
	}
	
	
	@Override
	public double getVolume()
	{
		return getSide() * getSide() * getSide();
	}

	@Override
	public double getArea()
	{
		return 6 * getSide() * getSide();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s:%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			super.toString(), "cube",
			"side", getSide(),
			"area", getArea(),
			"volume", getVolume());
	}
}
