package SelectingShapesPanel1;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SelectingShapes
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Selecting shapes");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SelectingShapesPanel panel = new SelectingShapesPanel();
		
		app.add(panel, BorderLayout.CENTER);
		app.add(panel.getComboBox(), BorderLayout.NORTH);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
