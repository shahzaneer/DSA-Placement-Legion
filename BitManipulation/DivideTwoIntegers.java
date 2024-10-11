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
    public int divideOptimal(int dividend, int divisor) {
        if(dividend == divisor) return 1;
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
            powersEleminated+= (1 << counter);
            dividendAbs = dividendAbs - (divisorAbs << counter);
        }


        return isNegative ? (int) -powersEleminated : (int) powersEleminated;
    }

    }


    // ! Bit Manipulation Concept
    //  d * 2 ^ count
    // is equivalent to
    // d << count
    // d * 2^count = d << count;  
    //! remember this for interviews



//! The range of integers in Java (or most modern programming languages) is determined by the bit-length of the data type. For a 32-bit signed integer, the range is:

//! Minimum Value: -2,147,483,648 (i.e., -2^31)
//! Maximum Value: 2,147,483,647 (i.e., 2^31 - 1)
// Explanation:
// Signed integers use one bit to store the sign (positive or negative) and the remaining 31 bits to store the magnitude.
// The total number of distinct values a 32-bit signed integer can represent is 2^32, split evenly between positive and negative numbers, plus zero.
// Thus, the range is from -2^31 to 2^31 - 1, which is -2,147,483,648 to 2,147,483,647.

// For unsigned integers, the range would be from 0 to 2^32 - 1 but Java's int type is signed by default.