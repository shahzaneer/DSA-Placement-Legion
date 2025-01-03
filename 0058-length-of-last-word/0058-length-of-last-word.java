class Solution {
    public int lengthOfLastWord(String s) {
        if(!s.isEmpty() && s.length() == 1) return 1;
        int i = s.length() -1;
        while(s.charAt(i) == ' ') i--;
        int j = i;
        while(i!=0 && s.charAt(i)!= ' ') i--;
        return (i == 0 && j == 0)? 1 : s.charAt(i) == ' '? j - i: (j - i) + 1;

    }
}