package ScreenSaverPanel2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ScreenSaverPanelTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Screen Saver");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textField = new JTextField();
		ScreenSaverPanel panel = new ScreenSaverPanel(textField);
		
		app.add(panel, BorderLayout.CENTER);
		app.add(textField, BorderLayout.SOUTH);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}