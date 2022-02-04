package ConcentricCircles2;

import javax.swing.JFrame;

public class Circles
{
	public static void main(String[] args)
	{
		JFrame application = new JFrame("Concentrice circles with Ellipse2D");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CirclesPanel circlesPanel = new CirclesPanel();
		
		application.add(circlesPanel);
		application.setSize(500, 500);
		application.setVisible(true);
	}
}
