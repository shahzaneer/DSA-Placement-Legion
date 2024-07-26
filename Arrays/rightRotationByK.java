
import java.util.Arrays;

public class rightRotationByK {
    public static void main(String[] args) {
        int [] array = {3,7,8,9,10,11};
        // rotationRight(array, 2);
        rotateRightOptimal(array, 2);
        System.out.println(Arrays.toString(array));        
    }
 //MY Brute Force: TC: O(n) SC: O(k*n)
 static int [] rightRotateByK(int [] array , int k){
    if(k == 0) 
        return array;
        
    int [] tempArray = new int[array.length];
    int temp = array[array.length- 1];

    for(int i = 0; i<array.length - 1; i++){
        tempArray[i+1] = array[i];
    }
    tempArray[0] = temp;
    array = tempArray;
    return rightRotateByK(array, --k);
    
}

    // Intuitive approach
    static void rotationRight(int [] array, int k){
        int [] tempArray = new int[array.length];

        for(int i = 0; i<array.length; i++){
            int l = (i+ k) % array.length;
            tempArray[l] = array[i];
        }

        for(int i=0; i<array.length;i++){
            array[i] = tempArray[i];
        }
    }

    public static void rotateRightOptimal(int [] array, int k){
        k = k % array.length;
        Reverse(array, 0, array.length - 1);
        Reverse(array, 0, k - 1);
        Reverse(array, k, array.length - 1);
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
