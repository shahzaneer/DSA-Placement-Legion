import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    //! Optimal is easier than the brute force one here
    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> intervals = {{},{},{},{}};
        // is fucked up situation se bchne k liay input hmesha array ki form main lo!
        // int [][] arrayIntervals = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        int [][] arrayIntervals = {{1,4},{4,5}};
        
        // Arrays.sort(arrayIntervals); (it will through error as it is made to sort fucking 1D arrays) (for 2D comparator likhna hoga)

        // for(int i = 0; i<arrayIntervals.length; i++){
        //     System.out.print(Arrays.toString(arrayIntervals[i])+ ",");        

        // }

        System.out.println(mergeInteralsBrute(arrayIntervals));
        System.out.println(mergeInteralsOptimal(arrayIntervals));

    }

    //! Brute : TC:O(nlogn + 2n) SC: O(1)
    static List<List<Integer>> mergeInteralsBrute(int [][] intervals){
        List<List<Integer>> mergedIntervals = new ArrayList<>();

        // sort the 2D array
        Arrays.sort(intervals, 
        new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0]; // Compare based on the first element
                } else {
                    return a[1] - b[1]; // Compare based on the second element if first elements are equal
                }
            }
        });

        for(int i = 0; i< intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            // 
            if(!mergedIntervals.isEmpty() && end <= (mergedIntervals.get(mergedIntervals.size() - 1).get(1))){
                continue;
            }

            for(int j = i+1; j<intervals.length; j++){
                if(intervals[j][0] <= end) end = Math.max(end, intervals[j][1]);
                else break;
            }

            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            mergedIntervals.add(temp);
        }
        return mergedIntervals;
    }


    //! Optimal: TC: O(nlogn + n) SC: O(1)
    static List<List<Integer>> mergeInteralsOptimal(int [][] intervals){
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        // Sorting in nlogn
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                if(a[0]!=b[0]){
                    return a[0] - b[0];
                }
                else return a[1] - b[1];
            }
        });

        // one single pass
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1).get(1)) {
                mergedIntervals.add(Arrays.asList(interval[0], interval[1]));
            } else {
                if (interval[0] <= mergedIntervals.get(mergedIntervals.size() - 1).get(1)) {
                    mergedIntervals.get(mergedIntervals.size() - 1).set(1, Math.max(interval[1], mergedIntervals.get(mergedIntervals.size() - 1).get(1)));

                }
            }
        }
        
        return mergedIntervals;
    }


}
