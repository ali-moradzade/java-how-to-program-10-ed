package DrawRainBowPanel;

import javax.swing.JFrame;

public class DrawRainbowTest
{
	public static void main(String[] args)
	{
		DrawRainbowPanel panel = new DrawRainbowPanel();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(400, 250);
		application.setVisible(true);
	}
}