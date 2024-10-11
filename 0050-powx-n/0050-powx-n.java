class Solution {
    public double myPow(double base, int index) {
        if (index == Integer.MIN_VALUE) {
            base = base * base;
            index = index / 2;
        }

        double ans = 1;
        int indSign = index;

        double power = Math.abs(index);
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

        if(indSign < 0) return (1.0/ans);
        return ans;
    }
}