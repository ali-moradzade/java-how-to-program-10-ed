public class ShapeTest
{
	public static void main(String[] args)
	{
		Shape[] shapes = new Shape[5];
		
		shapes[0] = new Circle(10);
		shapes[1] = new Rectangle(10, 20);
		shapes[2] = new Square(10);
		
		shapes[3] = new Cube(10);
		shapes[4] = new Sphere(10);
		
		System.out.println("Shapes processed polymorphically:\n");
		
		for (Shape shape : shapes)
		{
			System.out.printf("%s%n%n", shape);
		}
	}
}
