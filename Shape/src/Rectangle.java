public class Rectangle extends TwoDimensionalShape
{
	private double width;
	private double length;

	public Rectangle(double width, double length)
	{
		if (width <= 0.0)
			throw new IllegalArgumentException("width must be > 0.0");
		
		if (length <= 0.0)
			throw new IllegalArgumentException("length must be > 0.0");
		
		this.width = width;
		this.length = length;
	}

	public void setWidth(double width)
	{
		if (width <= 0.0)
			throw new IllegalArgumentException("width must be > 0.0");
		
		this.width = width;
	}

	public double getWidth()
	{
		return width;
	}

	public void setLength(double length)
	{
		if (length <= 0.0)
			throw new IllegalArgumentException("length must be > 0.0");
		
		this.length = length;
	}

	public double getLength()
	{
		return length;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * (getLength() + getWidth());
	}

	@Override
	public double getArea()
	{
		return getLength() * getWidth();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s:%n%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			super.toString(), "ractangle",
			"width", getWidth(),
			"length", getLength(),
			"perimeter", getPerimeter(),
			"area", getArea());
	}
}
