
import java.util.Arrays;

// !Find Second Smallest and Second Largest Element in an array
// Without Sorting
// Approach: find largest/smallest and then traverse and find the secondlargest by stating the condition + array[i]!=largest/smallest
// it can be done in two passes or a single pass


public class SecondLargestSmallest {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,99,19};
        System.out.println(secondLargest(array));
        System.out.println(secondSmallest(array));
        secondSmallestLargest(array);
        
    }

    // Brute Force approach (with sorting)
    static void secondSmallestLargest(int [] array){
        Arrays.sort(array);        
        System.out.println("Second Smallest "+ array[1]);
        System.out.println("Second Largest " + array[array.length-2]);        
    }

    // Optimized approach without sorting in O(n)
    static int secondLargest(int [] array ){
       if( array.length -1 <= 2) return -1;

       int largest = Integer.MIN_VALUE;
       int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i<array.length; i++){
            if(array[i] > largest){
                // Saving previous largest to the secondLargest and current largest to the largest
                secondLargest = largest;
                largest = array[i];
            }
            else if(array[i] > secondLargest && array[i]!=largest){
                secondLargest = array[i];
            }     
        }
        return secondLargest;
    }


    static int secondSmallest(int [] array){
        if(array.length -1 <= 2) return -1;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i<array.length; i++){
            if(array[i] < smallest){
                secondSmallest = smallest;
                smallest = array[i];
            }
            else if (array[i] < secondSmallest && array[i]!= smallest) {
                secondSmallest = array[i];    
            }
        }

        return secondSmallest;
    }

}
