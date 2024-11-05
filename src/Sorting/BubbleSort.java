package Sorting;

/* ************************************* Bubble Sort ***********************************

Bubble sort repeatedly steps through the list, compares adjacent elements, and swaps them if they’re in the wrong order.
This process "bubbles" the largest (or smallest, depending on the order) elements to their correct positions in each pass.

## How Bubble Sort Works
  -> Compare each pair of adjacent elements in the list.
  -> Swap the elements if they’re in the wrong order (e.g., if sorting in ascending order and the first element is greater than the second).
  -> Repeat the process for all elements in the list.
  -> After each pass, the largest unsorted element "bubbles up" to its final position, so the next pass can ignore it.
  -> Continue until no more swaps are needed, meaning the list is fully sorted.

## Step-by-Step Example

    Let’s sort the array [5, 2, 9, 1, 5, 6] in ascending order:

    Pass 1: [5, 2, 9, 1, 5, 6]
        5 > 2 → Swap → [2, 5, 9, 1, 5, 6]
        5 < 9 → No swap
        9 > 1 → Swap → [2, 5, 1, 9, 5, 6]
        9 > 5 → Swap → [2, 5, 1, 5, 9, 6]
        9 > 6 → Swap → [2, 5, 1, 5, 6, 9]

    After Pass 1, the largest element 9 is in its final position.

    Pass 2: [2, 5, 1, 5, 6, 9]
        2 < 5 → No swap
        5 > 1 → Swap → [2, 1, 5, 5, 6, 9]
        5 < 5 → No swap
        5 < 6 → No swap

    Continue this process until no swaps are made in a pass.

## Time Complexity
    -> Best Case (Already Sorted Array): O(n)
        If the array is already sorted, Bubble Sort can detect it in a single pass without any swaps.

    -> Worst and Average Case: O(n^2)
        In both the worst and average cases, Bubble Sort requires n−1n−1 passes, and each pass performs up to n−1 comparisons.

## Use cases

    While Bubble Sort isn’t used in practice due to its inefficiency, here are a few situations where it might be acceptable:

    -> Educational Purposes: Bubble Sort is often taught as an introduction to sorting because of its simplicity.
    -> Small Data Sets: It can be reasonably efficient for very small arrays where the overhead of more complex algorithms may not be worth it.
    -> Detecting Nearly Sorted Data: Bubble Sort can act as a simple way to check if a list is already sorted.
 */

/********************************** Code ******************************************/
public class BubbleSort {
    public static void Sort(int[] arr)
    {
        final int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            boolean flag = false;

            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }

            if (!flag) break;
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
