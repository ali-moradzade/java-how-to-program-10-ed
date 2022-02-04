package PaintPanel;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Painter
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("A simple paint program");
		PaintPanel paintPanel = new PaintPanel();
		
		app.add(paintPanel, BorderLayout.CENTER);
		app.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400, 200);
		app.setVisible(true);
	}
}
