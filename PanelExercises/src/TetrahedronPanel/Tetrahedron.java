package TetrahedronPanel;

import javax.swing.JFrame;

public class Tetrahedron
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Drawing Tetrahedron");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TetrahedronPanel panel = new TetrahedronPanel();
		
		frame.add(panel);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}