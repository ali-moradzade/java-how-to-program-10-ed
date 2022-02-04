package ComboBoxFrame;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame
{
	private final JComboBox<String> imagesJComboBox;
	private final JLabel label;
	
	public ComboBoxFrame()
	{
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		
		String[] names = {"bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif"};
		Icon[] icons = new Icon[names.length];
		
		for (int i = 0; i < names.length; i++)
			icons[i] = new ImageIcon(getClass().getResource(names[i]));
		
		imagesJComboBox = new JComboBox<>(names);
		imagesJComboBox.setMaximumRowCount(3);
		imagesJComboBox.addItemListener(
			new ItemListener()
			{
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
					}
				}
			}
		);
		
		add(imagesJComboBox);
		
		label = new JLabel(icons[0]);
		add(label);
	}
}
