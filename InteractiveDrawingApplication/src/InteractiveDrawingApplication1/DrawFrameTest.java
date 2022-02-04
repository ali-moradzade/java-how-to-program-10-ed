package InteractiveDrawingApplication1;

import javax.swing.JFrame;

public class DrawFrameTest
{
	public static void main(String[] args)
	{
		DrawFrame drawFrame = new DrawFrame();
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setSize(650, 500);
		drawFrame.setVisible(true);
	}
}
