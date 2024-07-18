class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int number = 0;
        while(num!=0){
            int remainder = num%10;
            if(number > (Integer.MAX_VALUE - remainder) / 10){
                return false;
            }
            number = number * 10 + remainder;
            num= num/10;
        }

        return (number == x);


    }
}