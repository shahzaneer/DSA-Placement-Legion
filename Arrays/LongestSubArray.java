
import java.util.HashMap;

public class LongestSubArray {
    public static void main(String[] args) {
        int [] array = {5,2,3,1,1,1,1,1};
        int [] array2 = {2,-1,2,3};
        int [] array3 = {1,0,1};
        int [] array4 = {1,0,0,0,3};
        // System.out.println(longestSubArrayWithSum(array, 5));
        // System.out.println(longestSubArrayWithSum(array2, 3));
        // System.out.println(longestSubArrayWithSum(array3, 1));
        System.out.println(longestSubArrayWithKOptimal(array, 3));

    }
    //! Only for positive Numbers and negative numbers (fails for 0)
    // BruteForce (my): TC: O(n) SC: O(1)
    static int longestSubArrayWithSum(int [] array, int sum){
        int counter = 0;
        int subArrayLength = 0;
        int summation = 0;
        for(int i=0; i<array.length; i++){
            summation+=array[i];
            counter++;
            if(summation == sum){
                if(subArrayLength < counter){
                    subArrayLength = counter;
                    summation = 0;
                    counter = 0;
                } 
            }
        }
        return subArrayLength;
    }

    //! Brute Force ~ TC: O(n^2) SC: O(1) (works for everything fine)
    static int longestSubArrayWithSumBrute(int [] array, int sum){
        int length = 0;
        // Taking all possible subArrays
        for(int i= 0; i<array.length;i++){
            int s = 0;
            for(int j = i; j<array.length;j++){
                s+=array[j];
                if(sum == s)
                    length = Math.max(length, j-i + 1);
            }
        }

        return length;
    }
    
    // ! Positive Numbers + 0 + Negative Numbers: one will be done by using prefix sum concept
    // TC : O(nlogn) SC: O(n)
    static int longestSubArrayWithKOptimal(int [] array,int k){
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxlength = 0;
        int sum = 0;
        for(int i=0; i<array.length;i++){
            sum+=array[i];
            // For the first time only
            if(sum == k){
                maxlength = Math.max(maxlength, i+1); 
            }
            int rem = sum - k;
            if(prefixSumMap.containsKey(rem)){
                int len = i - prefixSumMap.get(rem);
                maxlength = Math.max(maxlength, len);
            }

            // we will add everytime the prefix sum and where it appeared except
            // in the case of findint that number previously we dont update it as we want to get the left most index to gain longest subarray length
            // Zero's condition
            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum, i);
            }

        }

        return maxlength;
    }

    static int longestSubArrayWithKTwoPointers(int [] a, int k){
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
    
}
