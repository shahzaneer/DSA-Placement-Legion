class Solution {
    public String reverseWords(String str) {
       int startingIndex = str.length() - 1;
        StringBuilder reverse = new StringBuilder();
        while(startingIndex >= 0){
            // Skipping the trailing spaces
            while(startingIndex >=0 && str.charAt(startingIndex) == ' ') startingIndex--;
            int endingIndex = startingIndex;
            // now pointing the first space after it (making current word)
            if(startingIndex < 0) break; //check if the string has already being traversed then stop 
            while(startingIndex >=0 && str.charAt(startingIndex) != ' ') startingIndex--; 

            if(reverse.isEmpty()){
                reverse.append(str.substring(startingIndex+1, endingIndex+1));
            }else{
                reverse.append(" ");
                reverse.append(str.substring(startingIndex+1, endingIndex+1));
            }

        }
        return reverse.toString();
    
    }
}