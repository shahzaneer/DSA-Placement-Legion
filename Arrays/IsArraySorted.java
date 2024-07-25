public class IsArraySorted {
    public static void main(String[] args) {
        int [] array1 = {1,2,3,4,5};
        int [] array2 = {1,5,3,9};
        System.out.println(isSorted(array1));
        System.out.println(isSorted(array2));

    }
    static boolean isSorted(int [] array){
        for(int i=0; i<=array.length - 2; i++){
            if(array[i] > array[i+1]) return false;
        }
        return true;
    } 
}
