package project4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Second set of tests
 * @author Frank Hucek
 */
public class Reporting2 
{

    /**
     * Main method to run
     * @param args single input string will be the input file name
     */
    public static void main(String[] args) 
    {
	File input = new File(args[0]);
	StringBuilder outputStr = new StringBuilder();	
	int[] arr = readFile(input);
		
	outputStr.append(heapSortStats(arr));
	outputStr.append(quickSortStats(arr));
	outputStr.append(mergeSortStats(arr));
		
	System.out.println(outputStr.toString());
    }
    
    /**
     * This is the number of trials done per sorting algorithm
     */
    public static final int numTests = 3; 
    /**
     * Keeps track of the times the sorting algorithms took
     */
    public static long[] results = new long[numTests]; 

    /**
     * Median time for HeapSort after total of 3 runs
     * @param arr input array
     * @return The resulting time in proper format
     */
    public static String heapSortStats(int[] arr)
    {
		
	for(int i = 0; i < numTests; i++)
        { 
            int[] toSort = arr.clone();
            results[i] = Sorting.heapSort(toSort); 
			
            if(i == 0)
		writeFile(new File("fjh32HS.txt"), toSort);
	}
	System.out.println(Arrays.toString(results));
	return "fjh32HS = "+getMedian(results)+"ns;\t";
    }
	
    /**
     * Median time for QuickSort after total of 3 runs
     * @param arr input array  
     * @return Resulting time in proper format
     */
    public static String quickSortStats(int[] arr)
    {
	
	for(int i=0;i<numTests;i++)
        { 
			
            int[] toSort = arr.clone(); 
            results[i] = Sorting.quickSort(toSort); 
			
            if(i==0)
                writeFile(new File("fjh32QS.txt"), toSort);
	}
	return "fjh32QS = "+getMedian(results)+"ns;\t";
    }
	
    /**
     * Median time for MergeSort after total of 3 runs
     * @param arr input array
     * @return Resulting time in proper format
     */
    public static String mergeSortStats(int[] arr)
    {
		
	for(int i=0;i<numTests;i++)
        { 
		
            int[] toSort = arr.clone(); 
            results[i] = Sorting.mergeSort(toSort);
			
            
            if(i==0)
		writeFile(new File("fjh32MS.txt"), toSort);
	}
	return "fjh32MS = "+getMedian(results)+"ns;\t";
    }
	
    /**
     * Reads the input file
     * @param inputFile the input file File object
     * @return an int array received by reading the input file
     */
    public static int[] readFile(File inputFile)
    {
	int[] inArr = new int[countLines(inputFile)]; 
	int lineNum=0;
	
	try
        {
		
            Scanner inScanner = new Scanner(inputFile);
			
            while(inScanner.hasNext())
            {
		inArr[lineNum] = Integer.parseInt(inScanner.nextLine()); 
		lineNum++;
            }
		
            inScanner.close();
	}
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
	}
	return inArr;
    }
	
    /**
     * Initialize the array and returns required array size
     * @param file the file to count the lines of
     * @return the number of lines in the file
     */
    private static int countLines(File file)
    {
	int lineCount=0;
		
	try
        {
			
            Scanner inScanner = new Scanner(file);
			
            while(inScanner.hasNext())
            {
		lineCount++;
		inScanner.next();
            }
			
            inScanner.close();
	}
        catch(FileNotFoundException ex)
        {
            System.out.println(ex);
	}
	return lineCount;
    }
	
    //writes the sorted arrays to a given output file
    /**
     * Writes the sorted arrays to the output file
     * @param outputFile output file to write to
     * @param arr array to write to the output file
     */
    public static void writeFile(File outputFile, int[] arr)
    {	
	try 
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(Arrays.toString(arr)); 
			
            writer.close();		
	} 
        catch (IOException ex) 
        {
            ex.printStackTrace();
	}	
    }
	
    /**
     * Sorts array and takes middle element to get median
     * @param arr input array of time values
     * @return the median time
     */
    public static long getMedian(long[] arr)
    {
	Arrays.sort(arr);
	return arr[arr.length/2];
    }
}