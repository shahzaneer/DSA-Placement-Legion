# Selection Sort
- `Select the miminum & swap`
- Firstly consider the first element of the array to be the smallest element and then run the inner loop to check the minimum in comparison with the selected minimum and if they can be swapped, swap them.
## Time Complexity:
- O(n^2)
## Space Complexity:
- O(1)
## Is it a stable Algorithm?
- Selection sort is `not a stable sorting algorithm`. This means that if you have duplicate elements in your input list, the order of those duplicates might be changed after sorting. For example, consider the list [3, 1, 1]. After sorting, it could become [1, 1, 3], which is different from the original order of the duplicates.
## Is it an adaptive Algorithm?
- Selection sort is not an adaptive sorting algorithm. It makes no decisions based on the partial order of the elements already seen. Regardless of whether the input is already partially sorted or not, selection sort performs the same number of comparisons and swaps in the worst-case scenario.
## Is it inplace algorithm?
- Selection sort is an in-place sorting algorithm. It sorts the elements within the same array, modifying the original data structure without requiring additional memory for a temporary array.
## In which cases we should use selection sort?
- `Simple implementation:` Selection sort is a very simple sorting algorithm to understand and implement. It's a good choice for educational purposes or for learners who are new to sorting techniques.
- `Small datasets:` For small datasets (e.g., tens or hundreds of elements), selection sort might be faster than more complex algorithms due to its low overhead.
## In which cases wo should not use selection sort?
- `Large datasets:` Selection sort has a time complexity of O(n^2), which means the sorting time increases quadratically with the number of elements. For large datasets, this can make it significantly slower than algorithms with O(n log n) complexity like merge sort or quicksort.
- `Nearly sorted or partially sorted data`: Selection sort does not take advantage of any existing order in the input data. If the data is already partially sorted, other algorithms like insertion sort can be more efficient.

## Why in the case of smaller databases selection sort might be a good choice in respoect to some complex sorting algorithms with a better time complexity?

- `Imagine you have a small classroom of 10 students and need to sort them by their ages in ascending order.`

- `Selection Sort Approach`:

Iterate through the list: You start by comparing the first student's age with everyone else's. If you find someone younger, swap their positions.
Consider the sorted sub-list: Now, the first student is the youngest (or has the minimum age). You repeat the process for the remaining 9 students, but only consider those from the second student onwards (since the first is already sorted).
Repeat and advance: This process continues, where for each iteration, you find the minimum age among the remaining unsorted students and swap it with the student at the beginning of that sub-list.
- Time Complexity:
In the worst case, for each student (10 iterations), you might need to compare them with all other students (9 comparisons).
This translates to a total of 10 * 9 = 90 comparisons in the worst case.
Comparison with More Complex Algorithms (Example: Merge Sort):

- `Merge sort`, a more efficient algorithm for larger datasets, follows a divide-and-conquer strategy. Here's a simplified explanation:

Divide: It recursively divides the list into halves until each sub-list has only one element (already sorted).
Merge: It then merges the sorted sub-lists back together in a way that preserves the overall order.
- `Overhead of Merge Sort for Small Data:`

- `For a small list of 10 elements, the divide-and-conquer process of merge sort might introduce some overhead. It needs to create temporary sub-lists and perform recursive calls, which can be slightly slower than the simpler comparisons in selection sort for such a small size.`


- `While merge sort has a superior overall time complexity (O(n log n)), for very small datasets like our classroom example (n = 10), the overhead of merge sort can make selection sort's simpler approach with 90 comparisons slightly faster.`

- `However, as the dataset size increases (hundreds or thousands of elements), the overhead of merge sort becomes negligible compared to the significant improvement in efficiency it offers. Selection sort's quadratic time complexity makes it a poor choice for large datasets.`

