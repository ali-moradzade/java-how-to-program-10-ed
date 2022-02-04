package ColorJPanel.two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.JButton;

public class ShowColorsJFrame extends JFrame
{
	private final JButton changeColorJButton;
	private Color color = Color.lightGray;
	private final JPanel colorJPanel;
	
	public ShowColorsJFrame()
	{
		super("Using JColorChooser");
		
		colorJPanel = new JPanel();
		colorJPanel.setBackground(color);
		
		changeColorJButton = new JButton("Change Color");
		changeColorJButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					color = JColorChooser.showDialog(ShowColorsJFrame.this,
						"Choose a color", color);
					
					if (color == null)
						color = Color.lightGray;
					
					colorJPanel.setBackground(color);
				}
			}
		);
		
		add(colorJPanel, BorderLayout.CENTER);
		add(changeColorJButton, BorderLayout.SOUTH);
		
		setSize(400, 130);
		setVisible(true);
	}
}
