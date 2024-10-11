
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII {
    public static void main(String[] args) {
        
    }

    // ! Brute: TC: O(nlogm + n) SC: O(n) -> Map
    static int [] singleNumberMap(int [] nums){
        int [] singleNumbers = new int [2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else 
                map.put(nums[i], 0);
        }
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) 
                singleNumbers[i++] = entry.getKey();
        }
        return singleNumbers;

    }
    // ! Optimal: TC: O(2n) SC: O(1) -> Bit Manipulation (concept of buckets)
    static int [] singleNumberBit(int [] nums){
        int xor = 0;
        int bucket1 = 0, bucket2 = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        // minimum of 1 bit will be there you have to find that bit that creates the difference
        // if it is non zero then put in bucket 1 and otherwise in bucket2 
        // (xor & (xor - 1) -> finds the first rightmostBit) ^ xor) -> find the rightmostBit pattern

        int rightmostBit = ((xor & (xor - 1)) ^ xor);
        for(int i=0; i<nums.length; i++){
            if((nums[i] & rightmostBit) != 0) bucket1 = bucket1 ^ nums[i];
            else bucket2 = bucket2 ^ nums[i];
        }

        return new int[] {bucket1, bucket2};

    }
}
