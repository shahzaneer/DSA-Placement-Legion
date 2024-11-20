
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        
    }


    // ! Greedy
    public static int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int cookiesSizePosition = 0;
        int counter = 0;

        Arrays.sort(g);
        Arrays.sort(s);


        while(cookiesSizePosition < s.length && i < g.length){
            
            
            if(s[cookiesSizePosition] >= g[i]){
                cookiesSizePosition++;
                counter++;
                i++;
            }
            else{
                cookiesSizePosition++;
            }
        }

        return counter;
 
    }
}
