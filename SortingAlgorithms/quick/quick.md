# Quick Sort
- `Divide and Conquer`
- Firstly we have to specify a pivot element and it can be selected by any way and we have to put it in its correct order and then call the algo for its left (smaller elements) and right (larger elements) side.
## Time Complexity
- `Best case: O(n log n)`
- `Average case: O(n log n)`
- `Worst case: O(n^2)`
## Space Complexity
- `O(1)` 
- if we consider the `stack memory`:
- `Average case: O(log n) - due to recursive calls`
- `Worst case: O(n) - in case of unbalanced partitions`
## Is it Stable?
- `No, Quick Sort is not stable.` 
- The relative order of equal elements might change after sorting.
## Is it adaptive?
- `No, Quick Sort is not adaptive.` 
- It doesn't take advantage of any existing order in the input data.
## Is is In place?
- `Yes, Quick Sort is an in-place sorting algorithm.` 
- It sorts the elements within the same array without requiring additional memory for a temporary array.
## When should we use quick sort?
- `Large datasets:` 
- Quick Sort is generally efficient for large datasets due to its average-case time complexity of `O(n log n)`
- `Randomly distributed data:` 
- Quick Sort performs well on randomly distributed data.
## When we should not use quick sort?
- `Small datasets:` 
- For small datasets, other algorithms like insertion sort might be faster due to their simpler implementation and lower overhead.
`Data with specific patterns:` 
- If the input data has certain patterns 
- `(e.g., already sorted or reverse sorted), Quick Sort can degrade to its worst-case time complexity of O(n^2).`

- `Worst-Case Scenarios:` 
- `Sorted and Reverse-Sorted Arrays`
- `Sorted Array:` 
- If the input array is already sorted, and the pivot is consistently chosen as the first or last element, the partitioning will always result in `one empty subarray` and `one subarray with n-1 elements`. This leads to a recursive structure resembling a `linked list`, resulting in `O(n^2)` time complexity.
- `Reverse-Sorted Array:` 
- A similar situation occurs with a reverse-sorted array. The pivot choice again leads to `unbalanced partitions`, causing the algorithm to degenerate to `O(n^2)`.
## is it the best sorting algorithm for the larger data sets?
- `Quick Sort is often considered one of the best sorting algorithms` for larger datasets due to its average-case time complexity of O(n log n). However, it's important to note that the choice of sorting algorithm depends on various factors, including the `size of the dataset`, the `distribution of data`, and `memory constraints`.
## Java Collection framework's sort method uses which sorting algorithm?
- The `sort()` method of the `Java Collections framework` uses a `Dual-Pivot Quicksort algorithm`. 
- This is a variant of Quick Sort that selects two pivot elements instead of one, which can improve performance in certain cases.