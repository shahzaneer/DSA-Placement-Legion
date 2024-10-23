class Solution {
    public int maxDepth(String s) {
        int maximumDepth = 0, currentDepth = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                currentDepth++;
            }
            if(s.charAt(i) == ')'){
                currentDepth--;
            }

            if(currentDepth > maximumDepth) maximumDepth = currentDepth;
        }
        return maximumDepth;
    }
}