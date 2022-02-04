package CubesPanel;

import javax.swing.JFrame;

public class CubsPanelTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Drawing Cubs");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CubesPanel cubesPanel = new CubesPanel(10, 30, 100, 200, 50, 150);
		
		app.add(cubesPanel);
		app.setSize(400, 400);
		app.setVisible(true);
	}
}
