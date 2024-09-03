
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(MaximumMinimumDistanceToPlaceCows(stalls, k));
        System.out.println(MaximumMinimumDistanceToPlaceCowsOptimal(stalls, k));
    }

//!Brute: TC: O() SC: O(1)
static boolean isPossipleToPlaceCows(int [] stalls, int distance, int noOfCowsToBePlaced){
    int countCows = 1, lastStall = stalls[0];
    for(int i=0; i<stalls.length; i++){
        if(stalls[i] >= distance){
            countCows++;
            lastStall = stalls[i];
        }
        if(countCows >= noOfCowsToBePlaced) return true;
    }
    return false;
}
static int MaximumMinimumDistanceToPlaceCows(int [] stalls, int noOfCowsToBePlaced){
    Arrays.sort(stalls);
    int highestDistance = stalls[stalls.length - 1] - stalls[0]; 
    for(int i=1; i<=highestDistance; i++){
        if(!isPossipleToPlaceCows(stalls, i, noOfCowsToBePlaced))
        return i-1;
    }
    return -1;
}
//! Optimal: TC: O() SC: O(1)

static int MaximumMinimumDistanceToPlaceCowsOptimal(int [] stalls, int noOfCowsToBePlaced){
    Arrays.sort(stalls);
    int low = 1, high = stalls[stalls.length - 1] - stalls[0];
    while (low<=high) {
        int mid = low + (high - low)/ 2;
        if(isPossipleToPlaceCows(stalls, mid, noOfCowsToBePlaced)) low = mid+1;
        else high = mid - 1;
    }
    return high;
}
}
