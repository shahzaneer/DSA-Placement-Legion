# Merge Sort
-  `Divide and Merge` (Divide and Conquer)
- Repeatedly and hypothetically divide the array in 2 halfs and sort them and when you reach to a single point when low == high go back merging the left and right half in a sorted way.
## Time Complexity:
- `Best Case: O(n log n)`
- `Average Case: O(n log n)`
- `Worst Case: O(n log n)`
- Merge sort consistently exhibits O(n log n) time complexity regardless of the input data distribution, making it a reliable choice for various sorting scenarios.

## Space Complexity:
- `O(n)` 
- Merge sort requires additional space to store the temporary arrays created during the merging process.

## Is it Stable?
- `Yes, merge sort is a stable sorting algorithm`. 
- It preserves the relative order of duplicate elements in the input array.

## Is it adaptive?
- `No, merge sort is not an adaptive sorting algorithm.` 
- It performs the same number of comparisons and operations regardless of the initial order of the elements.

## Is it inplace?
- `No, merge sort is not an in-place sorting algorithm.` 
- It requires additional memory to create temporary arrays during the merging process.

## When we should use Merge Sort?
- `Large datasets:` 
- Merge sort excels at handling large input arrays due to its consistent O(n log n) time complexity.
- `External sorting:` 
- Merge sort is suitable for external sorting, where data is too large to fit into main memory and resides on external storage devices like disks.
- `Stability is required:` 
- If preserving the relative order of duplicate elements is important, merge sort is a good choice.

## When not to use Merge Sort?
- `Small datasets:` 
- For small input arrays, insertion sort or bubble sort might be faster due to their simpler implementation and lower overhead.
- `Space constraints:` 
- If memory is limited, merge sort's use of additional space might be a concern. In such cases, in-place algorithms like quicksort or heapsort could be considered.

### Merge sort is a versatile and efficient sorting algorithm with a consistent `O(n log n)` time complexity. It is well-suited for large datasets and scenarios where stability is required. However, its space usage and potential performance overhead for small inputs should be considered when choosing a sorting algorithm.