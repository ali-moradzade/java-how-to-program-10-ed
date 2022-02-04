package FileMatching;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch
{
	private static Scanner inOldMaster;
	private static Scanner inTransaction;
	private static Formatter outNewMaster;
	private static Formatter outLog;
	
	public static void openOldMaster()
	{
		try
		{
			inOldMaster = new Scanner(Paths.get("oldmast.txt"));
		}
		catch (IOException iOException)
		{
			System.err.println("Error opening  oldmast.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void closeOldMaster()
	{
		if (inOldMaster != null)
			inOldMaster.close();
	}
	
	public static void openTransaction()
	{
		try
		{
			inTransaction = new Scanner(Paths.get("trans.txt"));
		}
		catch (IOException iOException)
		{
			System.err.println("Error opening trans.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void closeTransaction()
	{
		if (inTransaction != null)
			inTransaction.close();
	}
	
	public static void openNewMastetr()
	{
		try
		{
			outNewMaster = new Formatter("newmast.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for newmast.txt file. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening newmast.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void closeNewMaster()
	{
		if (outNewMaster != null)
			outNewMaster.close();
	}
	
	public static void openLog()
	{
		try
		{
			outLog = new Formatter("log.txt");
		}
		catch (SecurityException securityException)
		{
			System.err.println(
				"Write permission denied for log.txt file. Terminating.");
			System.exit(1);
		}
		catch (FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening log.txt file. Terminating.");
			System.exit(1);
		}
	}
	
	public static void closeLog()
	{
		if (outLog != null)
			outLog.close();
	}
	
	public static void addRecordsToNewMaster()
	{
		openOldMaster();
		
		try
		{
			while (inOldMaster.hasNext())
			{
				Account account = new Account(inOldMaster.nextInt(), 
					inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
				
				openTransaction();
				boolean isIn = false;
				
				try
				{
					while (inTransaction.hasNext())
					{
						TransactionRecord transaction =
							new TransactionRecord(inTransaction.nextInt(), 
								inTransaction.nextDouble());
						
						if (transaction.getAccountNumber() == account.getAccount())
						{
							account.combine(transaction);
							outNewMaster.format("%d %s %s %.2f%n",
								account.getAccount(), account.getFirstName(),
								account.getLastName(), account.getBalance());
							isIn = true;
						}
					}
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println(
						"File (trans.txt) improperly formed. Terminating.");
					System.exit(1);
				}
				catch (IllegalStateException stateException)
				{
					System.err.println(
						"Error reading from trans.txt file. Terminating.");
					System.exit(1);
				}
				
				if (isIn == false)
				{
					outNewMaster.format("%d %s %s %.2f%n",
						account.getAccount(), account.getFirstName(),
						account.getLastName(), account.getBalance());
				}
				
				closeTransaction();
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File (oldmast.txt) improperly formed. Terminating.");
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println(
				"Error reading from oldmast.txt file. Terminating.");
			System.exit(1);
		}
		
		closeOldMaster();
	}
	
	public static void addRecordsToLog()
	{
		openTransaction();
		
		try
		{
			while (inTransaction.hasNext())
			{
				TransactionRecord transaction = 
					new TransactionRecord(inTransaction.nextInt(), 
						inTransaction.nextDouble());
				
				openOldMaster();
				boolean shouldWrite = true;
				
				try
				{
					while (inOldMaster.hasNext())
					{
						Account account = new Account(inOldMaster.nextInt(), 
							inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
						
						if (account.getAccount() == transaction.getAccountNumber())
						{
							shouldWrite = false;
							break;
						}
					}
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println(
						"File (oldmast.txt) improperly formed. TErminating.");
					System.exit(1);
				}
				catch (IllegalStateException stateException)
				{
					System.err.println(
						"Error reading from oldmast.txt file. Terminating.");
					System.exit(1);
				}
				
				if (shouldWrite)
				{
					outLog.format(
						"Unmatched transaction record for account number %d %n", 
						transaction.getAccountNumber());
				}
				
				closeOldMaster();
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println(
				"File (trans.txt) improperly formed. TErminating.");
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println(
				"Error reading from trans.txt file. Terminating.");
			System.exit(1);
		}
		
		closeTransaction();
	}
	
	public static void main(String[] args)
	{
		openNewMastetr();
		openLog();
		
		addRecordsToNewMaster();
		addRecordsToLog();
		
		closeNewMaster();
		closeLog();
	}
}

