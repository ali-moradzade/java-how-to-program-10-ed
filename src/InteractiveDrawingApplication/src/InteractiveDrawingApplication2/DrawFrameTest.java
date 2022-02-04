package InteractiveDrawingApplication2;

import javax.swing.JFrame;

public class DrawFrameTest
{
	public static void main(String[] args)
	{
		DrawFrame drawFrame = new DrawFrame();
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setSize(500, 500);
		drawFrame.setVisible(true);
	}
}
