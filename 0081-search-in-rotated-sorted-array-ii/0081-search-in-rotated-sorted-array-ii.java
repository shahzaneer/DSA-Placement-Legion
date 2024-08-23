class Solution {
    public boolean search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == target) return true;

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
        return false; // you didn't find that element.
    }
}