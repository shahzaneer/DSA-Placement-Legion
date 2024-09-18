public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] shahs = {"shahzaneer","shahbano","shaheer"};
        String [] others = {"kaleem","faheem","naseem"};
        System.out.println(lcp(shahs));
        System.out.println(lcp(others));

    }

    //! Optimal : TC: O(n*n) SC: O(1)
    static String lcp(String[] words) {
        StringBuilder lcp = new StringBuilder();
        boolean match = true;
        for(int i=0; i<words[0].length(); i++){
            char ch = words[0].charAt(i);
            for(int j = 1; j<words.length; j++){
                if(i > words[j].length() - 1  ||  words[j].charAt(i) != ch){
                    match = false;
                }
            }
            if(match) lcp.append(ch);
            else break;
        }
    return lcp.toString();
    }
}
