class Solution {
    public boolean isAnagram(String s1, String s2) {
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