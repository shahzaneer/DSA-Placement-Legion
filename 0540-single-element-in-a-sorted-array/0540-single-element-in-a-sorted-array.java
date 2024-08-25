class Solution {
    public int singleNonDuplicate(int[] array) {
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
}