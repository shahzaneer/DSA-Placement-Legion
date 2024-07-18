import java.util.ArrayList;

public class gcd {
    public static void main(String[] args) {
        System.out.println(gcdBrainless(3, 12));
        System.out.println(gcdBrute(3, 12)); 
        System.out.println(gcdBetter(3, 12)); 
        System.out.println(gcdEuclideanAlgorithm(3, 12));

    }

    static int gcdBrainless(int num1, int num2){
        int gcd = 1;
        ArrayList<Integer> factorsNum1 = new ArrayList<>();
        ArrayList<Integer> commonFactors = new ArrayList<>();

        for(int i=1; i<=num1; i++){
            if(num1%i == 0){
                factorsNum1.add(i);
            }
        }

        for(int i=1; i<=num2; i++){
            if(num2%i == 0 && factorsNum1.contains(i)){
                commonFactors.add(i);
            }
        }


        for(int i = 0; i<commonFactors.size();i++){
            if(commonFactors.get(i) > gcd){
                gcd = commonFactors.get(i);
            }
        }
        
        return gcd;
    }

    static int gcdBrute(int num1, int num2){
        int gcd = 1;
        for(int i=1; i<=Math.min(num1, num2); i++){
            if( num1 % i == 0 && num2 % 2 == 0) gcd = i;
        }
        return gcd;

// Time Complexity: O(min(N1, N2)) where N1 and N2 is the input number. The algorithm iterates from 1 to the minimum of N1 and N2 and each iteration checks whether both the numbers are divisible by the current number (constant time operations).

// Space Complexity: O(1)as the space complexity remains constant and independent of the input size. Only a fixed amount of memory is required to store the integer variables.
    }

    static int gcdBetter(int num1 , int num2){
        // peechay se if mil gya common factor tou wohi largest common factor hoga
        // LCM GCF HCF  
        // aur early return will help us to reduce the no if iterations.
        int gcd = 1;
        for(int i = Math.min(num2, num1); i>=1; i++){
            if(num1 % i == 0 && num2 % i ==0){
                gcd = i;
                return gcd;
            }
        }
        return gcd;

    }

    static int gcdEuclideanAlgorithm(int num1 , int num2){
        while(num1 > 0 && num2 > 0){
            if(num1 > num2) num1 = num1 % num2;
            if (num2 > num1) num2 = num2 % num1;
        }
        if (num1 == 0) return num2;
        return num1;

        // TIME: O(log fie ^ min(num1,num2))
        // Space: O(1)
    }
}
