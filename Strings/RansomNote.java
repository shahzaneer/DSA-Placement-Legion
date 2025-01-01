import java.util.HashMap;

public class RansomNote{
    public static void main(String[] args) {
        String a = "a", b = "b";
        String aa = "aa", bb = "ab";
        String aaa = "aa", bbb = "aab";

        System.out.println(canConstruct(a, b));
        System.out.println(canConstruct(aa, bb));
        System.out.println(canConstruct(aaa, bbb));

        
    }

    static public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            Character ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<ransomNote.length(); i++){
            Character ch = ransomNote.charAt(i);
            if(!map.containsKey(ch)) return false;
            
            else if(map.containsKey(ch)){
                if(map.get(ch) == 0) return false;
                else  map.put(ch, map.getOrDefault(ch, 0) - 1);

            }
        }

        return true;
    }
}