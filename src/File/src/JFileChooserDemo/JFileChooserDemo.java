package JFileChooserDemo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChooserDemo extends JFrame
{
	private final JTextArea outputArea;
	
	public JFileChooserDemo() throws IOException
	{
		super("JFileChooser Demo");
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		
		add(new JScrollPane(outputArea));
		analysizePath();
	}
	
	public void analysizePath() throws IOException
	{
		Path path = getFileOrDirectoryPath();
		
		if (path != null)
		{
			if (Files.exists(path))
			{
				StringBuilder builder = new StringBuilder();
				builder.append(String.format("%s:%n", path.getFileName()))
						 .append(String.format("%s a directory%n",
							 Files.isDirectory(path) ? "Is" : "Is not"))
						 .append(String.format("%s an absolute path%n",
							 path.isAbsolute() ? "Is" : "Is not"))
						 .append(String.format("Last modified: %s%n",
							 Files.getLastModifiedTime(path)))
						 .append(String.format("Size: %s%n", Files.size(path)))
						 .append(String.format("Path: %s%n", path))
						 .append(String.format("Absolute path: %s%n",
							 path.toAbsolutePath()));

				if (Files.isDirectory(path))
				{
					builder.append(String.format("%nDirectory contents:%n"));

					DirectoryStream<Path> directoryStream = 
						Files.newDirectoryStream(path);

					for (Path p : directoryStream)
					{
						builder.append(String.format("%s%n", p));
					}
				}

				outputArea.setText(builder.toString());
			}
			else
				JOptionPane.showMessageDialog(this, path.getFileName() +
					" does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private Path getFileOrDirectoryPath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		return fileChooser.getSelectedFile().toPath();
	}
}
