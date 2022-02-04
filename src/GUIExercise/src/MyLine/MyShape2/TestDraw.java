package MyLine.MyShape2;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class TestDraw
{
	public static void main(String[] args)
	{
		DrawPanel panel = new DrawPanel();
		JFrame app = new JFrame();
		JLabel statusBar = new JLabel(panel.labelText());
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel, BorderLayout.CENTER);
		app.add(statusBar, BorderLayout.SOUTH);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}

