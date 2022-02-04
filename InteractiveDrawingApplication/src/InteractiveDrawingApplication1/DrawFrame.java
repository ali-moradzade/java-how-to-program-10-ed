package InteractiveDrawingApplication1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFrame extends JFrame
{
	private final JLabel statusLabel;
	private final DrawPanel drawPanel;
	private final SpecifcFeaturesPanel specifcFeaturesPanel;
	
	private final JButton undoJButton;
	private final JButton clearJButton;

	private final JLabel shapeJLabel;
	private final JComboBox<String> shapesJComboBox;
	private static final String[] shapeNames = {"Line", "Oval", "Rectangle"};
	
	private final JCheckBox filledJCheckBox;
	
	public DrawFrame()
	{
		super("Java Drawings");
		
		statusLabel = new JLabel("(0,0)");
		drawPanel = new DrawPanel(statusLabel);
		specifcFeaturesPanel = new SpecifcFeaturesPanel(drawPanel);
		
		undoJButton = new JButton("Undo");
		undoJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					drawPanel.clearLastShape();
				}
			}
		);
		
		clearJButton = new JButton("Clear");
		clearJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					drawPanel.clearDrawing();
				}
			}
		);
		
		shapeJLabel = new JLabel("Shape: ");
		
		shapesJComboBox = new JComboBox<>(shapeNames);
		shapesJComboBox.setMaximumRowCount(5);
		shapesJComboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						
						drawPanel.setShapeType(shapesJComboBox.getSelectedIndex());
					}
				}
			}
		);
		
		filledJCheckBox = new JCheckBox("Filled", false);
		filledJCheckBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					drawPanel.setFilledShape(filledJCheckBox.isSelected());
				}
			}
		);
		
		JPanel northJPanel = new JPanel(new GridLayout(2, 1));
		
		JPanel top = new JPanel();
		top.add(undoJButton);
		top.add(clearJButton);
		top.add(shapeJLabel);
		top.add(shapesJComboBox);
		top.add(filledJCheckBox);
		
		northJPanel.add(top);
		northJPanel.add(specifcFeaturesPanel);
		
		add(northJPanel, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);
	}
}
