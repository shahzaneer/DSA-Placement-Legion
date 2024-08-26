public class KokoBananas {
    public static void main(String[] args) {
        int[] piles = {7, 15, 6, 3};
        int deadlineHours = 8;
        System.out.println(kokosSpeedPerHour(piles, deadlineHours)); 
         System.out.println(kokosSpeedPerHourOptimal(piles, deadlineHours));
    }
    // KOKO Eating Bananas   
    //! Brute: TC:   O(maximum(piles) * O(n)[pilesArray])
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

    static int kokosSpeedPerHour(int [] piles, int deadlineHours){
        int maxOfpiles = maximum(piles);
        for(int i=1; i<maxOfpiles; i++){
            int hoursToEatBananas =  CountTotalHours(piles, i);
            if(hoursToEatBananas <= deadlineHours) return i;
        }
        return -1; // dummy return statement
    }
    //! Optimal: TC: O(log (maxOfPiles) * n(pilesArray)) 

    static int kokosSpeedPerHourOptimal(int [] piles, int deadlineHours){
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
}
