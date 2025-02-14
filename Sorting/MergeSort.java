package Sorting;

/*********************************************** Merge Sort ****************************************************
 Merge Sort is a classic, efficient sorting algorithm that uses the divide-and-conquer technique.
 It breaks down an array into smaller subarrays, sorts each subarray, and then merges them back together in sorted order.

 ## How Merge Sort Works

    -> Divide: Recursively split the array into two halves until each half contains a single element (which is inherently sorted).
    -> Conquer (Sort): Recursively sort each half.
    -> Merge: Merge the two sorted halves back into a single sorted array.

 ## Example: Step-by-Step Breakdown

     Let’s sort the array [5, 2, 9, 1, 5, 6]:

     -> Initial Array: [5, 2, 9, 1, 5, 6]
        * Split into two halves: [5, 2, 9] and [1, 5, 6]

     -> First Half ([5, 2, 9]):
        * Split into [5] and [2, 9]
        * [2, 9] splits into [2] and [9]
        * Merge [2] and [9] to form [2, 9]
        * Merge [5] and [2, 9] to form [2, 5, 9]

     -> Second Half ([1, 5, 6]):
        * Split into [1] and [5, 6]
        * [5, 6] splits into [5] and [6]
        * Merge [5] and [6] to form [5, 6]
        * Merge [1] and [5, 6] to form [1, 5, 6]

     -> Final Merge:
        * Merge [2, 5, 9] and [1, 5, 6] to get [1, 2, 5, 5, 6, 9]

     The array is now sorted: [1, 2, 5, 5, 6, 9].

 ## Complexity Analysis

    -> Time Complexity: O(nlogn) for all cases.
        The divide step splits the array in half repeatedly, which takes O(logn) steps.
        Each level of recursion merges all elements, taking O(n) time.
        Combined, this yields O(nlogn).

    -> Space Complexity: O(n) due to the additional storage needed to hold the merged arrays during the merging process.
        This is why Merge Sort is not in-place; it requires auxiliary space to store temporary arrays.

 ## Stability
    Merge Sort is a stable sorting algorithm. It maintains the relative order of elements with equal values,
    making it ideal for scenarios where stability is important.

 ## Use cases
    -> Sorting large datasets
    -> External sorting (when the dataset is too large to fit in memory)
    -> Inversion counting
    -> It is a preferred algorithm for sorting Linked lists.
    -> It can be easily parallelized as we can independently sort subarrays and then merge.
 */

/************************************************** Code ******************************************************/

public class MergeSort {
    public static void Sort(int[] arr, int low, int high)
    {
        if (low == high) return;

        int mid = low + (high-low)/2;

        Sort(arr, low, mid);
        Sort(arr, mid + 1, high);
        Merge(arr, low, mid, high);
    }

    private static void Merge(int[] arr, int low, int mid, int high)
    {
        int len1 = mid-low+1;
        int len2 = high - mid;

        int[] aux1 = new int[len1];
        int[] aux2 = new int[len2];

        // copying both array with the elements of each divided portion

        int idx = 0;
        for (int i = low; i <= mid; i++)
        {
            aux1[idx++] = arr[i];
        }

        idx = 0;
        for (int i = mid+1; i <= high; i++)
        {
            aux2[idx++] = arr[i];
        }

        // merging process start

        idx = low;
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < len1 && ptr2 < len2)
        {
            if (aux1[ptr1] > aux2[ptr2]) arr[idx++] = aux2[ptr2++];
            else arr[idx++] = aux1[ptr1++];
        }

        while (ptr1 < len1) arr[idx++] = aux1[ptr1++];
        while (ptr2 < len2) arr[idx++] = aux2[ptr2++];
    }
}
