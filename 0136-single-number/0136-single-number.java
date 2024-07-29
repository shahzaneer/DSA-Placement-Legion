class Solution {
    public int singleNumber(int[] array) {
        int xor = 0;
    for(int i=0; i<array.length; i++){
        xor = xor ^ array[i];
    }

    return xor;
    }
}