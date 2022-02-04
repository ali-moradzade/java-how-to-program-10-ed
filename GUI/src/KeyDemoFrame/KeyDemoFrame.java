package KeyDemoFrame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
	private String line1 = "";
	private String line2 = "";
	private String line3 = "";
	private final JTextArea textArea;
	
	public KeyDemoFrame()
	{
		super("Demonstrating Keystroke Events");
		
		textArea = new JTextArea("Press any key on the keyboard...", 10, 15);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.black);
		add(textArea);
		
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		line1 = String.format("Key typed: %s", e.getKeyChar());
		setLine2Andline3(e);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		line1 = String.format("Key pressed: %s",
			KeyEvent.getKeyText(e.getKeyCode()));
		setLine2Andline3(e);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		line1 = String.format("Key released: %s",
			KeyEvent.getKeyText(e.getKeyCode()));
	}
	
	private void setLine2Andline3(KeyEvent e)
	{
		line2 = String.format("This key is %san action key",
			(e.isActionKey() ? "" : "not "));
		
		String temp = KeyEvent.getModifiersExText(e.getModifiersEx());
		
		line3 = String.format("Modifier keys pressed: %s",
			(temp.equals("") ? "none" : temp));
		
		textArea.setText(String.format("%s%n%s%n%s%n", line1, line2, line3));
	}
}