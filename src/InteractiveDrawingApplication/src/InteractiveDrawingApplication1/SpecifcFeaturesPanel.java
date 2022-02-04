package InteractiveDrawingApplication1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpecifcFeaturesPanel extends JPanel
{
	private final DrawPanel drawPanel;
	
	private Color color1;
	private Color color2;
	
	private final JCheckBox useGradientJCheckBox;
	
	private final JButton color1JButton;
	private final JButton color2JButton;
	
	private final JLabel lineWidthJLabel;
	private final JTextField lineWidthJTextField;
	
	private final JLabel dashLengthJLabel;
	private final JTextField dashLengthJTextField;
	
	private final JCheckBox dashedJCheckBox;
	
	private Stroke originalStroke;
	
	public SpecifcFeaturesPanel(DrawPanel drawPanel)
	{
		this.drawPanel = drawPanel;
		
		originalStroke = new BasicStroke();
		color1 = Color.black;
		color1 = Color.black;
		
		useGradientJCheckBox = new JCheckBox("Using Gradient");
		useGradientJCheckBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (useGradientJCheckBox.isSelected())
					{
						drawPanel.setCurrentPaint(new GradientPaint(0, 0, color1, 
							50, 50, color2, true));
					}
					else
						drawPanel.setCurrentPaint(color1);
				}
			}
		);
		
		color1JButton = new JButton("1st Color...");
		color1JButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					color1 = JColorChooser.showDialog(SpecifcFeaturesPanel.this,
						"Choose a color", color1);
					
					if (color1 == null)
						color1 = Color.lightGray;
					
					if (useGradientJCheckBox.isSelected() == false)
						drawPanel.setCurrentPaint(color1);
				}
			}
		);
		
		color2JButton = new JButton("2st Color...");
		color2JButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					color2 = JColorChooser.showDialog(SpecifcFeaturesPanel.this,
						"Choose a color", color2);
					
					if (color2 == null)
						color2 = Color.lightGray;
					
					drawPanel.setCurrentPaint(new GradientPaint(0, 0, color1, 
						50, 50, color2, true));
					useGradientJCheckBox.setSelected(true);
				}
			}
		);
		
		lineWidthJLabel = new JLabel("Line Width: ");
		
		lineWidthJTextField = new JTextField(2);
		lineWidthJTextField.setText("1");
		lineWidthJTextField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						originalStroke = 
							new BasicStroke(Integer.parseInt(lineWidthJTextField.getText()),
							BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
						
						drawPanel.setCurrentStroke(originalStroke);
					}
					catch (Exception exception)
					{
					}
				}
			}
		);
		
		dashLengthJLabel = new JLabel("Dash Length: ");
		
		dashLengthJTextField = new JTextField(3);
		dashLengthJTextField.setText("1");
		dashLengthJTextField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						float[] dashes = {Float.parseFloat(dashLengthJTextField.getText())};

						drawPanel.setCurrentStroke(
							new BasicStroke(Integer.parseInt(lineWidthJTextField.getText()), 
							BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
							10, dashes, 0));
						
						dashedJCheckBox.setSelected(true);
					}
					catch (Exception exception)
					{
					}
				}
			}
		);
		
		dashedJCheckBox = new JCheckBox("Dashed");
		dashedJCheckBox.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (dashedJCheckBox.isSelected())
					{
						try
						{
							float[] dashes = {Float.parseFloat(dashLengthJTextField.getText())};

							drawPanel.setCurrentStroke(
								new BasicStroke(Integer.parseInt(lineWidthJTextField.getText()), 
								BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
								10, dashes, 0));

						}
						catch (Exception exception)
						{
						}
					}
					else
						drawPanel.setCurrentStroke(originalStroke);
				}
			}
		);
		
		add(useGradientJCheckBox);
		add(color1JButton);
		add(color2JButton);
		add(lineWidthJLabel);
		add(lineWidthJTextField);
		add(dashLengthJLabel);
		add(dashLengthJTextField);
		add(dashedJCheckBox);
	}
	
	private void setDash(ActionEvent e)
	{
		
	}
}
