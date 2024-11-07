package Sorting;

public class QuickSort {

    public static void Sort(int[] arr, int low, int high)
    {
        if (high-low <= 1) return;

        int pivot = Partition(arr, low, high);

        Sort(arr, low, pivot);
        Sort(arr, pivot+1, high);
    }
    /*public static void QuickSelect(int[] arr, int pivotIdx)
    {
        final int n = arr.length;
        int p = 0;

        while ( p < n && arr[p] <= arr[pivotIdx]) {
            p++;
        }

        if (p == n)
        {
            System.out.println("All elements of the array is smaller than element at pivotIdx");
            swap(arr, pivotIdx, p-1);
            return;
        }

        for (int q = p+1; q < n; q++)
        {
            if (arr[q] < arr[pivotIdx]) {
                // swap
                swap(arr, p, q);
                p++;
            }
        }

        if (pivotIdx >= p) swap(arr, p, pivotIdx);
        else swap(arr, pivotIdx, p-1);
    }*/

    // Finding pivot wrt to first element
    private static int Partition(int[] arr, int low, int high)
    {
        int pivotEle = arr[low];

        // find first larger element than pivotEle
        int i = low+1;
        while (i < high && arr[i] <= pivotEle) i++;

        if (i == high)
        {
            swap(arr, i-1, low);
            return i-1;
        }

        int j = i+1;

        while(j < high)
        {
            if (arr[j] <= pivotEle) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }

        swap(arr, low, i-1);
        return i-1;
    }
    private static void swap (int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
