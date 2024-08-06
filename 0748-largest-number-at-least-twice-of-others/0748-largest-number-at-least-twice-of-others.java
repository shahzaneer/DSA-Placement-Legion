class Solution {
    public int dominantIndex(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        int secondMaxElement = Integer.MIN_VALUE;
        int indexMax = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > maxElement){
                secondMaxElement = maxElement;
                maxElement = nums[i];
                indexMax = i;
            }
            else if(nums[i] > secondMaxElement && nums[i]!= maxElement){
                secondMaxElement = nums[i];
            }
        }

        if (secondMaxElement* 2 <= maxElement) return indexMax;
        return -1;

    }
}