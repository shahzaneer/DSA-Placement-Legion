class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // the range of the answer lies between the maximumElement of the weights and the sum of all the weights
        // so first of all finding them.
        int max = Integer.MIN_VALUE, sumOfWeights = 0;
        for(int i=0; i<weights.length; i++){
            sumOfWeights+= weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sumOfWeights;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ableToShipWithinRequiredDays(weights, mid, days)){
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;

    }

    private static boolean ableToShipWithinRequiredDays(int[] weights, int capacity, int days) {
        int load = 0, daysRequired = 1;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] <= capacity){
                load+= weights[i];
            }else{
                daysRequired++;
                load = weights[i];
            }
        }
        return daysRequired <= days;
    }
}