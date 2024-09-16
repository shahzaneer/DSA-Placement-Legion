import java.util.HashMap;

public class isomorphic {
    public static void main(String[] args) {
        
    }
    // IsoMorphic String
    //! 1) isomorphic strings are equal in length
    //! 2) ONE CHARACTER can be mapped to only one other element
    //! 3) the mapped character should not be mapped against two or more characters in String 1 and vice versa

    static boolean isIsomorphic(String s, String t){ 
        if(s.length()!=t.length()) return false; //1

        HashMap<Character,Character> tToSMap = new HashMap<>();
        HashMap<Character,Character> sToTMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(!tToSMap.containsKey(t1)){
                tToSMap.put(t1, s1);
            }
            if(!sToTMap.containsKey(s1)){
                sToTMap.put(s1, t1);
            }

            if(tToSMap.get(t1)!= s1 || sToTMap.get(s1)!= t1) return false; //2+3

        }

        return true;
    }
}
