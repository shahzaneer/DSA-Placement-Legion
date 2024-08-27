class Solution {
    public int minDays(int[] array, int m, int k) {
         if((double) m * k > array.length) return -1;

    // we know the range for days will be in between min and max of array (days)
    // so finding them
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++){
        min = Math.min(min,array[i]);
        max = Math.max(max, array[i]);
    }

    int low = min;
    int high = max;
    // int days = 0;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(makingBouquetsAtDay(array, mid, m, k) == true){
            // days = mid;
            high = mid - 1;
        }
        else low = mid+1;
    }
    // for(int day=min; day<=max; day++){  //as it was eqaully distributed so it was done by BS
    //     if(makingBouquetsAtDay(array,day,m,k) == true) return day;
    // } 

    // return days; there is no need of this extra variable as we know by opposite parity principle we will have our answer at low
    return low;
    }

    private static boolean makingBouquetsAtDay(int[] array, int day, int m, int k) {
        int numberOfBouquets = 0; int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]<= day) count++;
            else {
                numberOfBouquets+= count/k;
                count = 0;
            } 
        }
        numberOfBouquets+= count/k;
        return numberOfBouquets >= m;
    }
}