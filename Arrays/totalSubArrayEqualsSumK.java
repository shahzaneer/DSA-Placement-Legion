public class totalSubArrayEqualsSumK {
    public static void main(String[] args) {
        int [] array = {1,2,3};
        System.out.println(totalSubArraysWithSumKBrute(array, 3));
        System.out.println(totalSubArraysWithSumKBetter(array, 3));

    }
    // Given an array of integers nums and an integer k, 
    // return the total number of subarrays whose sum equals to k.

    //! Brute: TC: O(n^3) SC:O(1)
    static int totalSubArraysWithSumKBrute(int [] array, int k){
        int counter = 0;
        // Explore all possible subArrays and increase counter if sum is equal to k
        for(int i=0; i<array.length;i++){
            for(int j = i; j<array.length;j++){
                int sum = 0;
                for(int l = i; l<=j; l++){
                    sum+=array[l];
                }
                if(sum == k) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //! Better: TC: O(n^2) SC: O(1)
    static int totalSubArraysWithSumKBetter(int [] array, int k){
        int counter = 0;
        // Explore all possible subArrays and increase counter if sum is equal to k
        for(int i=0; i<array.length;i++){
            int sum = 0;
            for(int j = i; j<array.length;j++){
                sum+=array[j];
                if(sum == k ) {
                    counter++;
                }

            }
        }
        return counter;
    }
}
