public class RotatedSortedArraySearch2 {
    public static void main(String[] args) {
        //!  Duplicates elements are given.
        // int [] array = {7,8,9,10,1,2,3,4,5,6};
        // int [] array = {3,3,3,1,3,3,3,3};
        int [] array = {3,3,3,3,3,3,3,3};

        System.out.println(searchInRotatedSortedArray(array, 1));
    }
    //TODO: the given array was sorted completely initially now the array is rotated by an unknown point 'k'
    //TODO:  making it partially sorted array. you have to find element within that partially sorted array.
    // TODO: the elements are duplicates too.
    //! TC: O(logn) in average case 
    // ! TC: O(n) in extreme worst case  
    //* identify the sorted half (left or right) 
    //* then identify if the element lies within that half 
    //* it yes than this is your new searchspace otherwise omit this half.
    // * if there comes a condition that array[mid] == array[low] == array[high] you will not be able  to find out the left half or right half so reduce one one points on low nad high and skip this case as we are still not sure what might be in the array.


    static int searchInRotatedSortedArray(int [] array, int target){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == target) return mid;

            if(array[mid] == array[low] && array[mid] == array[high]){
                // as if this occurs it will not be possible for us to find the left or right half.
                low = low + 1;
                high = high -1;
                continue;
            }

            // left half is sorted
            if(array[low] <= array[mid]){
                if(array[low] <= target && array[mid] > target){
                    high = mid - 1;
                } 
                else low = mid + 1;
            }

            // right half is sorted
            else{
                if(array[mid] < target && array[high] >= target){
                    low = mid +1;
                }
                else high = mid - 1;
            }
        }
        return -1; // you didn't find that element.
    }

    // ! Explanation of the algo 
    // static int searchInRotatedSortedArray(int [] array, int target){
    //     // As the Array is Sorted I can think of a binary Search Solution.
    //     int low = 0;
    //     int high = array.length - 1;
    //     while(low <= high){
    //         int mid = low + (high - low)/2;
    //         if(array[mid] == target) return mid;
    //         if(array[mid] == array[low] && array[mid] == array[high]){
    //            low = low+1;  
    //            high = high -1;
    //            continue;
    // }

    //         // it is confirm that either the left half will be sorted or the right half will be sorted.
    //         //left half is sorted
    //         if(array[low] <= array[mid]){
    //             // now check if the fucking target lies within this half
    //             // if yes this is your new SearchSpace
    //             // if no go the right half thats algo. 
    //             if(array[low] <= target && array[mid] > target){
    //                 high = mid - 1;
    //             } 
    //             else low = mid + 1;
    //         }

    //         // right half is sorted
    //         else{
    //             if(array[mid] < target && array[high] >= target){
    //                 low = mid +1;
    //             }
    //             else high = mid - 1;
    //         }
    //     }
    //     return -1; // you didn't find that element.
    // }
}
