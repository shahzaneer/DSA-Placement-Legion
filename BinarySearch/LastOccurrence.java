public class LastOccurrence{
    public static void main(String[] args) {
        int [] array = {1,1,2,2,5,6,8};
        System.out.println(lastOccurrenceBrute(array, 2));
        System.out.println(lastOccurrenceOptimal(array, 2));
    }
    // find last occurence
    // ! Brute: O(n)
    static int lastOccurrenceBrute(int [] array, int key){
        for(int i= array.length -1; i>=0; i--){
            if(array[i] == key) return i;
        }
        return -1;
    }
    // ! Optimal: O(log n)
    static int lastOccurrenceOptimal(int [] array, int key){
        int upperBound = array.length;
        int low = 0, high = array.length-1;
        while(low <=high){
            int mid = (low + high)/2;

            if(array[mid] > key){
                upperBound = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        int lastOccurrence = upperBound - 1;
        if(array[lastOccurrence] != key || lastOccurrence == array.length) return -1;
        return lastOccurrence;
    }
}