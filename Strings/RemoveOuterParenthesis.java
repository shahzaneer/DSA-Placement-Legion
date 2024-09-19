import java.util.Stack;

public class RemoveOuterParenthesis {
    public static void main(String[] args) {
        
    }

     // if stack is empty dont put the bracket in the answer
    // otherwise put it in the answer
    // when '(' comes insert in the stack ')' remove from the stack   
    static String removeOuterParenthesisStack(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(stack.isEmpty()) stack.push(ch);
                else {
                    stack.push(ch);
                    answer.append(ch);
                }
            }
            else if (ch == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    answer.append(ch);
                }
            }
            
        }

        return answer.toString();
    }

    static String removeOuterParenthesisCount(String s){
        int counter = 0;
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') counter++;
            if(s.charAt(i) == ')') counter--;
            if(counter!=0) answer.append(s.charAt(i));
        }
          return answer.toString();                                                                                                                                                               
    }
}
