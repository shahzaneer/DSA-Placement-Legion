class Solution {
    public int search(int[] array, int target) {
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
}