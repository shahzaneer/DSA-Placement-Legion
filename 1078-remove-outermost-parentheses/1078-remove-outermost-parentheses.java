class Solution {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')')
                counter--;
            if (counter != 0)
                answer.append(s.charAt(i));
            if (s.charAt(i) == '(')
                counter++;

        }
        return answer.toString();
    }
}