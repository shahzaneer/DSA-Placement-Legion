class Solution {
    boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        int starting = 0;
        int ending = s.length() - 1;
        while (starting <= ending) {
            char startCh = s.charAt(starting);
            char endCh = s.charAt(ending);
            while (!Character.isLetterOrDigit(startCh) && starting < ending) {
                starting++;
                startCh = s.charAt(starting);
            }
            while (!Character.isLetterOrDigit(endCh) && starting < ending) {
                ending--;
                endCh = s.charAt(ending);
            }
            if(starting == ending) return true;

            if (Character.isLetterOrDigit(startCh) && Character.toLowerCase(startCh) != Character.toLowerCase(endCh)) {
                return false;
            } else {
                starting++;
                ending--;
            }

        }
        return true;
    }
}
