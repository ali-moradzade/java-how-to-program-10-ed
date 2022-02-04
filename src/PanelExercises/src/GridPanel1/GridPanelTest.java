package GridPanel1;

import javax.swing.JFrame;

public class GridPanelTest
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Creating Grid with rectangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridPanel gridPanel = new GridPanel();
		
		frame.add(gridPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
