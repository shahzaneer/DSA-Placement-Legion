
import java.util.HashMap;

public class longestSubArrayWithSumZero {
    public static void main(String[] args) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(longestSubArrayWithSumZeroBrute(a));
        System.out.println(longestSubArrayWithSumZeroOptimal(a));
    }

    // Brute: TC: O(n^2) SC: O(1) - Try all subArrays
    static int longestSubArrayWithSumZeroBrute(int [] array){
        int maximumLength = 0;
        for(int i = 0; i<array.length;i++){
            int sum = 0;
            for(int j = i; j<array.length; j++){
                sum+=array[j];
                if(sum == 0) maximumLength = Math.max(maximumLength, j-i + 1);
            }
        }
        return maximumLength;
    }
    // Optimal: TC: O(nlogn) SC: O(n) - Prefix Sum concept
    static int longestSubArrayWithSumZeroOptimal(int [] array){
        int maximumLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); //(prefixSum, index)
        int sum = 0;
        for(int i = 0; i<array.length; i++){
            sum+=array[i];
            if(sum == 0) maximumLength = i+1;
            else{
                if(map.containsKey(sum)){
                    maximumLength = Math.max(maximumLength, i - map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return maximumLength;
    
    }
}
