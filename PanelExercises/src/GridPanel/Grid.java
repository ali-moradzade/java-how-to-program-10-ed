package GridPanel;

import javax.swing.JFrame;

public class Grid
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Displaying Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridPanel gridPanel = new GridPanel();
		//Grid2JPanel grid2Panel = new Grid2JPanel();
		
		frame.add(gridPanel);
		//frame.add(grid2Panel);
		
		frame.setSize(8 * 100, 8 * 100);
		frame.setVisible(true);
	}
}
