public class Atoi {
    public static void main(String[] args) {
        System.out.println('0' - '0');
    }

    // ! AKA as Atoi
    static int StringToInt(String s){
        int index = 0;
        int length = s.length();
        int total = 0;
        int sign = 1;

        // Skipping leading spaces
        while(index < length && s.charAt(index) == ' ') index++;

        if(index < length &&  (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '+'? 1:-1;
            index++;

        }
        
        while(index < length){
            // Conversion of '1' into 1
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            // Overflow case:
            if(total > Integer.MAX_VALUE/10 || total == Integer.MAX_VALUE/10 &&  Integer.MAX_VALUE%10 < digit)
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            // Making the int total and adding it to digit
            total = total * 10 + digit;
            index++;    
        }        
        return total * sign;
    }


// 1. Checking if total is Too Large:
// Condition 1: total > Integer.MAX_VALUE / 10
// This checks if multiplying total by 10 (to accommodate the next digit) would exceed Integer.MAX_VALUE.
// If total is more than 2,147,483,647 / 10 (which is 214748364), then multiplying it by 10 will definitely exceed the maximum integer value.
// 2. Checking the Last Digit:
// Condition 2: total == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit
// This checks if total is exactly 214748364 (which is Integer.MAX_VALUE / 10).
// If the next digit (let's say digit) is greater than 7 (the last digit of 2,147,483,647), then adding it will exceed the maximum value.
// The expression Integer.MAX_VALUE % 10 gives 7, so if digit is 8, 9, or anything greater than 7, it will cause an overflow.
}
