import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes{
        // ! find prime numbers upto N

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(20)));
    }

    // ! the most optimized Solution Normally:
    // ! TC: O(sqrt(n) * n) SC: O(n)
    static ArrayList<Integer> primeDivisorsOptimized(int number){
        ArrayList<Integer> primeDivisors = new ArrayList<>();
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i == 0){
                primeDivisors.add(i);

                while (number % i == 0) {
                    number = number / i;
            }
            } 
        }
        if(number!= 1) primeDivisors.add(number);
        return primeDivisors;    
    }

    // ! TC: O(n + n(log(log n)) + n) SC: O(n)
    static boolean [] sieveOfEratosthenes(int number){
        // Step 1 Pre-Computation
        boolean [] isPrime = new boolean [number+1];
        // Step 2 Initialization:  O(n)
        for(int i = 2; i<number; i++){
            isPrime[i] = true;
        }
        // Step 3: include the first prime and exclude its multiples
        // TC: O(n * (log(log n))
        for(int i=2; i<=Math.sqrt(number); i++){
            if(isPrime[i] == true){
                for(int j = i*i; j<number; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        // Step 4: access the prime number in O(1) and all numbers in O(n)
        for(int i = 2; i<number; i++){
            if(isPrime[i]) System.out.print(i + " ");
        }

        return isPrime;

    }

    

}



