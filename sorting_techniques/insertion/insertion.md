# Insertion Sort
- `Take an element and place it on its right position`
- It takes the concept of a sorted array part and unsorted part array.
## Why it is called insertion sort?
- Because in each step we insert an element from unsorted array to the sorted array and place it on its right position.
## Time Complexity:
- Worst Case (Descending sorted array) `O(n^2)` 
- Average case `O(n^2)`
- Best Case (already sorted array) `O(n)`
## Space Complexity:
- `O(1)`
## Is it a stable Algorithm?
- Yes, `insertion sort is a stable sorting algorithm`.
- This means that if you have duplicate elements in your input list, their relative order will be `preserved after sorting`. For example, [2, 1, 1, 3] will become [1, 1, 2, 3].
## Is it an adaptive Algorithm?
- `Yes, insertion sort is an adaptive sorting algorithm`. 
- It can take `advantage of partially sorted data`. If the input list is already mostly sorted, insertion sort performs fewer comparisons and swaps, leading to faster sorting.
## Is it inplace algorithm?
- `yes, insertion sort is an in-place sorting algorithm`. It sorts the elements within the same array, modifying the original data structure without requiring additional memory for a temporary array.
## In which cases we should use Insertion sort?
- `Small datasets:` 
- For small lists (tens or hundreds of elements), insertion sort can be faster than more complex algorithms due to its low overhead and potential for taking advantage of partial order.
- `Partially sorted data:` 
- When you know the input data is likely to be already partially sorted, insertion sort can be a good choice due to its adaptive nature.
## In which cases wo should not use Insertion sort?
- `Large datasets:` 
- As the `data size increases`, insertion sort's quadratic time complexity becomes a significant bottleneck. For `large datasets, consider using algorithms like merge sort (O(n log n)) or quicksort (average-case O(n log n)) for better performance.`

### Insertion sort offers a simple and efficient sorting approach for small datasets or partially sorted data. Its stability and adaptivity make it useful in specific scenarios. However, for large, random datasets, more efficient algorithms are preferred.









