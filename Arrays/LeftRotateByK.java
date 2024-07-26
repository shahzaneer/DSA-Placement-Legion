
import java.util.Arrays;

public class LeftRotateByK {
    public static void main(String[] args) {
        int [] array = {3,7,8,9,10,11};
        // System.out.println(Arrays.toString(rightRotateByK(array, 3)));
        // rightRotateByKBruteForce(array, 3);
        rotateleftByKOptimal(array, 2);

        System.out.println(Arrays.toString(array));

    }
    // Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left 
    // Output: 9 10 11 3 7 8
    // Explanation: Array is rotated to right by 3 position.

   static void leftRotateIntuitive(int [] array, int k){
    int [] tempArray = new int[array.length];

    for(int i = 0; i<array.length; i++){
        int l = (k - i) % array.length;
        tempArray[l] = array[i];
    }
    for(int i=0; i<array.length; i++){
        array[i] = tempArray[i];
    }
   }

    // BruteForce again
    // TC: O(n) SC(d)
    // if rotation = 3 ki ho tou first three elements ko copy kr k end main pohanchana hai aur kaion ko front men lanaa hai.
    static void leftRotateByKBruteForce(int [] array, int k){
        int rotation = k % array.length;
        int [] tempArray = new int[rotation];

        for(int i= 0; i<rotation; i++){
            tempArray[i] = array[i];
        }

        for(int i = rotation; i<array.length; i++){
            array[i- rotation] = array[i];
        }

        for(int i= 0; i<rotation; i++){
            array[i+rotation] = tempArray[i];
        }
        
    }

// Optimal with respect to Space Complexity:
// it is said if we first reverse the 0-rotationth elements
// rotationthElement to size elements
// then the whole array we will have our answer
// TC: O(n^2) SP: O(1) 
// ! aka: Reversal Algorithm

static void rotateleftByKOptimal(int [] array, int k){
    // meths
    k = k % array.length;
    Reverse(array, 0, k - 1);
    Reverse(array, k, array.length - 1);
    Reverse(array, 0, array.length - 1);
}
public static void Reverse(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
}
}