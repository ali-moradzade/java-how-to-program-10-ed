package CirclesPanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CirclePanelTest
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Draw Cirecles");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CirclesPanel circlesPanel = new CirclesPanel(
			Integer.parseInt(JOptionPane.showInputDialog("Enter center x")), 
			Integer.parseInt(JOptionPane.showInputDialog("Enter center y")),
			Integer.parseInt(JOptionPane.showInputDialog("Enter radius")));
		
		app.add(circlesPanel);
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
