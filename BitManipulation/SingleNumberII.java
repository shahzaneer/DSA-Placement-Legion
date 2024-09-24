import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public static void main(String[] args) {
        
    }
    // !Brute: TC: O(nlogm + n) SC: O(n/3) -> via Map
    static int singleNumber2Map(int [] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+ 1);
            }
            else map.put(nums[i], 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }

        return -1;
    }


    // ! Better: TC: O(nlogn + n) SC: O(1) -> Sorting and skipping
    static int singleNumber2SortingAndSkipping(int [] nums){
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i=i+3){
            if(nums[i]!= nums[i-1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    // ! Optimal: TC: O(n) Sc: O(1) -> Bucket Method (highly ~intuitive)
    static int singleNumber2BitManipulation(int [] nums){
        int ones = 0, twos = 0;
        for(int i=0; i<nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos; // (adding to the bucket of ones if not in twos and deleting from ones)
            twos = (twos ^ nums[i]) & ~ones;  // (adding to the bucket of twos if not in ones and deleting from twos)
        }
        // at the end of day we will be having only one left in ones
        return ones;
    }

}
