package DrawingSpiralsPanel;

import javax.swing.JFrame;

public class DrawTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Drawing Spirals");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(new DrawingSpiralsPanel());
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
