package LinesRectsOvalsJPanel;

import javax.swing.JFrame;

public class LinesRectsOvals
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Drawing lines, rectangels and ovals");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LinesRectsOvalsJPanel panel = new LinesRectsOvalsJPanel();
		
		frame.add(panel);
		frame.setSize(400, 210);
		frame.setVisible(true);
	}
}
