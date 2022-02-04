package TemperateConversionPro;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Frame extends JFrame
{
	private final JLabel fahrenheitJLabel;
	private final JTextField fahrenheitJTextField;
	private final JLabel celsiusJLabel;
	private final JTextField celsiusJTextField;
	private final JLabel kelvinJLabel;
	private final JTextField kelvinJTextField;
	
	public Frame()
	{
		super("Temperate Conversion");
		setLayout(new FlowLayout());
		
		fahrenheitJLabel = new JLabel("Fahrenheit: ");
		fahrenheitJTextField = new JTextField(10);
		fahrenheitJTextField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						double fahrenheit = Double.parseDouble(
							fahrenheitJTextField.getText());
						
						double celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
						double kelvin = celsius + 273.5;

						celsiusJTextField.setText(Double.toString(celsius));
						kelvinJTextField.setText(Double.toString(kelvin));
					}
					catch (Exception exception)
					{
						System.err.println(exception);
						exception.printStackTrace(System.err);
					}
				}
			}
		);
		
		add(fahrenheitJLabel);
		add(fahrenheitJTextField);
		
		celsiusJLabel = new JLabel("Celsius: ");
		celsiusJTextField = new JTextField(10);
		celsiusJTextField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						double celsius = Double.parseDouble(
							celsiusJTextField.getText());
						
						double fahrenheit = 9.0 / 5.0 * celsius + 32.0;
						double kelvin = celsius + 273.5;

						fahrenheitJTextField.setText(Double.toString(fahrenheit));
						kelvinJTextField.setText(Double.toString(kelvin));
					}
					catch (Exception exception)
					{
						System.err.println(exception);
						exception.printStackTrace(System.err);
					}
				}
			}
		);

		add(celsiusJLabel);
		add(celsiusJTextField);
		
		kelvinJLabel = new JLabel("Kelvin: ");
		kelvinJTextField = new JTextField(10);
		kelvinJTextField.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						double kelvin = Double.parseDouble(
							kelvinJTextField.getText());
						
						double celsius = kelvin - 273.5;
						double fahrenheit = 9.0 / 5.0 * celsius + 32.0;

						celsiusJTextField.setText(Double.toString(celsius));
						fahrenheitJTextField.setText(Double.toString(fahrenheit));
					}
					catch (Exception exception)
					{
						System.err.println(exception);
						exception.printStackTrace(System.err);
					}
				}
			}
		);
		
		add(kelvinJLabel);
		add(kelvinJTextField);
	}
}
