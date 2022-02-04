import static java.lang.Math.PI;

public class Sphere extends ThreeDimensionalShape
{
	private double radius;
	
	public Sphere(double radius)
	{
		if (radius <= 0.0)
			throw new IllegalArgumentException("radius must be > 0.0");
		
		this.radius = radius;
	}

	public void setRadius(double radius)
	{
		if (radius <= 0.0)
			throw new IllegalArgumentException("radius must be > 0.0");
		
		this.radius = radius;
	}

	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double getVolume()
	{
		return (4.0 / 3.0) * PI * getRadius() * getRadius() * getRadius();
	}

	@Override
	public double getArea()
	{
		return 4 * PI * getRadius() * getRadius();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s:%n%s: %.2f%n%s: %.2f%n%s: %.2f",
			super.toString(), "sphere",
			"radius", getRadius(),
			"area", getArea(),
			"volume", getVolume());
	}
}