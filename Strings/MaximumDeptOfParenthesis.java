import java.util.Stack;

public class MaximumDeptOfParenthesis {
    
    public static void main(String[] args) {
        
    }

    // ! Brute: 
    // ! TC: O() SC: O() -> with Stack
    static int maximumDepthOfParenthesis(String s){
        Stack<Integer> stack = new Stack<>();
        int maximumDepth = 0, currentDepth = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                currentDepth++;
            }
            if(s.charAt(i) == ')'){
                stack.pop();
                currentDepth--;
            }

            if(currentDepth > maximumDepth) maximumDepth = currentDepth;
        }
        return maximumDepth;
    }
    // ! Optimal: 
    // ! TC: O() SC: O() -> without Stack Counter variable

    static int maximumDepthOfParenthesisOptimal(String s){
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
