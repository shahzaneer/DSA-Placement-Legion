
public class NthRoot {
    public static void main(String[] args) {
        // System.out.println(nthRoot(16, 4));
        // System.out.println(nthRootOptimal(16, 4));

        // System.out.println(nthRoot(69, 4));
        // System.out.println(nthRootOptimal(69, 4));

        System.out.println(power(2, 5));

        
    }

    // ! BRUTE: TC: O(n* logm) SC: O(1)
    // it will return answer if found and if not return -1 showing the Answer was not found
    static int nthRoot(int num, int m){
        for(int i = 0; i<=num; i++){
            if(Math.pow(i, m) == num) return i;
            else if( Math.pow(i, m) > num) break;
        }
        return -1;
    }
    // ! OPTIMAL: TC: O(logn * logm) SC: O(1)
    static int nthRootOptimal(int num, int m){
        int low = 1, high = num;
        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(Math.pow(mid, m) == num) return mid;
            else if(Math.pow(mid, m) > num) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }



// ! TIDBITS: The time complexity of Math.pow
//  The time complexity of Math.pow in Java depends on the implementation used by the specific JVM. However, most modern JVMs employ algorithms that have a time complexity of O(log n) where n is the exponent. This means that the time taken by Math.pow increases logarithmically with the size of the exponent.
// This is a significant improvement over the naive implementation that would have a time complexity of O(n). The logarithmic time complexity of Math.pow is achieved by using a technique known as exponentiation by squaring.
// Here's a brief explanation of the exponentiation by squaring algorithm:
// If the exponent is 0, return 1.
// If the exponent is 1, return the base.
// If the exponent is even, recursively calculate the result for n/2 and square it.
// If the exponent is odd, recursively calculate the result for (n-1)/2, square it, and multiply it by the base.

//! lets Implement it 
// TC : O(log n)
static int power(int base, int exponent) {
    if (exponent == 0) return 1; 
    if (exponent == 1) return base;
    int n = exponent;
    int answer = 1;

    while (n > 0) {
        if (n % 2 == 1) {
            answer = answer * base;
            n = n - 1;
        }
        base *= base;
        n = n / 2;
    }
    return answer;
}
}
