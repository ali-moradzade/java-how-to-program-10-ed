package MyLine.Oval;

import javax.swing.JFrame;

public class TestDraw
{
	public static void main(String[] args)
	{
		DrawPenl panel = new DrawPenl();
		JFrame app = new JFrame();
		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(300, 300);
		app.setVisible(true);
	}
}

