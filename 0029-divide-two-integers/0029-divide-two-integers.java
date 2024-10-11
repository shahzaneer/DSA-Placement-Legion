class Solution {
    public int divide(int dividend, int divisor) {
       if(dividend == divisor) return 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;  // Overflow, return maximum integer value
        }

        // Determine the sign of the result
        boolean isNegative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isNegative = true;
        }
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        long powersEleminated = 0;
        while(dividendAbs >= divisorAbs){
            int counter = 0;
            while(dividendAbs >= (divisorAbs << (counter+1))){
                counter++;
            }
            powersEleminated += (1 << counter);
            dividendAbs = dividendAbs - (divisorAbs << counter);
        }

        return isNegative ? (int) -powersEleminated : (int) powersEleminated;

    }
}
