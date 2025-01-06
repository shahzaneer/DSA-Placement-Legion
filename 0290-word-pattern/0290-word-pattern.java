class Solution {
    public boolean wordPattern(String pattern, String s) {
          String[] words = s.split(" ");
        
        if (pattern.length() != words.length) return false;
        
        // Two maps for the bijection: pattern to word and word to pattern
        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];
            
            // Check if the character in pattern is already mapped to a different word
            if (patternToWord.containsKey(p)) {
                if (!patternToWord.get(p).equals(w)) {
                    return false;
                }
            } else {
                patternToWord.put(p, w);
            }
            
            // Check if the word is already mapped to a different character
            if (wordToPattern.containsKey(w)) {
                if (wordToPattern.get(w) != p) {
                    return false;
                }
            } else {
                wordToPattern.put(w, p);
            }
        }
        
        // No conflicts, return true
        return true;
    }
}