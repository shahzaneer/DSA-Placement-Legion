
import java.util.Stack;

public class reverseString {
    public static void main(String[] args) {
        String s = "Im Shahzaneer Ahmed Aspiring Software Engineer Graduated From CUI Islamabad";
        System.out.println(reverseStringBrute(s));
        System.out.println(reverseStringBetter(s));
        System.out.println(reverseStringOptimal(s));
    }
    // ! Brute: O(n+n) TC: O(n) (stack)
    static String reverseStringBrute(String str){
        if (str.length() == 0) return "";
        StringBuilder answerString = new StringBuilder();
        String answer = "";
        Stack stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                stack.push(answerString);
                answerString = new StringBuilder();
            }else{
                answerString.append(str.charAt(i));
            }
        }
        stack.push(answerString);


        while(stack.size() != 1){
            answer += stack.pop() + " ";
        }
        answer+= stack.pop();
        return answer;
    }
    // ! Better:  eliminating stack (using split function)
    static String reverseStringBetter(String str){
        String [] words = str.split(" ");
        StringBuilder reverse = new StringBuilder(); 

        for(int i=words.length - 1; i>= 0; i--){
            if(!" ".equals(words[i])){
                if(reverse.isEmpty()){
                    reverse.append(words[i]);
                }else{
                    reverse.append(" ");
                    reverse.append(words[i]);

                }
            }
        }
        return reverse.toString();
    }
    // ! Optimal:  eliminating stack (using no extra space)
    static String reverseStringOptimal(String str){
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
