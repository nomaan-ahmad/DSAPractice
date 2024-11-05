package Sorting;

/* ***************************************** Insertion sort basics *****************************************

It is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its correct
position in a sorted portion of list

## Step-by-Step Example

Let's say we have an array: [5, 2, 9, 1, 5, 6]

    Step 1: The first element, 5, is considered sorted.
    Step 2: Move to 2. Since 2 < 5, shift 5 right and insert 2 before it → [2, 5, 9, 1, 5, 6].
    Step 3: Move to 9. Since 9 is greater than 5, it stays in place → [2, 5, 9, 1, 5, 6].
    Step 4: Move to 1. Since 1 < 9, 5, and 2, shift them right and insert 1 at the start → [1, 2, 5, 9, 5, 6].
    Step 5: Move to 5. Insert it after the first 5 → [1, 2, 5, 5, 9, 6].
    Step 6: Move to 6. Insert 6 before 9 → [1, 2, 5, 5, 6, 9].

 ## Time complexity
    -> Best Case (Already Sorted Array): O(n) – The algorithm only checks each element once without shifting.
    -> Worst Case (Reverse Sorted Array): O(n^2) – Each element must be compared to and shifted past every other element in
    the sorted portion.
    -> Average Case: O(n^2)

 ## Space Complexity - O(1) -- In place sorting technique

 ## Use cases
    -> Small Data Sets: Insertion Sort is efficient for small arrays because it has minimal overhead.
    -> Nearly Sorted Arrays: It performs exceptionally well with arrays that are already partially sorted, as it approaches
    linear time.
    -> Linked Lists: Insertion Sort can be adapted for sorting linked lists efficiently since shifting elements only
    involves changing pointers.

 */

/*************************************** Code **********************************************/
public class InsertionSort {
    public static void Sort(int[] arr) {
        final int n = arr.length;

        for(int i = 0; i < n-1; i++)
        {
            for (int j = i+1; j > 0; j--)
            {
                if (arr[j] > arr[j-1]) break;
                else swap(arr, j, j-1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
