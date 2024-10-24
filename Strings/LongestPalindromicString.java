public class LongestPalindromicString {
   public static void main(String[] args) {
    
   } 

   static boolean isPalindrome(String s, int i, int j){
    while(i<j){
        if(s.charAt(i)!= s.charAt(j)) return false;
        i++;
        j--;
    }
    return true;
   }

   static String longestPalindromicString(String s){
    int starting = 0, ending = 0, max = 0;
        for(int i =0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(isPalindrome(s, i, j)){
                    if(j-i+1 > max){
                        max = j-i+1;
                        starting = i;
                        ending = j;
                    }
                }
            }
        }

        return s.substring(starting, ending+1);
   }
}
