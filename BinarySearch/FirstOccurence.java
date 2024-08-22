
public class FirstOccurence {
 public static void main(String[] args) {
    int [] array = {1,1,2,2,5,6,8};
        System.out.println(firstOccurrenceBrute(array, 2));
        System.out.println(firstOccurrenceOptimal(array, 2));

    
 }  

 // find first occurence
    // ! Brute: O(n)
    static int firstOccurrenceBrute(int [] array, int key){
        for(int i= 0; i<array.length; i++){
            if(array[i] == key) return i;
        }
        return -1;
    }
    // ! Optimal: O(log n)
    static int firstOccurrenceOptimal(int [] array, int key){
    int low = 0;
    int high = array.length - 1;
    // int lowerBound = array.length;
    int firstOccurent = -1;

    while(low <= high){
        int mid = (low + high) / 2;

        // Case 1: we found element or we found element > key (a close answer maybe) 
        if(array[mid] >= key){
            if(array[mid] == key) firstOccurent = mid;
            // lowerBound = mid;
            high = mid - 1;
        }
        // case 2: we were not able to find so reducing searchSpace
        else low = mid + 1;
    }
    
    return firstOccurent;
    }
// Remember lowerBound and UpperBound and you will be able to find every such element in a sorted array with O(logn) time with slight modifications


}
