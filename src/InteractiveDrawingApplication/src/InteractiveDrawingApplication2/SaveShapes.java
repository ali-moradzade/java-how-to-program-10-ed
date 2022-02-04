package InteractiveDrawingApplication2;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JFileChooser;

public class SaveShapes
{
	private final MyShape[] shapes;
	private static Path path;
	private static ObjectOutputStream output;
	
	public SaveShapes(MyShape[] shapes)
	{
		this.shapes = shapes;
	}
	
	public void save()
	{
		setDirectoryPath();
		
		while (path == null)
		{
			setDirectoryPath();
		}
		
		openFile();
		addRecords();
		closeFile();
	}

	private void setDirectoryPath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		path = fileChooser.getSelectedFile().toPath();
	}
	
	private void openFile()
	{
		try
		{
			output = new ObjectOutputStream(
				Files.newOutputStream(Paths.get(path + File.separator + "save.ser")));
		}
		catch (IOException e)
		{
			System.err.printf("Error opening \"%s\". Terminating.", 
				path + File.separator + "save.ser");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private void addRecords()
	{
		try
		{
			output.writeObject(shapes);
		}
		catch (IOException ex)
		{
			System.err.printf("Error writing \"%s\" to file.", 
				Arrays.toString(shapes));
			ex.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private void closeFile()
	{
		try
		{
			if (output != null)
				output.close();
		}
		catch (IOException e)
		{
			System.err.printf("Error closing \"%s\". Terminating.", path);
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
}
