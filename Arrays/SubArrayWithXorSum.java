
import java.util.HashMap;
import java.util.Map;

// Problem Statement: 
// Given an array of integers A and an integer B. 
// Find the total number of subarrays having bitwise XOR of all elements equal to k.


public class SubArrayWithXorSum {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 6, 4};
        int n = 6;
        System.out.println(subArrayWithXorSumOptimal(array, n));
        System.out.println(SubArrayWithXorSumBrute(array, n));
        System.out.println(SubArrayWithXorSumBetter(array, n));


    }

    // Brute: TC: O(n^3) SC: O(1) | trying all subArrays with 3 loops
    static int SubArrayWithXorSumBrute(int [] array, int n){
       
        int counter = 0;
        for(int i = 0; i<array.length; i++){
            for(int j = i; j<array.length;j++){
                int xor = 0;
                for(int k = i; k<=j; k++){
                    xor = xor ^ array[k];
                }
                if(xor == n) counter++;
            }
        }

        return counter;
    }
    // Better: TC: O(n^2) SC: O(1) | trying all subArrays with 2 loops
    static int SubArrayWithXorSumBetter(int [] array, int n){
        int counter = 0;
        for(int i = 0; i<array.length; i++){
            int xor = 0;
            for(int j = i; j<array.length;j++){
                 xor = xor ^ array[j];
                if(xor == n) counter++;
            }
        }

        return counter;
    }
    // Optimal: TC: O(nlogn) SC: O(n) | prefixSum concept
    static int subArrayWithXorSumOptimal(int [] a, int k){
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: 
            // as we know,
            // xr = x ^ k
            // taking '^k' on both sides
            // xr ^ k = x ^ k ^ k
            // x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;    
    }

}
