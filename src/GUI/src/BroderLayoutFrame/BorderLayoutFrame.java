package BroderLayoutFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutFrame extends JFrame implements ActionListener
{
	private final JButton[] buttons;
	private static final String[] names = {"Hide North", "Hide South", "Hide East",
		"Hide West", "Hide Center"};
	private final BorderLayout layout;
	
	public BorderLayoutFrame()
	{
		super("BorderLayout Demo");
		
		layout = new BorderLayout(5, 5);
		buttons = new JButton[names.length];
		
		for (int counter = 0; counter < names.length; counter++)
		{
			buttons[counter] = new JButton(names[counter]);
			buttons[counter].addActionListener(this);
		}
		
		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.EAST);
		add(buttons[3], BorderLayout.WEST);
		add(buttons[4], BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for (JButton button : buttons)
		{
			if (e.getSource() == button)
				button.setVisible(false);
			else
				button.setVisible(true);
		}
		
		layout.layoutContainer(getContentPane());
	}
}
