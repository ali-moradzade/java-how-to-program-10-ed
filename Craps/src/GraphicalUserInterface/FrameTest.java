package GraphicalUserInterface;

import javax.swing.JFrame;

public class FrameTest
{
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}