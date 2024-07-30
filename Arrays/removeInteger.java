
import java.util.Arrays;

public class removeInteger {
    public static void main(String[] args) {
        int [] array = {3,2,2,3};
        
        System.out.println(removeElement(array, 3));
        System.out.println(Arrays.toString(array));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while( i < j){
            // finding non-val at j
            while(nums[j] == val && i<j){
                j--;
            }
            // finding val at i
            while(nums[i] != val && i<j){
                i++;
            }
            swap(nums, i, j);

        }

        return i+1;
    }

    static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
