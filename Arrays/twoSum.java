
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;



//! Question
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. 

public class twoSum {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumHashing(nums, 9)));
        System.out.println(Arrays.toString(twoSummation(nums, 9)));
        System.out.println(Arrays.toString(twoSum(nums, 9)));


    }
// Brute Force: TC: O(n^2) SC: O(1)
    static public int[] twoSummation(int[] nums, int target) {
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

// Better TC: O(n log n) SC: O(n)
static int [] twoSumHashing(int [] array, int target){
    int [] ans = new int [2];
    HashMap<Integer,Integer> hash = new HashMap<>();

    for(int i=0; i<array.length;i++){
        int more = target - array[i];
        if (hash.containsKey(more)){
            int j = hash.get(more);
            ans[0] = i;
            ans[1] = j;
        }
        else{
            hash.put(array[i], i);
        }
    }
    return ans;
}

// Optimized TC:O(n) SC: O(1)
static int [] twoSum(int [] array, int target){
    int left = 0;
    int right = array.length - 1;
    int [] ans = new int [2];
    Arrays.sort(array);

    while (left <= right) { 
        int currentSum = array[left] + array[right];
        if (currentSum == target){
            ans[0] = left;
            ans[1] = right;
            return ans;
        }
        if(currentSum > target) right--;
        else if (currentSum < target) left++;
    }
    return ans;
}
}
    
