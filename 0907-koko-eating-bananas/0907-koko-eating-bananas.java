class Solution {
    public int minEatingSpeed(int[] piles, int deadlineHours) {
        int low = 1, high = maximum(piles);
        while(low <= high){
            int mid = low + (high - low) / 2;
            int hoursToEatBananas = CountTotalHours(piles, mid);
            if(hoursToEatBananas <= deadlineHours){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    static int maximum(int [] array){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i] > maxi) maxi = array[i];
        }
        return maxi;
    }

    static int CountTotalHours(int [] piles, int suggestedNoOfBananasPerHour){
        int totalHrs = 0;
        for(int i=0; i<piles.length; i++){
            totalHrs +=  Math.ceil((double) piles[i] / (double) suggestedNoOfBananasPerHour) ;
        }
        return totalHrs;
    }

}