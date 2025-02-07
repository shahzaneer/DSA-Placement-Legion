public class isSubsequence {
    public static void main(String[] args) {

    }

    static public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        if (s.length() > t.length())
            return false;

        int sIndex = 0, tIndex = 0;
        while (tIndex != t.length()) {
            if (sIndex == s.length() - 1 && t.charAt(tIndex) == s.charAt(sIndex))
                return true;
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return false;
    }
}