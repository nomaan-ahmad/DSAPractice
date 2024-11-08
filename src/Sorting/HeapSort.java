package Sorting;

public class HeapSort {
    public static void Sort(int[] arr)
    {
        int n = arr.length;
        BuildHeap(arr, n);

        // popping out the roots to get sorted array
        while(n > 1)
        {
            swap(arr, 0, n-1);
            n--;
            BuildHeap(arr, n);
        }
    }

    private static void BuildHeap(int[] arr, int n)
    {
        if (n == 1) return;
        int lastNonLeafNode = (n-2)/2;

        for(int i = lastNonLeafNode; i >= 0; i--)
        {
            Heapify(arr, n, i);
        }
    }

    private static void Heapify(int[] arr, int n, int i)
    {
        // based on below property, it is evident that selected element at least has one child
        int lastNonLeafNode = (n-2)/2;

        while(true)
        {
            if (i > lastNonLeafNode) break;

            int leftChildIdx = (i*2) + 1;
            int rightChildIdx = (i*2) + 2;

            // setting left node as largest node
            int max = leftChildIdx;

            // comparing left child with right child and setting it into max variable
            if(rightChildIdx < n && arr[rightChildIdx] > arr[leftChildIdx]) max = rightChildIdx;

            // Now comparing max with parent element

            if (arr[i] < arr[max])
            {
                swap(arr, i, max);
                i = max;
            }else break;
        }
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
