class Solution {
    public void moveZeroes(int[] array) {
      int pointer = 0;
        for(int i = 0; i<array.length;i++){
          if(array[i] != 0){
              array[pointer] = array[i];
              pointer++;
          }     
        }
        
        for(int i= array.length-1; i>=pointer;i--){
          array[i] = 0;
        }
      }
}