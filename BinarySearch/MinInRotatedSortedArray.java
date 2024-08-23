public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int [] array = {4,5,6,7,1,2,3,4};
        int [] array2 = {4,5,1,2,3};
        System.out.println(minInRotatedSortedArray(array));
        System.out.println(minInRotatedSortedArray(array2));

    }

    // ! Approach:
    // There are two part of the array left and right
    // if right is sorted then the middle element is the lowest for the right part.
    // elimate it and move to the left and there the low element is the smallest.
    // at every point check that it is the smallest or not and you are done with it.

    //! TC: O(log n)
    static int minInRotatedSortedArray(int [] array){
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = array.length - 1;
        while(low<= high){
        int mid = low + (high - low)/2;
        
        // left half is sorted
        if(array[mid] >= array[low]){
          min = Math.min(min, array[low]);
          low = mid + 1;
        }
        // right half is sorted
        else{
            min = Math.min(min, array[mid]);
            high = mid - 1;
        }

        }
        return min;
    }

        //! Slight Optimization: TC: O(log n)

    static int minInRotatedSortedArrayOptimized(int [] array){
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = array.length - 1;
        while(low<= high){
        int mid = low + (high - low)/2;

        //if searchSpace is already sorted no need to check further.
        if(array[low] <= array[high]){
            min = Math.min(min, array[low]);
            break; // as there is no need to check further...
        }
        
        // left half is sorted
        if(array[mid] >= array[low]){
          min = Math.min(min, array[low]);
          low = mid + 1;
        }
        // right half is sorted
        else{
            min = Math.min(min, array[mid]);
            high = mid - 1;
        }

        }
        return min;
    }
}
