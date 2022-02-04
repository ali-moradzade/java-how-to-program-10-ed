package PropertiesTest;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest
{
	public static void main(String[] args)
	{
		Properties table = new Properties();
		
		table.setProperty("color", "blue");
		table.setProperty("width", "200");
		
		System.out.println("After setting properties");
		listProperties(table);
		
		table.setProperty("color", "red");
		
		System.out.println("After replacing properties");
		listProperties(table);
		
		saveProperties(table);
		
		table.clear();
		
		System.out.println("After clearing properties");
		listProperties(table);
		
		loadProperties(table);
		
		Object value = table.getProperty("color");

		if (value != null)
			System.out.printf("Property color's value is %s%n", value);
		else
			System.out.println("Property color is not in talbe");
	}
	
	private static void saveProperties(Properties props)
	{
		try (FileOutputStream output = new FileOutputStream("props.dat"))
		{
			props.store(output, "Sample Properties");
			System.out.println("After saving properties");
			listProperties(props);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	private static void loadProperties(Properties props)
	{
		try (FileInputStream input = new FileInputStream("props.dat"))
		{
			props.load(input);
			System.out.println("After loading properties");
			listProperties(props);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	private static void listProperties(Properties props)
	{
		Set<Object> keys = props.keySet();
		
		for (Object key : keys)
		{
			System.out.printf("%s\t%s%n", key, props.getProperty((String) key));
		}
		
		System.out.println();
	}
}