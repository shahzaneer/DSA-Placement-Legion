class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        // xor -> when odd 1 then 1 (set) otherwise 0 (unset)
        int bitsToBeFlipped = 0;
        // countTheSetBits you only need to flip those no of bits which are set in answer
        while(ans != 0){
            ans = ans & (ans-1);
            bitsToBeFlipped+=1;
        }
        return bitsToBeFlipped;
    }
}