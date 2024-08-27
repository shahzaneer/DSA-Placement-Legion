public class SmallestDivisorThreshold {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5};
        int threshold = 8;
        System.out.println(smallestDivisorInThreshold(array, threshold));
        System.out.println(smallestDivisorInThresholdOptimal(array, threshold));
    }

    // You are given an array of integers 'arr' and an integer 
    // i.e. a threshold value 'limit'. 
    // Your task is to find the smallest positive integer divisor, 
    // such that upon dividing all the elements of the given array by it,
    //  the sum of the division's result is less than or equal to the given threshold value.

    //! Brute: TC: O(n * n) SC: O(1)
    static int sumOfDivisions(int [] array, int divisor){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum+= Math.ceil((double) array[i] / (double) divisor);
        }
        return sum;
    }

    static int smallestDivisorInThreshold(int [] array, int threshold){
        if(array.length > threshold) return -1;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            max = Math.max(array[i], max);
        }

        for(int i =1; i<=max; i++){
            if(sumOfDivisions(array, i) <= threshold) return i;
        }
        return -1;
    }
    //! Optimal: TC: O(log n * n) SC: O(1) -> Binary Search On Answers 
    // always find the range first else everything is easy

    static int smallestDivisorInThresholdOptimal(int [] array, int threshold){
        if(array.length > threshold) return -1;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            max = Math.max(array[i], max);
        }

        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(sumOfDivisions(array, mid) <= threshold) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

}
