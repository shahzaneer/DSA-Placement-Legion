class Solution {
    public int findPeakElement(int[] array) {
        int n = array.length;
        if(n == 1) return 0;
        if(array[0] > array[1]) return 0;
        if(array[n-1] > array[n-2]) return n-1;
        int low = 1, high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] > array[mid + 1] && array[mid] > array[mid -1]) return mid;
            else if(array[mid] < array[mid + 1]){
                // mid is on the increasing slope so move to the right
                low = mid + 1;
            }
            else if (array[mid] < array[mid - 1]){
            // mid is on the decreasing slope so move to the right
                high = mid - 1;
            }else{
                // if multiple peaks chose and mid is at the reverse of peak then reduce on any side you want to xD
            //    low = mid + 1;
               high = mid - 1;
            }
        }
        return -1;
    }
}