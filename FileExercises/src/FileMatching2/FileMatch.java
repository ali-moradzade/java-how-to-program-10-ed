package FileMatching2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;

public class FileMatch
{
	private static ObjectInputStream inOldMaster;
	private static ObjectInputStream inTransaction;
	
	private static Formatter outNewMaster;
	private static Formatter outLog;
	
	private static void openOldMaster()
	{
		try
		{
			inOldMaster = new ObjectInputStream(
				Files.newInputStream(Paths.get("oldmast.ser")));
		}
		catch (IOException e)
		{
			System.err.println("Error writing to \"oldmast.txt\" file. Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void closeOldMaster()
	{
		try
		{
			if (inOldMaster != null)
				inOldMaster.close();
		}
		catch (IOException e)
		{
			System.err.println("Error closing \"oldmast.ser\". Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void openTransaction()
	{
		try
		{
			inTransaction = new ObjectInputStream(
				Files.newInputStream(Paths.get("trans.ser")));
		}
		catch (IOException e)
		{
			System.err.println("Error writing to \"trans.ser\" file. Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void closeTransaction()
	{
		try
		{
			if (inTransaction != null)
				inTransaction.close();
		}
		catch (IOException e)
		{
			System.err.println("Error closing \"trans.ser\". Terminating,");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void openNewMaster()
	{
		try
		{
			outNewMaster = new Formatter("newmast.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission for \"newmast.txt\" denied. Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening \"newmast.txt\" file. Terminating.");
			fileNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void closeNewMaster()
	{
		if (outNewMaster != null)
			outNewMaster.close();
	}
	
	private static void openLog()
	{
		try
		{
			outLog = new Formatter("log.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission for \"log.txt\" denied. Terminating.");
			securityException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening \"log.txt\" file. Terminating.");
			fileNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void closeLog()
	{
		if (outLog != null)
			outLog.close();
	}
	
	public static void addRecordsToNewMaster()
	{
		openOldMaster();
		
		try
		{
			while (true)
			{
				Account account = (Account) inOldMaster.readObject();
				openTransaction();
				boolean hadTransaction = false;
				
				try
				{
					TransactionRecord previousTransaction = null;

					while (true)
					{
						TransactionRecord transaction = 
							(TransactionRecord) inTransaction.readObject();

						if (previousTransaction != null && 
							previousTransaction.getAccountNumber() == account.getAccount())
						{
							hadTransaction = true;
							account.combine(previousTransaction);

							if (previousTransaction.getAccountNumber() != 
								transaction.getAccountNumber())
							{
								outNewMaster.format("%d %s %s %,.2f%n", 
									account.getAccount(),
									account.getFirstName(), account.getLastName(),
									account.getBalance());
								break;
							}
						}
						
						previousTransaction = transaction;
					}
				}
				catch (EOFException eOFException)
				{
					
				}
				catch (ClassNotFoundException classNotFoundException)
				{
					System.err.println("Invalid object type. Terminating.");
					classNotFoundException.printStackTrace(System.out);
					System.exit(1);
				}
				catch (IOException iOException)
				{
					System.err.println(
						"Error reading from \"trans.ser\". Terminating.");
					iOException.printStackTrace(System.out);
					System.exit(1);
				}
				finally
				{
					closeTransaction();
				}
				
				if (!hadTransaction)
				{
					outNewMaster.format("%d %s %s %,.2f%n", 
						account.getAccount(),
						account.getFirstName(), account.getLastName(),
						account.getBalance());
				}
			}
		}
		catch (EOFException eOFException)
		{

		}
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
			classNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (IOException iOException)
		{
			System.err.println(
				"Error reading from \"oldmast.ser\". Terminating.");
			iOException.printStackTrace(System.out);
			System.exit(1);
		}
		finally
		{
			closeOldMaster();
		}
	}
	
	public static void addRecordsToLog()
	{
		openTransaction();
		
		try
		{
			while (true)
			{
				TransactionRecord transaction = 
					(TransactionRecord) inTransaction.readObject();
				
				boolean hadTransaction = false;
				
				openOldMaster();
				
				try
				{
					while (true)
					{
						Account account = (Account) inOldMaster.readObject();
						
						if (account.getAccount() == transaction.getAccountNumber())
						{
							hadTransaction = true;
						}
					}
					
				}
				catch (EOFException eOFException)
				{
					
				}
				catch (ClassNotFoundException classNotFoundException)
				{
					System.err.println("Invalid object type. Terminating.");
					classNotFoundException.printStackTrace(System.out);
					System.exit(1);
				}
				catch (IOException iOException)
				{
					System.err.println(
						"Error reading from \"oldmast.ser\". Terminating.");
					iOException.printStackTrace(System.out);
					System.exit(1);
				}
				finally
				{
					closeOldMaster();
				}
				
				if (!hadTransaction)
				{
					outLog.format(
						"Unmatched transaction record for account number %d (%,.2f)%n",
						transaction.getAccountNumber(), transaction.getAmount());
				}
			}
		}
		catch (EOFException eOFException)
		{

		}
		catch (ClassNotFoundException classNotFoundException)
		{
			System.err.println("Invalid object type. Terminating.");
			classNotFoundException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (IOException iOException)
		{
			System.err.println(
				"Error reading from \"trans.ser\". Terminating.");
			iOException.printStackTrace(System.out);
			System.exit(1);
		}
		finally
		{
			closeTransaction();
		}
	}
	
	public static void main(String[] args)
	{
		openNewMaster();
		openLog();
		
		addRecordsToNewMaster();
		addRecordsToLog();
		
		closeNewMaster();
		closeLog();
	}
}
