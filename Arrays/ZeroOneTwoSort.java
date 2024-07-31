import java.util.Arrays;

public class ZeroOneTwoSort {
    public static void main(String[] args) {
        int [] array = {1,2,1,2,2,1,0,0,1};
        // sortCount(array);
        dutchNationalAlgoCount(array);
        System.out.println(Arrays.toString(array));

    }

    // Sort an Array in which only 0's 1's and 2's are present
    // BruteForce: any sorting algo
    // Let be merge sort: TC:O(nlogn) SC: O(n)
    void sortZeroOneTwos(int [] array){
        // Merge.MergeSort(array);
    }
    
    // Better by counting
    // TC: O(2n) SC: O(1)
    static void sortCount(int [] array){
        int zeros = 0, ones = 0, twos = 0;
        for(int i=0; i<array.length; i++){
            switch (array[i]) {
                case 0 -> zeros++;
                case 1 -> ones++;
                case 2 -> twos++;
            }
        }

        for(int i=0; i<zeros; i++){
            array[i] = 0;
        }
        for(int i=zeros; i<zeros+ones; i++){
            array[i] = 1;
        }
        for(int i=zeros+ones; i<array.length; i++){
            array[i] = 2;
        }
    }

    // Can you do it in a single pass?
    // Yes
    // by using Dutch National Flag Algorithm (three pointer)
    // TC: O(n) SC: O(1)
    static void dutchNationalAlgoCount(int [] array){
        int low = 0, mid = 0, high = array.length - 1;

        while(mid <= high){
            if(array[mid] == 0){
                swap(array, low, mid);
                low++;
                mid++;
            }
            else if(array[mid] == 1){
                mid++;
            }
            else{
                // (array[mid] == 2)
                swap(array, mid, high);
                high--;
            }
        }
    }

    static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
