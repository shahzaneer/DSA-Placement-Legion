
public class PrimeCheck {
    public static void main(String[] args) {
        System.out.println(isPrime(13));
        System.out.println(isPrime(12));
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

    // Time: O(sqrt(n))
    // Space: O(1)
}
