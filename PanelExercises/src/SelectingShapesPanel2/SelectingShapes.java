package SelectingShapesPanel2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectingShapes
{
	public static void main(String[] args)
	{
		JFrame app = new JFrame("Selecting shapes");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SelectingShapesPanel panel = new SelectingShapesPanel();
		
		app.add(panel, BorderLayout.CENTER);
		
		JComboBox<String> comboBox = panel.getShapesJComboBox();
		JButton button = panel.getChooseColorJButton();
		
		JPanel northJPanel = new JPanel();
		northJPanel.add(button);
		northJPanel.add(new JLabel("Shape:"));
		northJPanel.add(comboBox);
		
		app.add(panel, BorderLayout.CENTER);
		app.add(northJPanel, BorderLayout.NORTH);
		
		app.setSize(500, 500);
		app.setVisible(true);
	}
}
