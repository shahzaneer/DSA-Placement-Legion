class Solution {
    public int subarraySum(int[] array, int k) {
         int counter = 0;
        // Explore all possible subArrays and increase counter 
        // if sum is equal to k
        for(int i=0; i<array.length;i++){
            int sum = 0;
            for(int j = i; j<array.length;j++){
                sum+=array[j];
                if(sum == k) {
                    counter++;
                }

            }
        }
        return counter;
    }
}