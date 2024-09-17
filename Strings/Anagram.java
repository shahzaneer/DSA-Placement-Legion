
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("CAB", "BAC"));
        System.out.println(isAnagramOptimal("Shah", "hahS"));
    }

    //! Anagram of a String are all possible Permutations of the Strings

    // ! Brute : TC: O(nlogn) SC: O(1) (sorting approach)
    static boolean isAnagram(String s1, String s2){
        if(s1.length()!= s2.length()) return false;

       s1 = sortString(s1);
       s2 = sortString(s2);

        // for(int i=0; i<s1.length(); i++){
        //     if(s1.charAt(i) != s2.charAt(i)) return false;
        // }
    // return s1 == s2; // will give flase as it checks the object and they are different objects
        return s1.equals(s2); // will check the contents
    }
    static String sortString(String s){
        char [] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }

    //! Optimal: TC: O(3n) SC: O(1) FrequencyCheck
    static boolean isAnagramOptimal(String s1, String s2){
        if(s1.length()!= s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i = 0; i<s2.length(); i++){
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

       for(Map.Entry<Character, Integer> entry : map.entrySet()){
        if(entry.getValue()!= 0) return false;
       }

       return true;
    }
}
