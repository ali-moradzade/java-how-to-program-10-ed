package DrawSmiley;

import javax.swing.JFrame;

public class DrawSileyTest
{
	public static void main(String[] args)
	{
		DrawSiley panel = new DrawSiley();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(230, 250);
		application.setVisible(true);
	}
}
