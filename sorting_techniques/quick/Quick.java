import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,1,1,9,8,7,6};
    int [] sortedArray = quickSort(array);
    System.out.println(Arrays.toString(sortedArray));
    }

    static int [] quickSort(int [] array){
        quickSortHelper(array, 0, array.length -1);
        return array;
    }
    
    static void quickSortHelper(int [] array, int low, int high){
        if(low < high){
            int partitionIndex = pivotPlacement(array, low , high);
            quickSortHelper(array, low, partitionIndex-1);
            quickSortHelper(array, partitionIndex+1, high); 
        }
    }

    static int pivotPlacement(int[] array, int low, int high) {
        int pivotElement = array[low];
        int i = low;
        int j = high;
        while(i < j){
            while(array[i]<= pivotElement && i<=high - 1){
                i++;
            }
            while(array[j]> pivotElement && j >= low - 1){
                j--;
            }
            if( i< j) swap(array,i,j);
        }

        swap(array, low, j);
        return j;
    }

    static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
    }

}
