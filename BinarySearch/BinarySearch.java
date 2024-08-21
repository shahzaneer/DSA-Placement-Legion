
import java.util.Arrays;

class BinarySearch {


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        System.out.println(searchIterative(array, 2));
        System.out.println(searchRecursive(array, 2, array.length -1, 0));
        //! Java Collections
        System.out.println(Arrays.binarySearch(array, 9));
    }
    //! Dont Memorize it just pick a pen and paper and draw it you will code it in 20 seconds.
    //!ITERATIVE TC: O(log  n) SC:O(1)
    static int searchIterative(int[] array, int target) {
        int low = 0;
       int high = array.length-1;
       while(low<=high){
        // int mid = (low+high)/2;
        long mid = (low+high)/2;
        int middle = (int) mid;
        if(array[middle] == target) return middle;
        else if(array[middle] < target) low = middle + 1;
        else high = middle - 1;
       }
       return -1; 
    }
    //! Recursive: TC: O(log n) SC: O(1)
    static int searchRecursive(int [] array, int target, int high, int low){
        if(low > high) return -1;
        // int mid = (low+high)/2;
        int mid = low + (high -  low)/2;
        if(array[mid] == target) return mid;
        else if(array[mid] < target ) return searchRecursive(array, target, high, mid+1);
        else return searchRecursive(array, target, mid - 1, low);

    }
}
    //! Overflow Condition: 
    // what if searchSpace includes intMax and you are finding intMax and it is on the left most or right mostplace?
    // intmax+ intMax/2 will be overflowed by integer.
    // Resolution:
    // ! Maths: mid = low + (low -high)/2
    // ! type casting: (long) (low+ high)/2 

    // Jahan bhi data apka Sorted hoga. wahan searching me Binary search help degi
    // hashing O(1) me search krti hai uske bad yehi hai jo hai.
    // by jahan bhi -> 2D 3D data custom DS  etc etc.
  