public class splitArrayLargestSum {
    
// Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. 
// Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized.
//  Your task is to return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

//! Brute: TC: O(n*n) SC: O(1)
static int countSplits(int [] array, int minimizedLargestSum){
    int countSplits = 1, arraySum = 0;
    for(int i=0; i<array.length; i++){
        if(arraySum + array[i] <= minimizedLargestSum){
            arraySum+= array[i];
        }
        else{
            countSplits++;
            arraySum = array[i];
        }
    }
    return countSplits;
}
static int minimizedLargestSum(int [] array, int k){
    int max = Integer.MIN_VALUE;
    int sum = 0;
for(int i=0; i<array.length; i++){
    max = Math.max(array[i], max);
    sum+= array[i];
}

for(int i= max; i<=sum; i++){
    if(k == countSplits(array,i)){
        return i;
    }

}
return -1;
}

static int minimizedLargestSumOptimal(int [] array, int k){
    int max = Integer.MIN_VALUE;
    int sum = 0;
for(int i=0; i<array.length; i++){
    max = Math.max(array[i], max);
    sum+= array[i];
}

    int low = max, high = sum;
    int ans = -1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(k >= countSplits(array, mid)){
            ans = mid;
            high = mid - 1;
        }
        else low = mid + 1;
    } 
    return ans;

}



//! Optimal: TC: O(n log n) SC: O(1) 
    public static void main(String[] args) {
        int [] array = {10, 20, 30, 40};
        System.out.println(minimizedLargestSum(array, 2));
        System.out.println(minimizedLargestSumOptimal(array, 2));
    }
}
