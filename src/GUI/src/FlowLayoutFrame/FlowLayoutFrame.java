package FlowLayoutFrame;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame
{
	private final JButton leftJButton;
	private final JButton centerJButton;
	private final JButton rightJButton;
	private final FlowLayout layout;
	private final Container container;
	
	public FlowLayoutFrame()
	{
		super("FlowLayout Demo");
		
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		
		leftJButton = new JButton("Left");
		leftJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					layout.setAlignment(FlowLayout.LEFT);
					layout.layoutContainer(container);
				}
			}
		);
		
		add(leftJButton);
		
		centerJButton = new JButton("Center");
		centerJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					layout.setAlignment(FlowLayout.CENTER);
					layout.layoutContainer(container);
				}
			}
		);
		
		add(centerJButton);
		
		rightJButton = new JButton("Right");
		rightJButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					layout.setAlignment(FlowLayout.RIGHT);
					layout.layoutContainer(container);
				}
			}
		);
		
		add(rightJButton);
	}
}