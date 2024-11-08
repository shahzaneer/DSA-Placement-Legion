class Solution {
    public int[] nextGreaterElement(int[] array1, int[] array2) {
        int [] nextGreaterElement = new int [array1.length];
        for(int i = 0; i<array1.length; i++){
            nextGreaterElement[i] = ngnleetcodeHelper(array2, array1[i]);
        }
        return nextGreaterElement;
    }

    static int ngnleetcodeHelper(int [] array2, int num){
          for(int i=0; i<array2.length; i++){
            if(array2[i] == num){
                for(int j =i+1; j<array2.length; j++){
                    if(array2[j] > num) return array2[j];
                }  
            }
          }
          return -1;      
    }
}