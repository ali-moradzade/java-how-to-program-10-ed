import static java.lang.Math.PI;

public class Circle extends TwoDimensionalShape
{
	private double radius;
	
	public Circle(double radius)
	{
		if (radius <= 0.0)
			throw new IllegalArgumentException("radius must be > 0");
		
		this.radius = radius;
	}

	public void setRadius(double radius)
	{
		if (radius <= 0.0)
			throw new IllegalArgumentException("radius must be > 0");
		
		this.radius = radius;
	}

	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * PI * getRadius();
	}

	@Override
	public double getArea()
	{
		return PI * getRadius() * getRadius();
	}
		
	@Override
	public String toString()
	{
		return String.format("%s %s:%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			super.toString(), "circle",
			"radius", getRadius(),
			"perimeter", getPerimeter(),
			"area", getArea());
	}
}
