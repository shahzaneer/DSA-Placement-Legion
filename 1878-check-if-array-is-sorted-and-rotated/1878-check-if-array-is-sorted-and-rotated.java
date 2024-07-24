class Solution {
    // concept:
    // - array sorted rotated wo hoti hai jisse aik hi baar rotate kia jaye, jisse baar baar rotate hone ki zarurat pare yani 1 se zyada baar wo rotated sorted array nhi hogi so we will count here.
    public boolean check(int[] nums) {
        int count = 0;
        for(int i = 0; i<=nums.length - 2; i++){
            if(nums[i] > nums[(i+1)]){
                count++;
            }
        }
        if (nums[nums.length-1] > nums[0]) count++;
        return (count <= 1);
    }
}