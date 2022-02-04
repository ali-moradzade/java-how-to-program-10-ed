package RandomTrianglesPanel;

import javax.swing.JFrame;

public class RandomTriangles
{
	public static void main(String[] args)
	{
		JFrame app =
			new JFrame("Random Triangles with different sizes and thicknesses");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RandomTrianglesPanel randomTrianglesPanel = new RandomTrianglesPanel();
		
		app.add(randomTrianglesPanel);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
