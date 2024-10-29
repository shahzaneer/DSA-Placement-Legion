class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if (ch == '(' || ch=='{' || ch == '[') st.push(ch);
            if(st.isEmpty() && (ch == ']' || ch == '}' || ch == ')')) return false;
            if(!st.isEmpty()){
            if (ch == ')' && st.pop()!= '(') return false;
            else if(ch == '}' && st.pop()!= '{') return false;
            else if (ch == ']' && st.pop()!= '[') return false;      
            }
            }
        return st.isEmpty();

        }
    }
