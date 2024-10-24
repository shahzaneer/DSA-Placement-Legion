class Solution {
    public int myAtoi(String s) {
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
}