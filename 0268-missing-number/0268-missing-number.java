class Solution {
    public int missingNumber(int[] array) {
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < array.length; i++) {
            xor1 = xor1 ^ array[i];
            xor2 = xor2 ^ (i + 1);
        }
        return xor1 ^ xor2;
    }
}