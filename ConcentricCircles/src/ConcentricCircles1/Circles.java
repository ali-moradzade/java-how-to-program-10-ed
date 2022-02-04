package ConcentricCircles1;

import javax.swing.JFrame;

public class Circles
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Concentric circles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CirclesPanel circlesPanel = new CirclesPanel();
		
		frame.add(circlesPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
