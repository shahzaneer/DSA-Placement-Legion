public class CountOccurences {
   public static void main(String[] args) {
    int [] array = {1,2,3,4,5,6,7,7,7,7,7,8,9};
    System.out.println(countOccurences(array, 7));
   }

   static int countOccurences(int [] array, int target){
    int [] firstAndLast = firstAndLastOccurence(array, target);
    if(firstAndLast[0] == -1) return 0;
    else return firstAndLast[1] - firstAndLast[0] + 1;
   }
   static public int[] firstAndLastOccurence(int[] nums, int target) {
    int firstOccur = firstOccurrenceOptimal(nums, target);
    if(firstOccur == -1) return new int [] {-1,-1};
    int lastOccur = lastOccurrenceOptimal(nums, target);
    return new int [] {firstOccur, lastOccur};
}


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
    if(upperBound == array.length) return -1;
    int lastOccurrence = upperBound - 1;
    return lastOccurrence;
}


}
