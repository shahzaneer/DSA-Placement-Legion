class Solution {
    public int searchInsert(int[] array, int target) {
       return lowerBound(array, target); 
    }
    static int lowerBound(int [] array, int key){
    int low = 0;
    int high = array.length - 1;
    int lowerBound = array.length;

    while(low <= high){
        int mid = (low + high) / 2;

        // Case 1: we found element or we found element > key (a close answer maybe) 
        if(array[mid] >= key){
            lowerBound = mid;
            high = mid - 1;
        }
        // case 2: we were not able to find so reducing searchSpace
        else low = mid + 1;
    }
    return lowerBound;
}
}