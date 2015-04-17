package project4;

/**
 * Class containing HeapSort, QuickSort, and MergeSort
 * @author Frank Hucek
 */
public class Sorting
{
    
    public static void main(String[] args)
    {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random() * a.length);
            System.out.println("" + a[i]);
        }
        System.out.println();
        Sorting.quickSort(a);
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
            numitems--;
            int num = removeMax(a, numitems); 
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
}
