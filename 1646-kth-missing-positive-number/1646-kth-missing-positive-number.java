class Solution {
    public int findKthPositive(int[] array, int k) {
        int low = 0; 
        int high = array.length - 1;
        while(low<= high){
            int mid = low + (high-low)/2;
            int missing = array[mid] - (mid + 1);
            if(missing < k) low = mid + 1;
            else high = mid - 1;
        }
        //! Maths Behind.
        // high is now on the left range and low is on the right range of KthMissing
        // ans = array[high] + more
        // more = k - missing
        // missing = array[high] - (high + 1)
        // ans = array[high] + k - missing
        // ans = array[high] + k - (array[high] - high - 1)
        // ans = array[high] + k - array[high] + high + 1
        // ans = k + high + 1;
        return k + high + 1;
    }
}