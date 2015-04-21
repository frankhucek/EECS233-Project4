package project4;

/**
 * First testing class
 * DISCLAIMER: THE LAST TEST IS ALWAYS OFF BY ABOUT
 * 20% ON A QUAD CORE CPU AND 5-10% ON A SINGLE CORE CPU.
 * Professors Rabinovich and Connamacher did not understand
 * why exactly this was happening. Possibly cpu scheduling.
 * @author Frank Hucek
 */
public class Reporting1 
{

        /**
         * Prints out the results of all the tests
         * @param args 
         */
	public static void main(String[] args) 
        {
            Reporting1 test = new Reporting1();
            System.out.println(test.outputTests());
        }

        /**
         * Returns a random array
         * @param length length of random array
         * @return a random array of specified length
         */
	public int[] randomList(int length) 
        {
            int[] arr = new int[length];
		
            for (int i = 0; i < length; i++) 
            {
                arr[i] = (int)(Math.random() * arr.length);
            }
		
            return arr;
	}

	/**
         * Returns an ordered array
         * @param length length of the ordered array
         * @return an ordered array of specified length
         */
	public int[] ascendingList(int length) 
        {
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) 
            {
		arr[i] = i;
            }
		
            return arr;
	}

	/**
         * Returns an array in descending order
         * @param length length of the descending array
         * @return a descending array of specified length
         */
	public int[] descendingList(int length) 
        {
            int[] arr = new int[length];
		
            for (int i = 0; i < length; i++) 
            {
		arr[i] = length - i;
            }
		
            return arr;
	}
        
        /**
         * Performs 3 tests of each algorithm on ordered lists
         * @param length specified length of the ordered lists to test
         * @return The output of the tests
         */
        public String ordered(int length)
        {
            StringBuilder ordered = new StringBuilder("Sorting ordered lists of length " + length + ":\n");
            //3 tests on each algorithm of ascending lists of input length
            for(int i = 0; i < 3; i++) 
            {
                ordered.append("Test " + (i + 1) + " -> "
                    + "\tHeapSort: " + Sorting.heapSort(ascendingList(length))
                    + "\tQuickSort: " + Sorting.quickSort(ascendingList(length))
                    + "\tMergeSort: " + Sorting.mergeSort(ascendingList(length))
                    + "\n");
            }
            return ordered.toString();
        }
        
        /**
         * Performs 3 tests of each algorithm on descending lists
         * @param length specified length of the descending lists to test
         * @return the output of the tests
         */
        public String reverse(int length)
        {
            StringBuilder reverse = new StringBuilder("Sorting reverse lists of length " + length + ":\n");
            //3 tests on each algorithm of descending lists of input length
            for(int i = 0; i < 3; i++) 
            {
                reverse.append("Test " + (i + 1) + " -> "
                    + "\tHeapSort: " + Sorting.heapSort(descendingList(length))
                    + "\tQuickSort: " + Sorting.quickSort(descendingList(length))
                    + "\tMergeSort: " + Sorting.mergeSort(descendingList(length))
                    + "\n");
            }
            return reverse.toString();
        }
        
        /**
         * Performs 10 tests of each algorithm on random lists
         * @param length specified length of the random lists to tests
         * @return the output of the tests
         */
        public String random(int length)
        {
            StringBuilder random = new StringBuilder("Sorting random lists of length " + length + ":\n");
            //10 tests on each algorithm of random lists of input length
            for(int i = 0; i < 10; i++) 
            {
                long heapTime = Sorting.heapSort(randomList(length));
                long quickTime = Sorting.quickSort(randomList(length));
                long mergeTime = Sorting.mergeSort(randomList(length));
                random.append("Test " + (i + 1) + " -> "
                    + "\tHeapSort: " + heapTime
                    + "\tQuickSort: " + quickTime
                    + "\tMergeSort: " + mergeTime
                    + "\n");
            }
            return random.toString();
        }
        
        /**
         * Performs ordered method on arrays of length 1000, 10000, 100000, and 1000000
         * @return the output of the tests
         */
        public String orderedTests()
        {
            StringBuilder orderedOutput = new StringBuilder("*ORDERED TESTS*\n");
            orderedOutput.append(ordered(1000) + "\n" + ordered(10000) + "\n"
                + ordered(100000) + "\n" + ordered(1000000) + "\n");
            return orderedOutput.toString();   
        }
        
        /**
         * Performs reverse method on arrays of length 1000, 10000, 100000, and 1000000
         * @return the output of the tests
         */
        public String reverseTests()
        {
            StringBuilder reverseOutput = new StringBuilder("*REVERSE TESTS*\n");
            reverseOutput.append(reverse(1000) + "\n" + reverse(10000) + "\n"
                + reverse(100000) + "\n" + reverse(1000000) + "\n");
            return reverseOutput.toString(); 
        }
        
        /**
         * Performs random method on arrays of length 1000, 10000, 100000, and 1000000
         * @return the output of the tests
         */
        public String randomTests()
        {
            StringBuilder randomOutput = new StringBuilder("*RANDOM TESTS*\n");
            randomOutput.append(random(1000) + "\n" + random(10000) + "\n"
                + random(100000) + "\n" + random(1000000) + "\n");
            return randomOutput.toString(); 
        }
        
        /**
         * Puts the methods orderedTests, reverseTests, and randomTests together
         * @return the final output of all tests
         */
        public String outputTests()
        {
            StringBuilder s = new StringBuilder();
            s.append(orderedTests());
            s.append(reverseTests());
            s.append(randomTests());
            return s.toString();
        }
}