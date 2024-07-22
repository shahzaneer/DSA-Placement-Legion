import java.util.Arrays;

public class bubble {
public static void main(String[] args) {
// int [] array = {13,17,15,6,7,9};
//         int [] sortedArray = bubbleSort(array);
//         System.out.println(Arrays.toString(sortedArray));

int [] array = {13,17,15,6,7,9};
        int [] sortedArray = bubbleSortOpmtimized(array);
        System.out.println(Arrays.toString(sortedArray));
}   

static int [] bubbleSort(int [] array){

    for(int i = array.length - 1; i >= 1; i--){
        for(int j = 0; j<= i - 1; j++){
            if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }

    }
    return array;
}

static int [] bubbleSortOpmtimized(int [] array){
    for(int i = array.length - 1; i>=1; i--){
        int didSwap = 0;
        for(int j = 0; j<= i -1; j++){
            if(array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;

                didSwap = 1;
            }
        }
        if(didSwap == 0) break;

    }
    return array;
}
}
