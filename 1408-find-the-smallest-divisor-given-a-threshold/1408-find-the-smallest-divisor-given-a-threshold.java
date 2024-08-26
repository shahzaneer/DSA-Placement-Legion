class Solution {
    public int smallestDivisor(int[] array, int threshold) {
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
    
     static int sumOfDivisions(int [] array, int divisor){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum+= Math.ceil((double) array[i] / (double) divisor);
        }
        return sum;
    }
}