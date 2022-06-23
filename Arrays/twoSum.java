package Arrays;


//! Question
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. 

public class twoSum {

    public int[] twoSummation(int[] nums, int target) {
        int arr [] = new int [2];
        for (int i = 0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
                
            }
            
        }
       
        return arr;
    }
}
    
