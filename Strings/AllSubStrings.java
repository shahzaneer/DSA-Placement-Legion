
import java.util.ArrayList;

public class AllSubStrings {
    public static void main(String[] args) {
        System.out.println(allSubStrings("Shahzaneer"));
    }

    static ArrayList<String> allSubStrings(String s){
        // total no of subString are -> (n(n-1))/2 (non empty)
        int n = s.length();

        ArrayList<String> allSubStrings = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j = i; j<n; j++){
                allSubStrings.add(s.substring(i, j+1));
            }
        }
        return allSubStrings;
    }
}
