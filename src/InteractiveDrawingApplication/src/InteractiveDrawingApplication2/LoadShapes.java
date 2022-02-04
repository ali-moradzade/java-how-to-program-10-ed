package InteractiveDrawingApplication2;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

public class LoadShapes
{
	private MyShape[] shapes;
	private int shapeCount;
	private static Path path;
	private static ObjectInputStream input;
	
	public LoadShapes()
	{
		shapes = new MyShape[100];
		shapeCount = 0;
	}
	
	public MyShape[] load()
	{
		setDirectoryPath();
		
		while (path == null)
		{
			setDirectoryPath();
		}
		
		openFile();
		readRecords();
		closeFile();
		
		return shapes;
	}
	
	public int getShapeCount()
	{
		setShapeCount();
		
		return shapeCount;
	}
	
	private void setDirectoryPath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		path = fileChooser.getSelectedFile().toPath();
	}
	
	private void openFile()
	{
		try
		{
			input = new ObjectInputStream(
				Files.newInputStream(Paths.get(path.toString())));
		}
		catch (IOException e)
		{
			System.err.printf("Error opening \"%s\". Terminating.",
				path + File.separator + "save.ser");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private void readRecords()
	{
		try
		{
			shapes = (MyShape[]) input.readObject();
		}
		catch (EOFException endOfFileException)
		{
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
		}
		catch (IOException iOException)
		{
			System.err.printf("Error reading from \"%s\". Terminating.", path);
		}
	}
	
	private void closeFile()
	{
		try
		{
			if (input != null)
				input.close();
		}
		catch (IOException e)
		{
			System.err.printf("Error closing \"%s\". Terminating.", path);
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private void setShapeCount()
	{
		shapeCount = 0;
		
		for (MyShape shape : shapes)
		{
			if (shape == null)
				break;
			
			shapeCount++;
		}
	}
}
