class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int onesCounter = 0;
        int onesCounterPrev = 0;
        for(int i= 0; i<nums.length;i++){
            if(nums[i] == 1){
                onesCounter++;
            }
            if(nums[i] == 0 || i == nums.length - 1){
                if(onesCounter > onesCounterPrev){
                onesCounterPrev = onesCounter;
                }
                onesCounter = 0;
            }
        }

        return onesCounterPrev;
    }
}