public class FindOccurence{
    public static void main(String[] args) {
        String s = "kamsamkamsam";
        String k = "sam";
        System.out.println(findOccurence(s, k));

    }

    static int findOccurence(String haystack, String needle){
        // return haystack.indexOf(needle);
        int i =0; int j = 0;
        int firstOccurence = -1;
        StringBuilder str = new StringBuilder();
        while(i!= haystack.length()){
            if(haystack.charAt(i)!= needle.charAt(j)) i++;
            else{
                firstOccurence = i;
                while(j!= needle.length() && haystack.charAt(i) == needle.charAt(j)){ 
                    str.append(haystack.charAt(i));
                    i++;
                    j++;
                }
                if(str.toString().equals(needle)) return firstOccurence;
                else{
                    j = 0;
                    i++;
                    str = new StringBuilder();
                    firstOccurence = -1;
                }
            }
        }


        return firstOccurence;
    }



    class Solution {
        public int strStr(String haystack, String needle) {
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
    

}