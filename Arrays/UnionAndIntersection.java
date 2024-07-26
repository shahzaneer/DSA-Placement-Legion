
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int [] arr1 = {1,1,2,2,3,4,5};
        int [] arr2 = {1,2,3,8,9};

        // ArrayList<Integer> union = getUnionPointers(arr1, arr2);
        // ArrayList<Integer> union = getUnionSet(arr1, arr2);

        ArrayList<Integer> intersection = getIntersection(arr1, arr2);

        

        for(int i=0; i<intersection.size();i++){
            System.out.print(intersection.get(i));
        }
        
    }

    // TC: O(n) SC: O(n) the TreeSet thing
    static ArrayList<Integer> getUnionSet(int [] arr1, int [] arr2){
        TreeSet<Integer> unionSet = new TreeSet<>();
        ArrayList<Integer> union = new ArrayList<>();

        for(int i = 0; i<arr1.length; i++){
            unionSet.add(arr1[i]);
        }
        for(int i = 0; i<arr2.length; i++){
            unionSet.add(arr2[i]);
        }

       for(int i: unionSet){
        union.add(i);
       }
        return union;
    }

    // TC: O(n) SC: O(1) (no extra space taken to solve the problem)
    static ArrayList<Integer> getUnionPointers(int [] arr1, int [] arr2){
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<arr1.length && j<arr2.length){
           if(arr1[i] <= arr2[j]){
            if(union.isEmpty() || union.get(union.size() - 1)!= arr1[i]) 
                union.add(arr1[i]);
            i++;
           }

           else{
            if (union.isEmpty() || union.get(union.size() - 1)!= arr2[j]) 
            union.add(arr2[j]);
        j++;
           }
              
        }
        // If array 2 was exhausted
        while (i<arr1.length){
            union.add(arr1[i]);
            i++;
        }
        // If array 1 was exhausted
        while(j<arr2.length){
            union.add(arr2[j]);
            j++;
        }
    return union;
    }
    
    static ArrayList<Integer> getIntersection(int [] arr1, int [] arr2){
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0; 
        int j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]) i++;
            else if(arr1[i] > arr2[j]) j++;
            else{
                intersection.add(arr1[i]);
                i++;
                j++;
        }
    }
    return intersection; 
}
}