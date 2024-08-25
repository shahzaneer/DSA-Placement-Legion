public class SingleNonDuplicateElement {
    public static void main(String[] args) {
        int [] array  = {1,1,2,3,3,4,4,8,8};
        // System.out.println(binarySearchNonDuplicate(array, 0, array.length-1));
        System.out.println(binarySearchBruteNonDuplicateXor(array));
        System.out.println(binarySearchBruteNonDuplicateOther(array));
        System.out.println(binarySearchBruteNonDuplicate(array));
    }

    //!BRUTE: Linear Search - XOR  TC: O(n) SC: O(1)
    static int binarySearchBruteNonDuplicateXor(int [] array){
        int xor = 0;
        for(int i=0; i<array.length; i++){
            xor = xor ^ array[i];
        }
        return xor;
    }

    //! BRUTE: Linear Search - Other TC: O(n) SC: O(1)
    static int binarySearchBruteNonDuplicateOther(int [] array){

        for(int i=0; i<array.length; i++){
            if(i == 0){
                if(array[i] != array[i+1]) return array[i];
            }
                else if(i == array.length - 1){
                    if(array[i] != array[i-1]) return array[i];
            }else{
                if(array[i]!= array[i+1] && array[i]!= array[i-1]) return array[i];
            }
        }
        return -1;
    }


    // ! Optimized: BinarySearch - O(log n) SC: O(1)
    static int binarySearchBruteNonDuplicate(int [] array){
        // trimming down the conditions of array[0] and array[n-1] so that we can avoid uglly checks in the code afterwards
        int n = array.length;
        if(n == 1) return array[0];
        if(array[0]!=array[1]) return array[0];
        if(array[n-1]!= array[n-2]) return array[n-1];
        // now binary Search
        int low = 1, high = n-2; // BS on Trimmed Array
        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid]!=array[mid + 1] && array[mid]!= array[mid - 1]) return array[mid];

            // if this is the left half (element is on the right side so eliminate left)
            else if((mid % 2 == 0 && array[mid]== array[mid + 1]) 
            || (mid %2 == 1 && array[mid] == array[mid - 1])){
                low = mid + 1;
            }
            // if this is the right half (element is on the left side so eliminate right)
            else high = mid - 1;
        } 
        return -1;
    }

    //! error (I was trying to call BinarySearch on both ends but got some logical errors)
    // static int binarySearchNonDuplicate(int [] array, int low, int high){
    //     if(low > high) return -1;
    //     int mid = low + (high - low)/2;
    //     int midElement = array[mid];
    //     if(mid == 0 && midElement!=array[mid+1]) return midElement;
    //     else if(mid == (array.length -1) && midElement!=array[mid-1]) return midElement;
    //     else if(midElement != array[mid-1] && midElement!= array[mid+1]) return midElement;
    //     else {
    //         if(midElement==array[mid-1]) {
    //             int leftHalf = binarySearchNonDuplicate(array, low, mid-2);
    //             if(leftHalf!=-1) return leftHalf;
    //         }
    //         if(midElement== array[mid+1]) {
    //             int rightHalf = binarySearchNonDuplicate(array, mid+2, high);
    //             if(rightHalf!=-1) return rightHalf;
    //         }
    //     }        
    //     return -1;
    // }
}
