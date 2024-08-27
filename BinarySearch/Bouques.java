public class Bouques {
    public static void main(String[] args) {
        int [] array = {7,7,7,7,11,12,13,7};
        int m = 2, k = 3;
        System.out.println(minimumNumberOfDaysToMakeBouquets(array, m, k));
        System.out.println(minimumNumberOfDaysToMakeBouquetsOptimal(array, m, k));
    }

//! Problem Statement:
//  You are given 'N’ roses and you are also given an array 'arr'  
// where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
// You can only pick already bloomed roses that are adjacent to make a bouquet. 
// You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
// Find the minimum number of days required to make at least ‘m' bouquets 
// each containing 'k' roses. Return -1 if it is not possible.

// ! Brute: TC: O(n * (max-min+1)) SC: O(1)
static int minimumNumberOfDaysToMakeBouquets(int [] array, int m, int k){
    if(m * k > array.length) return -1;

    // we know the range for days will be in between min and max of array (days)
    // so finding them
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++){
        min = Math.min(min,array[i]);
        max = Math.max(max, array[i]);
    }

    
    for(int day=min; day<=max; day++){
        if(makingBouquetsAtDay(array,day,m,k) == true) return day;
    }

    return -1;
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


// ! Optimal: TC: O(nlog(max)) SC: O(1)
// ! As we know the range is equally distributed between min and max of days (elements)
// ! so we can apply BinarySearch On answers Technique for optimization
    static int minimumNumberOfDaysToMakeBouquetsOptimal(int [] array, int m, int k){
        if(m * k > array.length) return -1;

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
}
