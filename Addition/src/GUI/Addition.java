package GUI;

import javax.swing.JOptionPane;

public class Addition
{
	public static void main(String[] args)
	{
		String firstNumber = JOptionPane.showInputDialog("Enter first integer");
		String secondNumber = JOptionPane.showInputDialog("Enter second integer");
		
		int number1 = Integer.parseInt(firstNumber);
		int number2 = Integer.parseInt(secondNumber);
		
		int sum = number1 + number2;
		String message = String.format("The sum is %d", sum);
		
		JOptionPane.showMessageDialog(null, message, 
			"Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
	}
}
