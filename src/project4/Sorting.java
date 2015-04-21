package project4;

/**
 * Class containing HeapSort, QuickSort, and MergeSort
 * @author Frank Hucek
 */
public class Sorting
{    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\//// HEAPSORT /////\\\\\\\\\\\\\\\\\\\\/////
    //////////////////////////////////////////////////////////////////
    
    /**
     * Heap Sort algorithm
     * @param arr the array to sort using heapSort
     * @return the time the algorithm took to run
     */
    public static long heapSort(int[] arr)
    {
        if(arr.length <= 1)
        {
            return (long)0;
        }
        long start = System.nanoTime();
        ascendingHeapSort(arr,0,arr.length);
        return System.nanoTime() - start;
    }
    
    /**
     * HeapSort helper method doing the real work
     * @param a the array to sort
     * @param start starting index
     * @param end ending index
     */
    private static void ascendingHeapSort(int[] a, int start, int end)
    {
        int numitems = end - start; //a.length
        buildHeap(a, numitems);
        
        for(int sorted = numitems - 1; sorted > start; sorted--)
        {
            int num = removeMax(a, sorted); 
            a[sorted] = num;
        }
    }
    
    /**
     * The real key to HeapSort - sifts an element at an index down the heap
     * @param a input array
     * @param numitems number of items
     * @param index index to sift down from
     */
    private static void siftDown(int[] a, int numitems, int index)
    {
        int elementToSift = a[index];
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int child = leftChild;
        
        if(leftChild > numitems)
        {
            return;
        }
        
        if(rightChild < numitems && a[rightChild] > a[leftChild])
        {
            child = rightChild;
        }
        
        if(a[index] < a[child])
        {
            a[index] = a[child];
            a[child] = elementToSift;
            siftDown(a, numitems, child);
        }
    }
    
    /**
     * Removes the max element from the heap
     * @param a input array
     * @param numitems number of items
     * @return the element removed
     */
    private static int removeMax(int[] a, int numitems)
    {
        int element = a[0];
        a[0] = a[numitems];
        siftDown(a,numitems,0);
        return element;
    }
    
    /**
     * Builds the heap
     * @param a input array
     * @param numitems number of items
     */
    private static void buildHeap(int[] a, int numitems)
    {
        for(int i = (numitems - 2)/2; i >= 0; i--)
            siftDown(a,numitems,i);
    }
    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\//// QUICKSORT ////\\\\\\\\\\\\\\\\\\\////
    ////////////////////////////////////////////////////////////////
    
    /**
     * QuickSort algorithm helper method
     * @param a input array
     * @param left left index
     * @param right right index
     */
    private static void ascendingQuickSort(int[] a, int left, int right)
    {
        if(left >= right)
            return;
        int j = partition(a, left, right);
        ascendingQuickSort(a, left, j - 1);
        ascendingQuickSort(a, j + 1, right);
    }
    
    /**
     * QuickSort algorithm
     * @param a input array
     * @return The time the algorithm takes
     */
    public static long quickSort(int[] a)
    {
        if(a.length <= 1)
        {
            return (long)0;
        }
        long start = System.nanoTime();
        ascendingQuickSort(a,0,a.length - 1);
        return System.nanoTime() - start;
    }
    
    /**
     * swaps elements at index i and j in array a
     * @param a
     * @param i
     * @param j 
     */
    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    /**
     * Picks a random split point and sorts items less than or equal
     * on the left of it and items greater than on the right
     * @param a input array
     * @param left left index
     * @param right right index
     * @return the splitting index
     */
    private static int partition(int[] a, int left, int right)
    {
        int pivot, i, j, randm;
        randm = left + (int)(Math.random() * (right - left));
        
        i = left;
        j = right + 1;
        
        swap(a,left,randm);
        
        pivot = a[left];
        
        while(true)
        {
            do
            {
                i++;
            }while(a[i] <= pivot && i < right);
            do
            {
                j--;
            }while(a[j] > pivot);
            
            if(i >= j)
                break;
            swap(a,i,j);
        }
        
        swap(a,left,j);
        return j;
    }
    
    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\\//// MERGESORT ////\\\\\\\\\\\\\\\\\\\\\\////
    ////////////////////////////////////////////////////////////////////
    
    /**
     * MergeSort algorithm
     * @param arr input array
     * @return the time the algorithm takes to run
     */
    public static long mergeSort(int[] arr)
    {
        if(arr.length <= 1)
        {
            return (long)0;
        }
        long start = System.nanoTime();
        ascendingMergeSort(arr); 
        return System.nanoTime() - start;
    }
    
    /**
     * MergeSort helper method
     * Saves on buffer space.
     * Iterative version of mergeSort
     * @param a the input array
     */
    public static void ascendingMergeSort(int[] a) 
    {
        int[] from = a;
        int[] to = new int[a.length];
        for (int blockSize = 1; blockSize < a.length; blockSize *= 2) 
        {
            for (int begin = 0; begin < a.length; begin += 2*blockSize)
                mergeWithoutCopy(from, to, begin, begin + blockSize, begin + 2*blockSize);
            int[] temp = from;
            from = to;
            to = temp;
        }
        if (a != from) //copy back if needed
        {
            for (int k = 0; k < a.length; k++)
                a[k] = from[k];
        }
    }
    
    /**
     * Merge method for mergeSort algorithm
     * @param from the from array
     * @param to the array to copy to
     * @param lo 
     * @param mid
     * @param hi 
     */
    private static void mergeWithoutCopy(int[] from, int[] to, int left, int mid, int right) 
    {
       if (mid > from.length) 
           mid = from.length;
       if (right > from.length) 
           right = from.length;
       
       int i = left;
       int j = mid;
       
       for (int k = left; k < right; k++) 
       {
          if(i == mid)          
              to[k] = from[j++];
          else if (j == right)           
              to[k] = from[i++];
          else if (from[j] < from[i]) 
              to[k] = from[j++];
          else                        
              to[k] = from[i++];
       }
    }
}
