
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
   public static void main(String[] args) {
    int [] array = {1,0,-1,0,-1,2,3,4,5,0};
    System.out.println(threeSumBrute(array));
    System.out.println(threeSumBetter(array));
    System.out.println(threeSumOptimal(array));

   }
   
//!   Brute: TC: O(n^3 + nlogn) SC: O(n)
static List<List<Integer>> threeSumBrute(int [] array){
    List<List<Integer>> threeSum = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();

    for(int i=0; i<array.length;i++){
        for(int j=i+1; j<array.length; j++){
            for(int k = j+1; k<array.length; k++){
                if(array[i] + array[j] + array[k] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(array[i]);
                    temp.add(array[j]);
                    temp.add(array[k]);
                    temp.sort(Comparator.naturalOrder());
                    set.add(temp);
                }
            }
        }
    }

    for(List<Integer>  triplet : set){
        threeSum.add(triplet); 
       }
    
    return threeSum;
}
//!   Better: TC: O(n^2 + nlogn) SC: (n+n)
static List<List<Integer>> threeSumBetter(int [] array){
    HashSet<List<Integer>> set = new HashSet<>();

    for(int i= 0; i<array.length; i++){
        HashSet<Integer> hashset = new HashSet<>();
        for(int j = i+1; j<array.length; j++){

            int thirdTerm = - (array[i] + array[j]);
            if (hashset.contains(thirdTerm)){
                List<Integer> temp = Arrays.asList(array[i], array[j], thirdTerm);
                temp.sort(null);
                set.add(temp);
            }
            hashset.add(array[j]);

        }
    }

    List<List<Integer>> threeSum = new ArrayList<>(set);
    return threeSum;
} 
//!   Optimal:   O(n^2 + nlogn ) SC: O(1) (two pointers approach)
static List<List<Integer>> threeSumOptimal(int [] array){
    List<List<Integer>> threeSum = new ArrayList<>();
    Arrays.sort(array);
    for(int i = 0; i<array.length;i++){
        if(i!=0 && array[i] == array[i-1]) continue; //avoiding duplicates
        int j = i+1;
        int k = array.length - 1;
        while(j<k){
            int sum = array[i] + array[j] + array[k];
            if(sum > 0){
                k--;
            }
            else if(sum < 0){
                j++;
            }
            else{
                List<Integer> temp = Arrays.asList(array[i],array[j],array[k]);
                // temp.sort(null); they are already sorted!
                threeSum.add(temp);
                j++;
                k--;
                // avoiding duplicates
                while(j<k && array[j] == array[j-1]) j++;
                while(j<k && array[k] == array[k+1]) k--;
            }
        }
    }
    return threeSum;
}

}
