package Sorting;

/* ************************************************* Selection Sort *************************************************
*
* Selection Sort is another straightforward comparison-based sorting algorithm. Unlike Bubble Sort, which repeatedly
* swaps adjacent elements, Selection Sort works by repeatedly finding the smallest (or largest) element in the unsorted
* portion of the list and moving it to its correct position.
*
* ## How selection sort works
*   -> Divide the array into two parts: sorted and unsorted. Initially, the entire array is unsorted.
*   -> Find the minimum element in the unsorted portion.
*   -> Swap the minimum element with the first element of the unsorted portion, moving it to the end of the sorted portion.
*   -> Expand the sorted portion by one element and repeat the process until the entire array is sorted.
*
* ## Step-by-Step Example
*
*   Let's sort the array [5, 2, 9, 1, 5, 6] in ascending order:
*       -> Step 1: Find the minimum element in the entire array, which is 1. Swap 1 with the first element 5 → [1, 2, 9, 5, 5, 6].
*       -> Step 2: Move to the next position. Find the minimum in the remaining unsorted part [2, 9, 5, 5, 6], which is 2.
*           Since 2 is already in the correct position, no swap is needed.
*       -> Step 3: Move to the next position. Find the minimum in [9, 5, 5, 6], which is 5. Swap 5 with 9 → [1, 2, 5, 9, 5, 6].
*       -> Step 4: Repeat the process for [9, 5, 6]. The minimum is 5, so swap 5 with 9 → [1, 2, 5, 5, 9, 6].
*       -> Step 5: The minimum in [9, 6] is 6. Swap 6 with 9 → [1, 2, 5, 5, 6, 9].
*
* ## Time Complexity -- O(n^2) in all cases (best, average, worst)
*
* ## In-place and unstable sorting technique
*
* ## Can be used where less swapping is favorable and less memory writes are required
* */

/* ***************************************************** Code *****************************************************/
public class SelectionSort {
    public static void Sort(int[] arr)
    {
        final int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int minIdx = i;

            for (int j = i; j < n; j++)
            {
                minIdx = arr[minIdx] > arr[j] ? j : minIdx;
            }

            swap(arr, minIdx, i);
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
