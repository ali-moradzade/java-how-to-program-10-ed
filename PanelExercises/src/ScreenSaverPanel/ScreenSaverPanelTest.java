package ScreenSaverPanel;

import javax.swing.JFrame;

public class ScreenSaverPanelTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Screen Saver");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ScreenSaverPanel panel = new ScreenSaverPanel();
		
		app.add(panel);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
