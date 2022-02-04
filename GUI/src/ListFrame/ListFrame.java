package ListFrame;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame
{
	private final JList<String> colorJList;
	private static final String[] colorNames = {"Black", "Blue", "Cyan",
		"Dark Gray", "Gray", "Green", "Light Gray", "Megenta", "Orange", "Pink", 
		"Red", "White", "Yellow"};
	private static final Color[] colors = {Color.black, Color.blue, Color.cyan, 
		Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta,
		Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
		
	public ListFrame()
	{
		super("List Test");
		setLayout(new FlowLayout());
		
		colorJList = new JList<>(colorNames);
		colorJList.setVisibleRowCount(5);
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colorJList.addListSelectionListener(
			new ListSelectionListener()
			{
				@Override
				public void valueChanged(ListSelectionEvent e)
				{
					getContentPane().setBackground(
						colors[colorJList.getSelectedIndex()]);
				}
			}
		);
		
		add(new JScrollPane(colorJList));
	}
}
