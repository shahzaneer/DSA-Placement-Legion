//Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and returns its sum and prints the subarray.
public class maximumSubArraySum {
    public static void main(String[] args) {
        int [] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArraySumBrute(array));
        System.out.println(maximumSubArraySumBetter(array));
        System.out.println(KadaneAlgorithm(array));
        printSubArrayWithGreatestSum(array);

    }
    //Brute Force: TC: O(n^3) SC: O(1)
    static int maximumSubArraySumBrute(int [] array){
        int maximumSum = Integer.MIN_VALUE;
        // Try all sub arrays
        for(int i=0; i<array.length; i++){
            for(int j = i; j<array.length; j++){
                int sum = 0;
                for(int k = i; k<j; k++){
                    sum +=array[k];
                }
                maximumSum = Math.max(sum, maximumSum);
            }
        }
        return maximumSum;

    } 
    //Better: TC: O(n^2) SC: O(1)
    static int maximumSubArraySumBetter(int [] array){
        int maximumSum = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            int sum = 0;
            for(int j = i; j<array.length; j++){
                sum+=array[j];
                maximumSum = Math.max(sum, maximumSum);
            }
        }
        return maximumSum;
    }
    // Optimal: TC: O(n) SC: O(1)
    static int KadaneAlgorithm(int [] array){
        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum+=array[i];
            if (sum > maximumSum) maximumSum = sum;
            if(sum < 0) sum = 0;
        }
        return maximumSum;
    }

    // Printing subArray:
    static void printSubArrayWithGreatestSum(int [] array){
        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex = -1, endIndex = -1;
        for(int i=0; i<array.length; i++){
            if(sum == 0) startIndex = i;
            sum+=array[i];
            if (sum > maximumSum) {
                maximumSum = sum;
                endIndex = i;
            }

            if(sum < 0) sum = 0;
            if(maximumSum < 0) maximumSum = 0;
        }
        for(int i=startIndex; i<=endIndex; i++){
            System.out.print( array[i]+",");
        }
    }
}
