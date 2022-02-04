package GUI;

import javax.swing.JOptionPane;

public class Addition1
{
	public static void main(String[] args)
	{
		String number1String = JOptionPane.showInputDialog("Enter first integer");
		String number2String = JOptionPane.showInputDialog("Enter second intger");
		
		int number1 = Integer.parseInt(number1String);
		int number2 = Integer.parseInt(number2String);
		
		int sum = number1 + number2;
		
		JOptionPane.showMessageDialog(null, "Sum is " + sum);
	}
}
