package messageTypes;

import javax.swing.JOptionPane;

public class MessageDialogType
{
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "error type", 
			"Error Type", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "information message", 
			"Information Message", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "warning message", 
			"Warning Message", JOptionPane.WARNING_MESSAGE);;
		JOptionPane.showMessageDialog(null, "question message",
			"Question Message", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "plain message",
			"Plain Messeage", JOptionPane.PLAIN_MESSAGE);
	}
}
