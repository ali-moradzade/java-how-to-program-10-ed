public class Square extends TwoDimensionalShape
{
	private double side;

	public Square(double side)
	{
		if (side <= 0.0)
			throw new IllegalArgumentException("side must be > 0");
		
		this.side = side;
	}

	public void setSide(double side)
	{
		if (side <= 0.0)
			throw new IllegalArgumentException("side must be > 0");
		
		this.side = side;
	}

	public double getSide()
	{
		return side;
	}
	
	@Override
	public double getPerimeter()
	{
		return 4 * getSide();
	}

	@Override
	public double getArea()
	{
		return getSide() * getSide();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s:%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			super.toString(), "square",
			"side", getSide(),
			"perimeter", getPerimeter(),
			"area", getArea());
	}
}
