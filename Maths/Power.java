public class Power {
    public static void main(String[] args) {
        
    }

    //! Brute: TC: O(N) SC: O(1)
    static int pow(int base, int index){
        int ans = 1;
        for(int i=1; i<=index; i++){
            ans = ans * base;
        }
        return ans;
    }
    //! Optimal: TC: O(log2 n) SC : O(1) 
    static int powOptimized(int base, int index){
        int ans = 1;
        if (index == Integer.MIN_VALUE) {
            base = base * base;
            index = index / 2;
        }
        int indSign = index;

        int power = Math.abs(index);
        while(power > 0){
            if(power % 2 == 1){
                ans = ans * base;
                power = power - 1;
            }
            else{
                base = base * base;
                power = power/2;
            }
        }

        if(indSign < 0) return (1/ans);
        return ans;
    }
}
