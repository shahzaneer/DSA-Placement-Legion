
import java.util.ArrayList;

public class PrimeFactorOfNumber {
    public static void main(String[] args) {
        System.out.println(primeDivisorsBrute(708));
        System.out.println(primeDivisorsBetter(708));
        System.out.println(primeDivisorsOptimal(708));
        System.out.println(primeDivisorsOptimized(708));

    }

    static boolean isPrime(int number){
        int counter = 0;
        for(int i=1; i<=Math.sqrt(number); i++){
            if(number % i == 0){
                counter++;
                if(number/i != i) counter++;
            }
        }
    return counter == 2;
    }
    // ! Brute (basic way) : TC: O(n * sqrt(n)) SC: O(1)
    static ArrayList<Integer> primeDivisorsBrute(int number){
        ArrayList<Integer> primeDivisors = new ArrayList<>();
        for(int i=2; i<number; i++){
            if((number % i == 0) && isPrime(i)){
                primeDivisors.add(i);
            }
        }
        return primeDivisors;    
    }

    // ! Better (squareroot)
    static ArrayList<Integer> primeDivisorsBetter(int number){
        ArrayList<Integer> primeDivisors = new ArrayList<>();
        for(int i=1; i<= Math.sqrt(number); i++){
            if(number % i == 0){
                if(isPrime(i)) primeDivisors.add(i);
                if(number/i != i && isPrime(number/i)) primeDivisors.add(number/i);
            }
        }
        return primeDivisors;
    }
    
    // ! Optimal ()
    static ArrayList<Integer> primeDivisorsOptimal(int number){
        ArrayList<Integer> primeDivisors = new ArrayList<>();
        for(int i=2; i<=number; i++){
            if(number % i == 0){
                primeDivisors.add(i);

                while (number % i == 0) {
                    number = number / i;
            }
            }
            
        }
        return primeDivisors;
    }
    // ! Optimized ()

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


}
