
//! Reverse Digits of A Number

// Given an integer N return the reverse of the given number.
// Note: If a number has trailing zeros, 
// then its reverse will not include them. 
// For e.g., reverse of 10400 will be 401 instead of 00401.

public class ReverseDigitsOfNum {
    public static void main(String[] args) {
        System.out.println(reverseDigits(10400));
        System.out.println(reverseDigitsOptimal(10400));
        
    }

    static int reverseDigits(int num){
        String number = "";
        while (num!=0) {
            int remainder = num%10;
            number+=remainder;
            num = num/10;
        }
        return Integer.parseInt(number);
    }

    static int reverseDigitsOptimal(int num){
        int number = 0;
        while (num!=0) {
            int remainder = num%10;
            number = number * 10 + remainder;
            num/=10;
        }
        return number;
    }
}


// Time Complexity: O(log10N + 1) where N is the input number. 
// The time complexity is determined by the number of digits in the input integer N. 
// In the worst case when N is a multiple of 10 the number of digits in N is log10 N + 1.
// In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
// Space Complexity: O(1) as only a constant amount of additional memory for the reversed number regardless of size of the input number.