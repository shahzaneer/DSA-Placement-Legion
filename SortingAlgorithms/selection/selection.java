import java.util.Arrays;

public class selection{
    public static void main(String[] args) {
        int [] array = {13,17,15,6,7,9};
        int [] sortedArray = selectionSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    static int [] selectionSort(int [] array){
        for(int i=0; i<=array.length - 2; i++){
            int minIndex = i;
            for(int j = i; j<= array.length -1; j++){
                if(array[j] < array[minIndex]) minIndex = j;
            }
            // Swapping
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
        }
       return array; 
    }

}

