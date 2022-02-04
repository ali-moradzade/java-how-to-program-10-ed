package FileMatching1;

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
	
	private static void openOldMaster()
	{
		try
		{
			inOldMaster = new Scanner(Paths.get("oldmast.txt"));
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
		if (inOldMaster != null)
			inOldMaster.close();
	}
	
	private static void openTransaction()
	{
		try
		{
			inTransaction = new Scanner(Paths.get("trans.txt"));
		}
		catch (IOException e)
		{
			System.err.println("Error writing to \"trans.txt\" file. Terminating.");
			e.printStackTrace(System.out);
			System.exit(1);
		}
	}
	
	private static void closeTransaction()
	{
		if (inTransaction != null)
			inTransaction.close();
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
			while (inOldMaster.hasNext())
			{
				Account account = new Account(inOldMaster.nextInt(), inOldMaster.next(), 
					inOldMaster.next(), inOldMaster.nextDouble());

				openTransaction();
				
				try
				{
					boolean hadTransaction = false;
					TransactionRecord previousTransaction = null;

					while (inTransaction.hasNext())
					{
						TransactionRecord transaction = 
							new TransactionRecord(inTransaction.nextInt(), 
								inTransaction.nextDouble());

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

					if (!hadTransaction)
					{
						outNewMaster.format("%d %s %s %,.2f%n", 
							account.getAccount(),
							account.getFirstName(), account.getLastName(),
							account.getBalance());
					}
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println(
						"File \"trans.txt\" formed improperly. Terminating.");
					elementException.printStackTrace(System.out);
					System.exit(1);
				}
				catch (IllegalStateException stateException)
				{
					System.err.println("Error reading from \"trans.txt\". Terminating.");
					stateException.printStackTrace(System.out);
					System.exit(1);
				}
				finally
				{
					closeTransaction();
				}
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println(
				"File \"oldmast.txt\" formed improperly. Terminating.");
			elementException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from \"oldmast.txt\". Terminating.");
			stateException.printStackTrace(System.out);
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
			while (inTransaction.hasNext())
			{
				TransactionRecord transaction = new TransactionRecord(
					inTransaction.nextInt(), inTransaction.nextDouble());
				
				boolean hadTransaction = false;
				
				openOldMaster();
				
				try
				{
					while (inOldMaster.hasNext())
					{
						Account account = new Account(inOldMaster.nextInt(), 
							inOldMaster.next(), inOldMaster.next(), 
							inOldMaster.nextDouble());
						
						if (account.getAccount() == transaction.getAccountNumber())
						{
							hadTransaction = true;
						}
					}
					
					if (!hadTransaction)
					{
						outLog.format(
							"Unmatched transaction record for account number %d (%,.2f)%n",
							transaction.getAccountNumber(), transaction.getAmount());
					}
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println(
						"File \"oldmast.txt\" formed improperly. Terminating.");
					elementException.printStackTrace(System.out);
					System.exit(1);
				}
				catch (IllegalStateException stateException)
				{
					System.err.println(
						"Error reading from \"oldmast.txt\". Terminating.");
					stateException.printStackTrace(System.out);
					System.exit(1);
				}
				finally
				{
					closeOldMaster();
				}
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("File \"trans.txt\" formed improperly. Terminating.");
			elementException.printStackTrace(System.out);
			System.exit(1);
		}
		catch (IllegalStateException stateException)
		{
			System.err.println("Error reading from \"trans.txt\". Terminating.");
			stateException.printStackTrace(System.out);
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
