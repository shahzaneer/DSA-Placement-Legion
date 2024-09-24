public class DivideTwoIntegers {
    public static void main(String[] args) {
     System.out.println(divideTwoIntegersBrute(10, 2));
        
    }

    //! Brute
    static int divideTwoIntegersBrute(int dividend, int divisor){
        boolean isNegative = false;
        if((dividend >0 && divisor < 0) || (dividend < 0 && divisor > 0)) isNegative = true;
        int counter = 0, sum = 0;
        long dividendAbs = Math.abs(dividend), divisorAbs = Math.abs(divisor);
        while(sum + divisorAbs <= dividendAbs){
                counter += 1;
                sum += divisorAbs;
            }

            return isNegative? -counter: counter;
        }

    // ! Optimal: bit-Manipulation
    }

