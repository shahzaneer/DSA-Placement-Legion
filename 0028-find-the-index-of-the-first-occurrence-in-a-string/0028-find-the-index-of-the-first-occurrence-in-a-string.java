class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);  (builtin)

        // Two Pointers
        if (needle.length() == 0) return 0;
            
            if (haystack.length() < needle.length()) return -1;
    
            int i = 0; // Pointer for haystack
            int j = 0; // Pointer for needle
            int firstOccurrence = -1;
    
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    if (j == 0) firstOccurrence = i;
                    j++;
                    
                    if (j == needle.length()) {
                        return firstOccurrence;
                    }
                } else {
                    if (firstOccurrence != -1) {
                        i = firstOccurrence;  
                        firstOccurrence = -1; 
                    }
                    j = 0; 
                }
                i++; 
            }
    
            return -1;
        }
    }
