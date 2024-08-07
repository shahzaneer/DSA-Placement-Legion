
import java.util.Arrays;
import java.util.HashSet;


public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int [] array = {1,101,102,2,1,3,4,103};
        System.out.println(longestSubsequenceBrute(array));
        System.out.println(longestSubsequenceBetter(array));
        System.out.println(longestSubsequenceOptimal(array));

        
        
    }

    // TC: O(n^2) SC: O(1) - LinearSearch
    static int longestSubsequenceBrute(int [] array){
        if(array.length <= 1 ) return array.length;

        int longestSubSequence = 1;
        for(int i=0; i<array.length;i++){
            int count = 1;
            int x = array[i];
            while(linearSearch(array, x+1) == true){
                x = x+1;
                count = count+1;
            }
            longestSubSequence = Math.max(count, longestSubSequence);
        }
        return longestSubSequence;
    }
    static boolean linearSearch(int [] array, int key){
        for(int i=0; i<array.length;i++){
            if(array[i] == key){
                return true;
            }
        }
        return false;
    }

    // TC: O(nlogn + n) SC:O(1) - Sorting
    static int longestSubsequenceBetter(int [] array){
        if(array.length <= 1 ) return array.length;
        Arrays.sort(array);  //Quick sort in case of Java Collections O(n log n)
        int longest = 0;
        int count = 0;
        int smallestElement = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){
            if(array[i]-1 == smallestElement){
                count+=1;
                smallestElement = array[i];
            }
            else if(array[i]!=smallestElement){
                count = 1;
                smallestElement = array[i];
            }
            longest = Math.max(count,longest);
        }
       return longest; 
    }

    // TC: O(2n) SC: O(n) - Set
    static int longestSubsequenceOptimal(int [] array){
        if(array.length <= 1) return array.length;
        HashSet<Integer> hash = new HashSet<>();
        int longest = 1, count = 0;
        for(int i=0; i<array.length;i++){
            hash.add(array[i]);
        }
        for(int it: hash){
            if(!hash.contains(it-1)){
                count = 1;
                int x = it;
                while(hash.contains(x+1)){
                    count++;
                    x = x+1;
                }
            }
            longest = Math.max(longest, count);
        }
    return longest;
    }

}

