class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        // generate subArrays
        for(int i=0;i<nums.length; i++){
            int minimumElement = Integer.MAX_VALUE;
            int maximumElement = Integer.MIN_VALUE;
            for(int j=i; j<nums.length; j++){
                // find Max and min for each SubArray
                maximumElement = Math.max(maximumElement, nums[j]);
                minimumElement = Math.min(minimumElement, nums[j]);
                // Add them
                sum += maximumElement - minimumElement;
            }
        }
        return sum;
    }
}