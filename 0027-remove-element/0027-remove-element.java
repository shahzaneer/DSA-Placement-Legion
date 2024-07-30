class Solution {
    // Dont Care main srfff value ko dekhna hai
    // aik slow pointer 0 se chalana hai aur aik fast moving linearly
    // if arr[i]!=val k array main usse add krden using slow pointer.
    public int removeElement(int[] nums, int val) {
         int index = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    
}