

public class ShipPackageInDDays {
    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
        System.out.println(shipWithinDaysOptimal(weights, days));

    }   
    
// A conveyor belt has packages that must be shipped from one port to another within D days.
// The ith package on the conveyor belt has a weight of weights[i].
// Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages 
// on the conveyor belt being shipped within D days.

    //! Brute: TC: O(n* (sumOfweights-max+1)) SC: O(1)
    public static int shipWithinDays(int[] weights, int days) {
        // the range of the answer lies between the maximumElement of the weights and the sum of all the weights
        // so first of all finding them.
        int max = Integer.MIN_VALUE, sumOfWeights = 0;
        for(int i=0; i<weights.length; i++){
            sumOfWeights+= weights[i];
            max = Math.max(max, weights[i]);
        }

        for(int capacity = max; capacity<=sumOfWeights; capacity++){
            if(ableToShipWithinRequiredDays(weights, capacity, days) == true) return capacity;
        }

        return -1;
    }
    //! Optimal: TC: O(n* log(sumOfWeights)) SC: O(1)

    public static int shipWithinDaysOptimal(int[] weights, int days) {
        // the range of the answer lies between the maximumElement of the weights and the sum of all the weights
        // so first of all finding them.
        int max = Integer.MIN_VALUE, sumOfWeights = 0;
        for(int i=0; i<weights.length; i++){
            sumOfWeights+= weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sumOfWeights;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ableToShipWithinRequiredDays(weights, mid, days)){
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;
        // as it is equally distributed so we can apply Binary Search on Answers here.
        // for(int capacity = max; capacity<=sumOfWeights; capacity++){
        //     if(ableToShipWithinRequiredDays(weights, capacity, days) == true) return capacity;
        // }

    }

    private static boolean ableToShipWithinRequiredDays(int[] weights, int capacity, int days) {
        int load = 0, daysRequired = 1;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] <= capacity){
                load+= weights[i];
            }else{
                daysRequired++;
                load = weights[i];
            }
        }
        return daysRequired <= days;
    }
}
