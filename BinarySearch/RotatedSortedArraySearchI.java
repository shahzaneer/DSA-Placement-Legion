public class RotatedSortedArraySearchI {
    public static void main(String[] args) {
        // only uniques elements are given.
        int [] array = {7,8,9,10,1,2,3,4,5,6};
        System.out.println(searchInRotatedSortedArray(array, 4));
    }
    //TODO: the given array was sorted completely initially now the array is rotated by an unknown point 'k'
    //TODO:  making it partially sorted array. you have to find element within that partially sorted array.
    //! TC: O(logn)  
    //* identify the sorted half (left or right) 
    //* then identify if the element lies within that half 
    //* it yes than this is your new searchspace otherwise omit this half.


    static int searchInRotatedSortedArray(int [] array, int target){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == target) return mid;

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
