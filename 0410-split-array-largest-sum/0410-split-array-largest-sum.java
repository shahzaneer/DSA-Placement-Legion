class Solution {
    public int splitArray(int[] array, int k) {
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

}