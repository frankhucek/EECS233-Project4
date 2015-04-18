package project4;

/**
 * Class containing HeapSort, QuickSort, and MergeSort
 * @author Frank Hucek
 */
public class Sorting
{
    
    public static void main(String[] args)
    {
        int[] a = new int[100];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random() * a.length);
            System.out.println("" + a[i]);
        }
        System.out.println();
        Sorting.mergeSort(a);
        System.out.println();
        for(int i = 0; i < a.length; i++)
            System.out.println("" + a[i]);
    }
    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\//// HEAPSORT /////\\\\\\\\\\\\\\\\\\\\/////
    //////////////////////////////////////////////////////////////////
    public static long heapSort(int[] arr)
    {
        return ascendingHeapSort(arr,0,arr.length);
    }
    
    private static long ascendingHeapSort(int[] a, int start, int end)
    {
        int numitems = end - start; //a.length
        buildHeap(a, numitems);
        
        for(int sorted = numitems - 1; sorted > start; sorted--)
        {
            int num = removeMax(a, sorted); 
            a[sorted] = num;
        }
        return (long) 0.0;
    }
    
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
    
    private static int removeMax(int[] a, int numitems)
    {
        int element = a[0];
        a[0] = a[numitems];
        siftDown(a,numitems,0);
        return element;
    }
    
    private static void buildHeap(int[] a, int numitems)
    {
        for(int i = (numitems - 2)/2; i >= 0; i--)
            siftDown(a,numitems,i);
    }
    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\//// QUICKSORT ////\\\\\\\\\\\\\\\\\\\////
    ////////////////////////////////////////////////////////////////
    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
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
    
    private static void ascendingQuickSort(int[] a, int left, int right)
    {
        if(left >= right)
            return;
        int j = partition(a, left, right);
        ascendingQuickSort(a, left, j - 1);
        ascendingQuickSort(a, j + 1, right);
    }
    
    public static long quickSort(int[] a)
    {
        ascendingQuickSort(a,0,a.length - 1);
        return (long) 0.0;
    }
    
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////\\\\\\\\\\\\\\\\\\\\//// MERGESORT ////\\\\\\\\\\\\\\\\\\\\\\////
    ////////////////////////////////////////////////////////////////////
    public static void mergeSort(int[] arr)
    {
        ascendingMergeSort(arr); 
    }
    
    /**
     * Saves on buffer space.
     * Currently working, but analyses are being run.
     * @param a 
     */
    public static void ascendingMergeSort(int[] a) 
    {
        int[] from = a;
        int[] to = new int[a.length];
        for (int blockSize = 1; blockSize < a.length; blockSize *= 2) 
        {
            for (int start = 0; start < a.length; start += 2*blockSize)
                mergeWithoutCopy(from, to, start, start + blockSize, start + 2*blockSize);
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

    private static void mergeWithoutCopy(int[] from, int[] to, int lo, int mid, int hi) {
       // DK: cannot just return if mid >= a.length, but must still copy remaining elements!
       // DK: add two tests to first verify "mid" and "hi" are in range
       if (mid > from.length) 
           mid = from.length;
       if (hi > from.length) 
           hi = from.length;
       
       int i = lo;
       int j = mid;
       
       for (int k = lo; k < hi; k++) 
       {
          if(i == mid)          
              to[k] = from[j++];
          else if (j == hi)           
              to[k] = from[i++];
          else if (from[j] < from[i]) 
              to[k] = from[j++];
          else                        
              to[k] = from[i++];
       }
       // DO NOT copy back
       // for (int k = lo; k < hi; k++)
       //   a[k] = aux[k];
    }
}
