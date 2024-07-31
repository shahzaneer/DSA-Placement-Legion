class Solution {
    public int majorityElement(int[] array) {
         int count = 0;
        int element = array[0];
        for(int i=0; i<array.length; i++){
            if(count == 0){
                element = array[i];
                count = 1;
            }
            else if(array[i]==element){
                count++; 
            }
            else if (array[i]!=element){
                count--;
            }
        }
return element;
        // for checking if the element that might be the majority element is actually the majority element or not?
        // int count1 = 0;
        // for(int i=0; i<array.length; i++){
        //     if(array[i] == element) count1++;
        // }

        // if(count1 > array.length/2) return element;
        // return -1;
    }
}