package MouseDetailsFrame;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame
{
	private String details;
	private final JLabel statusBar;
	
	public MouseDetailsFrame()
	{
		super("Mouse clicks and buttons");
		
		statusBar = new JLabel("Click the mouse");
		add(statusBar, BorderLayout.SOUTH);
		addMouseListener(new MouseClickHandler());
	}
	
	private class MouseClickHandler extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			details = String.format("Clicked %d time(s)", e.getClickCount());
			
			if (e.isMetaDown())
				details += " with right mouse button";
			else if (e.isAltDown())
				details += " with center mouse button";
			else
				details += " with left mouse button";
			
			statusBar.setText(details);
		}
	}
}