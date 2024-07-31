class Solution {
    public void sortColors(int[] array) {
        // DUTCH NATIONAL FLAG ALGORITHM
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