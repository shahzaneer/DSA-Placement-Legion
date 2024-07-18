
public class Armstrong {
    public static void main(String[] args) {
        System.out.println(isArmStrong(153));
        System.out.println(isArmStrong(371));

    }

    static boolean isArmStrong(int x){
        int countDigits = (int) Math.log10(x) + 1;
        int number = x;
        int newNumber = 0;
        while(number!=0){
            int remainder = number % 10;
            newNumber+= Math.pow(remainder, countDigits); 
            number/=10;
        }

        return x == newNumber;

    }
}


// Space Complexity: O(1) as only a constant amount of additional memory for the reversed number regardless of size of the input number.
// Time Complexity: O(log10N + 1) where N is the input number. The time complexity is determined by the number of digits in the input integer N. In the worst case when N is a multiple of 10 the number of digits in N is log10 N + 1.