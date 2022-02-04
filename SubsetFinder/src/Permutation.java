// Java program to print all combination of size 
// r in an array of size n 
import java.io.*; 

public class Permutation { 

	/* arr[] ---> Input Array 
	data[] ---> Temporary array to store current combination 
	start & end ---> Staring and Ending indexes in arr[] 
	index ---> Current index in data[] 
	r ---> Size of a combination to be printed */
	static void combinationUtil(int arr[], int n, int r, 
						int index, int data[], int i) 
	{ 
		// Current combination is ready to be printed, 
		// print it 
		if (index == r) { 
			for (int j = 0; j < r; j++) 
				System.out.print(data[j] + " "); 
			System.out.println(""); 
			return; 
		} 

		// When no more elements are there to put in data[] 
		if (i >= n) 
			return; 

		// current is included, put next at next 
		// location 
		data[index] = arr[i]; 
		combinationUtil(arr, n, r, index + 1, 
							data, i + 1); 

		// current is excluded, replace it with 
		// next (Note that i+1 is passed, but 
		// index is not changed) 
		combinationUtil(arr, n, r, index, data, i + 1); 
	} 

	// The main function that prints all combinations 
	// of size r in arr[] of size n. This function 
	// mainly uses combinationUtil() 
	static void printCombination(int arr[], int n, int r) 
	{ 
		// A temporary array to store all combination 
		// one by one 
		int data[] = new int[r]; 

		// Print all combination using temprary 
		// array 'data[]' 
		combinationUtil(arr, n, r, 0, data, 0); 
	} 

	/* Driver function to check for above function */
	public static void main(String[] args) 
	{ 
		int arr[] = { 10, 20, 30, 40, 50 }; 
		int r = 3; 
		int n = arr.length; 
		printCombination(arr, n, r); 
	} 
} 
/* This code is contributed by Devesh Agrawal */
