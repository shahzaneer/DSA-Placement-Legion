import java.util.ArrayList;

public class printDivisors {
    public static void main(String[] args) {
        System.out.println(divisorsBruteForce(36));
        System.out.println(divisorsOptimal(36));
    }

    static ArrayList<Integer> divisorsBruteForce(int num){
        ArrayList<Integer> divisors = new ArrayList<>();

        for(int i = 1; i<=num; i++){
            if(num % i == 0) divisors.add(i);
        }
        return divisors;

        // Time: O(n)
        // Space O(n)
    }

    static ArrayList<Integer> divisorsOptimal(int num){
        ArrayList<Integer> divisors = new ArrayList<>();
        // careful observation of the factors scene >
        for(int i=1; i<= Math.sqrt(num); i++){
            if(num % i == 0){
                divisors.add(i);
                if(num/i != i) divisors.add(num/i);
            }
        }
        return divisors;
        // Time: O(sqrt(n))
        // Space: O(n)
    }
}
