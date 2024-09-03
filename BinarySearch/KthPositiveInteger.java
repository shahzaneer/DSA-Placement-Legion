public class KthPositiveInteger {
    public static void main(String[] args) {
        int [] array = {2,3,4,7,11};
        System.out.println(missingInteger(array, 5));
        System.out.println(missingIntegerOptimal(array, 5));

    }

    //! Brute: O(n) SC: O(1)
    static int missingInteger(int [] array,int k){
        if(k < array[1]) return k;
        for(int i=0; i<array.length; i++){
            if(array[i] <= k) k++;
            else return k;
        }
        return k;
    }
    // ! Optimal: O(log n) SC: O(1)
    static int missingIntegerOptimal(int [] array, int k){
        if(k < array[1]) return k;
        int low = 0; 
        int high = array.length - 1;
        while(low<= high){
            int mid = low + (high-low)/2;
            int missing = array[mid] - (mid + 1);
            if(missing < k) low = mid + 1;
            else high = mid - 1;
        }
        //! Maths Behind.
        // high is now on the left range and low is on the right range of KthMissing
        // ans = array[high] + more
        // more = k - missing
        // missing = array[high] - (high + 1)
        // ans = array[high] + k - missing
        // ans = array[high] + k - (array[high] - high - 1)
        // ans = array[high] + k - array[high] + high + 1
        // ans = k + high + 1;
        return k + high + 1;
    }
}
