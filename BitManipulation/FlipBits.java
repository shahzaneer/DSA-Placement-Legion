public class FlipBits {
    public static void main(String[] args) {
        
    }

    static int minimumBitsToFlip(int start, int goal){
        int ans = start ^ goal;
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
