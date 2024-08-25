public class Peak {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        int [] array2 = {6,5,4,3,2,1};
        int [] array3 = {1,2,1,3,1};

        System.out.println(peakElementIndexBrute(array));
        System.out.println(peakElementIndexBrute(array2));
        System.out.println(peakElementIndexBrute(array3));

        System.out.println(peakElementIndexOptimal(array));
        System.out.println(peakElementIndexOptimal(array2));
        System.out.println(peakElementIndexOptimal(array3));


    }
    
    // ! Brute: TC: O(n) SC: O(1)
    static int peakElementIndexBrute(int [] array){
        int n = array.length;
        for(int i = 0; i<array.length; i++){
            // check can be made clear by opening it
            if((i == 0 || array[i] > array[i-1]) && (i == n - 1 || array[i] > array[i+1])){
                return i;
            }
        }
        return -1;
    }
    // ! Optimal: TC: O(log n) SC: O(1) - Binary Search Approach
    static int peakElementIndexOptimal(int [] array){
        int n = array.length;
        if(n == 1) return 0;
        if(array[0] > array[1]) return 0;
        if(array[n-1] > array[n-2]) return n-1;
        int low = 1, high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] > array[mid + 1] && array[mid] > array[mid -1]) return mid;
            else if(array[mid] < array[mid + 1]){
                // mid is on the increasing slope so move to the right
                low = mid + 1;
            }
            else if (array[mid] < array[mid - 1]){
            // mid is on the decreasing slope so move to the right
                high = mid - 1;
            }else{
                // if multiple peaks chose and mid is at the reverse of peak then reduce on any side you want to xD
            //    low = mid + 1;
               high = mid - 1;
            }
        }
        return -1;
    }

}
