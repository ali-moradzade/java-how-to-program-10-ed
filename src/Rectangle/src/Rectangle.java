public class Rectangle
{
	private double length;
	private double width;
	
	public Rectangle()
	{
		this(1.0, 1.0);
	}
	
	public Rectangle(double length, double width)
	{
		if (length <= 0.0 || length > 20.0)
			throw new IllegalArgumentException("length must be in range 0-20");
		
		if (width <= 0.0 || width > 20.0)
			throw new IllegalArgumentException("width must be in range 0-20");
		
		this.length = length;
		this.width = width;
	}

	public void setLength(double length)
	{
		if (length <= 0.0 || length > 20.0)
			throw new IllegalArgumentException("length must be in range 0-20");
		
		this.length = length;
	}

	public double getLength()
	{
		return length;
	}

	public void setWidth(double width)
	{
		if (width <= 0.0 || width > 20.0)
			throw new IllegalArgumentException("width must be in range 0-20");
		
		this.width = width;
	}

	public double getWidth()
	{
		return width;
	}
	
	public double getPerimeter()
	{
		return 2 * (getWidth() + getLength());
	}
	
	public double getArea()
	{
		return getWidth() * getLength();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %.2f%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			"width", getWidth(),
			"length", getLength(),
			"perimeter", getPerimeter(),
			"area", getArea());
	}
}
