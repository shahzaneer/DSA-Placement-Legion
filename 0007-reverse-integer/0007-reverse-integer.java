class Solution {
    public int reverse(int x) {

        int num = Math.abs(x);

        int number = 0;
        while (num != 0) {
            int remainder = num % 10;
             // Overflow check
            if (number > (Integer.MAX_VALUE - remainder) / 10) {
                return 0; 
                }
            number = number * 10 + remainder;
            num /= 10;
        }
               
        return (x<0) ? (-number) : number;
    }
}


