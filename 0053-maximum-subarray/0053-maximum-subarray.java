class Solution {
    public int maxSubArray(int[] array) {
        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum+=array[i];
            if (sum > maximumSum) maximumSum = sum;
            if(sum < 0) sum = 0;
            // if(maximumSum < 0) maximumSum = array[i];
        }
        return maximumSum;
    }
}