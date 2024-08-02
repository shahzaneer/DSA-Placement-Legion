class Solution {
    public int[] getConcatenation(int[] array) {
        int [] newArray = new int [2 * array.length];
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
            newArray[i+array.length] = array[i];
        }
        return newArray;
    }
}