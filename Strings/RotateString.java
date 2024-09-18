
public class RotateString {
    public static void main(String[] args) {
        
    }

    static boolean rotateString(String s, String goal){
    return ((s.length() == goal.length()) && ((s+s).contains(goal)));
    }
}
