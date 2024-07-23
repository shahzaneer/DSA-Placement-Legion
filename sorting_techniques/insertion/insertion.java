import java.util.Arrays;

public class insertion {
public static void main(String[] args) {
    // int [] array = {13,17,15,6,7,9};
    //     int [] sortedArray = insertionSort(array);
    //     System.out.println(Arrays.toString(sortedArray));
    int [] array = {13,17,15,6,7,9};
        int [] sortedArray = insertionSortRecursive(array, 0);
        System.out.println(Arrays.toString(sortedArray));
}   
 static int [] insertionSort(int [] array){
    for(int i = 0; i <= array.length - 1; i++){
        int j = i;
        while ( j > 0 && array[j-1] > array[j]) { 
            int temp = array[j-1];
            array[j-1] = array[j];
            array[j] = temp;
            j--;
        }
    }
    return array;
 }

 static int [] insertionSortRecursive(int [] array, int n){
   if (n == array.length) return array;
   int j = n;
   while(j > 0 && array[j-1] > array[j]){
    int temp = array[j-1];
            array[j-1] = array[j];
            array[j] = temp;
            j--;
   }
   insertionSortRecursive(array, n+1);
   return array;
 }

}
