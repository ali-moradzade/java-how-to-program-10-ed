public class ComplexNumbers
{
	private double realPart;
	private double imaginaryPart;
	
	public ComplexNumbers()
	{
		this(0, 0);
	}
	
	public ComplexNumbers(double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public double getRealPart()
	{
		return realPart;
	}
	
	public double getImaginaryPart()
	{
		return imaginaryPart;
	}
	
	public ComplexNumbers add(ComplexNumbers number)
	{
		return new ComplexNumbers(
			getRealPart() + number.getRealPart(),
			getRealPart() + number.getRealPart());
	}
	
	public ComplexNumbers subtract(ComplexNumbers number)
	{
		return new ComplexNumbers(
			getRealPart() - number.getRealPart(),
			getRealPart() - number.getRealPart());
	}
	
	@Override
	public String toString()
	{
		return String.format("(%.2f, %.2f)", getRealPart(), getImaginaryPart());
	}
}
