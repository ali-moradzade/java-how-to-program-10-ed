package DrawingSpiralsPanel.square;

import javax.swing.JFrame;

public class DrawRainbowTest
{
	public static void main(String[] args)
	{
		SquareSpiral panel = new SquareSpiral();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(500, 500);
		application.setVisible(true);
	}
}