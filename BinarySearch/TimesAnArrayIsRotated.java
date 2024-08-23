
public class TimesAnArrayIsRotated {
// Given is a partially sorted array which is rotated by n times aand by rotating it n times it was made partially sorted
// so we have to tell how many times it was rotated.
// if we find out the the index of minimum value it will be our answer (do it on pen and paper)

    public static void main(String[] args) {
        int [] array = {4,5,6,7,1,2,3};
        System.out.println(timesArrayIsRotated(array));
   
    }

    static int timesArrayIsRotated(int [] array){
        int rotationTimes = -1;
        int minElement = Integer.MAX_VALUE;
        int low = 0;
        int high = array.length - 1;
    
        while(low <= high){
            int mid = low + (high - low)/2;
            // Left is sorted
            if(array[low] <= array[mid]){
                if(array[low] < minElement){
                    rotationTimes = low;
                    minElement = array[low];
                }
                // go to the right part now
                low = mid + 1;
            }
            else{
                if(array[mid] < minElement){
                    rotationTimes = mid;
                    minElement = array[mid];
                }
            // go to the left part now
                high = mid - 1;
    
            }
        }
        return rotationTimes;
    
    }
    
    
}

