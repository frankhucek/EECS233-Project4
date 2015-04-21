package project4;

public class Reporting1 
{

	public static void main(String[] args) 
        {
            Reporting1 test = new Reporting1();
            Reporting1 test2 = new Reporting1();
            Reporting1 test3 = new Reporting1();
            Reporting1 test4 = new Reporting1();
            //System.out.println("" + test.random(1000));
            //System.out.println("" + test2.random(10000));
            System.out.println("" + test3.random(100000));
            System.out.println("" + test4.random(1000000));
	}


	public int[] randomList(int length) 
        {
            int[] arr = new int[length];
		
            for (int i = 0; i < length; i++) 
            {
                arr[i] = (int)(Math.random() * arr.length);
            }
		
            return arr;
	}

	
	public int[] ascendingList(int length) 
        {
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) 
            {
		arr[i] = i;
            }
		
            return arr;
	}

	
	public int[] descendingList(int length) 
        {
            int[] arr = new int[length];
		
            for (int i = 0; i < length; i++) 
            {
		arr[i] = length - i;
            }
		
            return arr;
	}
        
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
        
        public String random(int length)
        {
            StringBuilder random = new StringBuilder("Sorting random lists of length " + length + ":\n");
            //10 tests on each algorithm of random lists of input length
            for(int i = 0; i < 10; i++) 
            {
                random.append("Test " + (i + 1) + " -> "
                    + "\tHeapSort: " + Sorting.heapSort(randomList(length))
                    + "\tQuickSort: " + Sorting.quickSort(randomList(length))
                    + "\tMergeSort: " + Sorting.mergeSort(randomList(length))
                    + "\n");
            }
            return random.toString();
        }
        
        public String orderedTests()
        {
            StringBuilder orderedOutput = new StringBuilder("*ORDERED TESTS*\n");
            orderedOutput.append(ordered(1000) + "\n" + ordered(10000) + "\n"
                + ordered(100000) + "\n" + ordered(1000000) + "\n");
            return orderedOutput.toString();   
        }
        
        public String reverseTests()
        {
            StringBuilder reverseOutput = new StringBuilder("*REVERSE TESTS*\n");
            reverseOutput.append(reverse(1000) + "\n" + reverse(10000) + "\n"
                + reverse(100000) + "\n" + reverse(1000000) + "\n");
            return reverseOutput.toString(); 
        }
        
        public String randomTests()
        {
            StringBuilder randomOutput = new StringBuilder("*RANDOM TESTS*\n");
            randomOutput.append(random(1000) + "\n" + random(10000) + "\n"
                + random(100000) + "\n" + random(1000000) + "\n");
            return randomOutput.toString(); 
        }
        
        public String outputTests()
        {
            StringBuilder s = new StringBuilder();
            /*s.append(ordered(1000));
            s.append(ordered(10000));
            s.append(ordered(100000));
            s.append(ordered(1000000));
            
            s.append(reverse(1000));
            s.append(reverse(10000));
            s.append(reverse(100000));
            s.append(reverse(1000000));
            
            s.append(random(1000));
            s.append(random(10000));
            s.append(random(100000));
            s.append(random(1000000));
            */
            s.append(orderedTests() + reverseTests() + randomTests());
            return s.toString();
        }
}