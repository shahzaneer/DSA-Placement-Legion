
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;

        System.out.println(fourSumBrute(nums, target));
        System.out.println(fourSumBetter(nums, target));
        System.out.println(fourSumOptimal(nums, target));
    }

    //! Brute: TC: O(n^4) SC: O(n)
    static List<List<Integer>> fourSumBrute(int [] array, int target){
        
        HashSet<List<Integer>> hashset = new HashSet<>();
        
        for(int i = 0; i<array.length; i++){
            for(int j = i+1; j<array.length;j++){
                for(int k = j+1; k<array.length; k++){
                    for(int l =k+1; l<array.length; l++){
                        //! Takes Care of the fuckin' Integer Overflow >>
                        long sum = (long)array[i] + array[j];
                        sum += array[k];
                        sum += array[l];

                        if(sum == target){
                            List<Integer> temp = Arrays.asList(array[i],array[j],array[k],array[l]);
                            temp.sort(null);
                            hashset.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> fourSum = new ArrayList<>(hashset);
        return fourSum;

    }
    // ! Better: TC: O(n^3) SC: O(n + n)
    static List<List<Integer>> fourSumBetter(int [] array, int target){
        HashSet<List<Integer>> hashset = new HashSet<>();

        for(int i = 0; i<array.length; i++){
            for(int j = i+1; j<array.length; j++){
                HashSet<Integer> set = new HashSet<>();
                for(int k = j+1; k<array.length; k++){
                    int fourth = target - ( array[i] + array[j] + array[k]);
                    if(set.contains(fourth)){
                        List<Integer> temp = Arrays.asList(array[i],array[j],array[k],fourth);
                        temp.sort(null);
                        hashset.add(temp);
                    }
                    set.add(array[k]);

                }
            }
        }

        List<List<Integer>> fourSum = new ArrayList<>(hashset);
        return fourSum;
    }
    //! Optimal: TC: O(n^3) SC: O(1)
    static List<List<Integer>> fourSumOptimal(int [] array, int target){
        List<List<Integer>> fourSum = new ArrayList<>();
        Arrays.sort(array);

        for(int i = 0; i<array.length; i++){
            if(i!=0 && array[i]== array[i-1]) continue;
            for(int j = i+1; j<array.length; j++){
                if(j!=i+1 && array[j]== array[j-1]) continue;
                int k = j+1;
                int l = array.length - 1;
                while(k<l){
                    int sum = array[i] + array[j] + array[k] + array[l];
                    if (sum > target){
                        l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        List<Integer> temp = Arrays.asList(array[i],array[j],array[k],array[l]);
                        fourSum.add(temp);
                        k++;
                        l--;
                        while(k<l && array[k] == array[k-1]) k++;
                        while(k<l && array[l] == array[l+1]) l--;
                    }
                }
            }
        }
        return fourSum;
    }
}
