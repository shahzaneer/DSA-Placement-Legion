import java.util.HashMap;

public class FirstUniqueCharacter{
    public static void main(String[] args) {
        
    }

    static public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(map.get(ch) == 1) return i;

        }

        return -1;
    }
}