
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {

        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // If the sorted string is already in the map, add the original string to the list
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            anagramGroups.get(sortedStr).add(str);
        }
        
        // Return the values of the map
        return new ArrayList<>(anagramGroups.values());
    }
}
