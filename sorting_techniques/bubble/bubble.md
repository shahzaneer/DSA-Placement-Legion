# Bubble Sort
- `Push the Maximum element in the array at every step to the last (bubbles out the largest element) by adjacent swapping`
## Time Complexity:
- Average and worst are `O(n^2)`
- Best `O(n)`(in the case that already sorted array is given)
## Space Complexity:
- `O(1)`
## Is it a stable Algorithm?
- Bubble sort is a stable sorting algorithm. 
- This means that if you have duplicate elements in your input list, their relative order within the duplicates will be preserved after sorting.
- For example, consider the list `[3, 1, 1, 2]`. After sorting with bubble sort, it will become `[1, 1, 2, 3]`, maintaining the original order of the `duplicate 1s`.
## Is it an adaptive Algorithm?
- By default Bubble sort is not an adaptive sorting algorithm. It doesn't take advantage of any existing order in the input data. 
- Regardless of whether the input is already partially sorted or not, bubble sort performs the same number of comparisons and swaps in the worst-case scenario. (but we can improve it and after improving it we can make it adaptive)

## Is it inplace algorithm?
- Bubble sort is an in-place sorting algorithm. It sorts the elements within the same array, modifying the original data structure without requiring additional memory for a temporary array.
## In which cases we should use bubble sort?
- `Educational purposes:` Similar to selection sort, bubble sort's simplicity makes it a good choice for understanding sorting concepts due to its clear structure and ease of implementation.
- However, due to its `inefficiency, bubble sort is rarely used in practice for actual sorting tasks`.
## In which cases wo should not use bubble sort?
- Almost always: Bubble sort has a time complexity of `O(n^2)`, which means the sorting time increases quadratically with the number of elements. This makes it significantly slower than more efficient algorithms like `merge sort (O(n log n))` or quicksort `(average-case O(n log n))` for any reasonably sized dataset.

- `Even for small datasets`, other algorithms like `insertion sort` can be more efficient, especially if the data is partially sorted.

