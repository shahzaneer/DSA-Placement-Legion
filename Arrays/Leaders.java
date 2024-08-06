
import java.util.ArrayList;
import java.util.Comparator;

public class Leaders {
    public static void main(String[] args) {
        int [] array = {10,22,12,3,0,6};
        System.out.println(leadersBrute(array));
        System.out.println(leadersOptimal(array));
    }

    // TC: O(n^2) SC: O(1) (as we didnt use any space to solve the problem)
    static ArrayList<Integer> leadersBrute(int [] array){

        ArrayList<Integer> leaders = new ArrayList<>();

        for(int i=0; i<array.length;i++){
            boolean isLeader = true;
            for(int j = i+1; j<array.length; j++){
                if(array[j] > array[i]){
                    isLeader = false;
                    break;
                }
            }
            if (isLeader == true){
                leaders.add(array[i]);
            }
        }

        leaders.sort(Comparator.naturalOrder());
        return leaders;
    }

        // TC: O(n) SC: O(1) (as we didnt use any space to solve the problem)
    static ArrayList<Integer> leadersOptimal(int [] array){
        ArrayList<Integer> leaders = new ArrayList<>();
        int maximumElement = Integer.MIN_VALUE;

        for(int i= array.length - 1; i>=0; i--){
            if(maximumElement < array[i]){
                maximumElement = array[i];
                leaders.add(array[i]);
            }
        }
 leaders.sort(Comparator.naturalOrder());
 return leaders;
    }
}
