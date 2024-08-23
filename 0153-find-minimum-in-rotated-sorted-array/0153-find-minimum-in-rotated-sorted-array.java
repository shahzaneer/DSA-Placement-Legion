class Solution {
    public int findMin(int[] array) {
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