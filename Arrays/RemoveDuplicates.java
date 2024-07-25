import java.util.HashSet;
import java.util.Iterator;
// Remove Duplicates in Sorted Array [Inplace]
class RemoveDuplicates{
    public static void main(String[] args) {
        int [] array1 = {1,1,2};
        int n = removeDuplicatesBruteForce(array1);

        int [] array2 = {4,4,1,2,3,4,4};
        int l = removeDuplicatesInplace(array2);
        
        
        int [] array = {1,1,2,2,3,4,4};
        int k = removeDuplicatesOptimized(array);

        for(int i=0; i<k; i++){
            System.out.print(array[i] +" ");
        }
    }

// Brute Force TC: O(nlogn) + SC: O(n)
static int removeDuplicatesBruteForce(int [] array){
    HashSet<Integer> uniqueElements = new HashSet<>();
    
    for(int i = 0; i< array.length;i++){
        uniqueElements.add(array[i]);
    }
    Iterator<Integer> it = uniqueElements.iterator();
    int i = 0;
    while (it.hasNext()) {
        array[i] =  it.next();
        i++;        
    }
    return  uniqueElements.size() - 1;

    }   

// Better TC: O(n^2) + SC: O(1)
static int removeDuplicatesInplace(int [] array){
    int pivot = 0;
    int j = array.length - 1;
    while(pivot!=j){
        for(int i = pivot+1; i<=j; i++){
            if(array[pivot] == array[i]){
                swap(array, i, j);
                j--;
            }
        }
        pivot++;
    }
    return j;
}    
static void swap(int [] array,int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

// Optimized TC: O(n) + SC: O(1)
static int removeDuplicatesOptimized(int [] array){
    int i = 0;
    for(int j = 0; j< array.length; j++){
        if(array[i]!=array[j]){
            i++;
            array[i] = array[j];
        }
    }
    return i+1;
}

}