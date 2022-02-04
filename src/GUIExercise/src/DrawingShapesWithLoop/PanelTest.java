package DrawingShapesWithLoop;

import javax.swing.JFrame;

public class PanelTest
{
	public static void main(String[] args)
	{
		Panel panel = new Panel();
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(250, 250);
		application.setVisible(true);
	}
}
