
import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int [] set = {1,2,3};
        System.out.println(powerSet(set));
    }

    //! TC: O(2^n * n) SC: O(1) 
    static List<List<Integer>> powerSet(int [] set){
        List<List<Integer>> powerSet = new ArrayList<>();
        // int subsets = (int) Math.pow(2, set.length); 
        int subsets = 1 << set.length; // 1<<n == 2^n
        for(int i=0; i<subsets; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<set.length; j++){
                if(isIthBitSet(i,j)) list.add(set[j]);
            }
            powerSet.add(list);
        }
        return powerSet;
    }

    private static boolean isIthBitSet(int num, int i) {
        return ((num & (1<<i))!=0);
    }
}
