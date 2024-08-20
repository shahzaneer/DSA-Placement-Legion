class Solution {
    public int reversePairs(int[] array) {
        return mergeSortHelper(array, 0, array.length - 1);
    }

    static int countReversePairs(int[] array, int low, int mid, int high) {
        // ! Remember this function is not changing the original merge sort
        // ! it is here to calculate the reversePairs only!
        int currentRight = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            // first loop: to iterate over the first Array [i]
            // while(currentRight <= high && array[i] > (2* array[currentRight])){  // I did this to avoid integer overflow it can be done also by converting to long..
            // this optimization keeps it away from going to O(n^2) in worst case
            while (currentRight <= high && (0.5 * array[i]) > array[currentRight])  {
                currentRight++;
            }
            count += currentRight - (mid + 1);
        }
        return count;
    }

    static int mergeSortHelper(int[] array, int low, int high) {
        int count = 0;
        if (low == high)
            return count;

        int mid = (low + high) / 2;
        count += mergeSortHelper(array, low, mid);
        count += mergeSortHelper(array, mid + 1, high);
        count += countReversePairs(array, low, mid, high);
        merge(array, low, mid, high);
        return count;
    }

    static void merge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp.add(array[left]);
                left++;
            }

            else {
                temp.add(array[right]);
                right++;
            }
        }

        // if right array is exhausted
        while (left <= mid) {
            temp.add(array[left]);
            left++;
        }

        // if left array is exhausted
        while (right <= high) {
            temp.add(array[right]);
            right++;
        }

        // Copying the temp sorted elements in Original array
        for (int i = low; i <= high; i++) {
            array[i] = temp.get(i - low); // (low - low = 0) then (low+1 - low = 1) then (low+2-low = 2 and so on...)
        }
    }

}