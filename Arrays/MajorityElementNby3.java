import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementNby3 {
    public static void main(String[] args) {
        int [] array = {11, 33, 33, 11, 10, 33, 12};
        System.out.println(majorityElementBrute(array));
        System.out.println(majorityElementBetter1(array));
        System.out.println(majorityElementBetter2(array));
        System.out.println(majorityElementOptimal(array));
    }

    // Brute : TC: O(n^2) SC: O(1)
    static List<Integer> majorityElementBrute(int [] array){
        List<Integer> majorityElements = new ArrayList<>();
        for(int i = 0; i<array.length; i++){
            int count = 0;
            if(majorityElements.isEmpty() || majorityElements.get(0) != array[i]){
                for(int j = 0; j<array.length; j++){
                    if(array[i] == array[j]){
                        count++;
                    }
                }
                if(count > array.length/3) majorityElements.add(array[i]);
            }

            if(majorityElements.size() == 2) break; //as 2 se zyada ho nhi skte 
        }
    return majorityElements;
    }
    // Better-1 : O(n + n) SC: O(n)
    static List<Integer> majorityElementBetter1(int [] array){
        
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> majorityElements = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }
            else map.put(array[i], 1);
        }
        for(Map.Entry object: map.entrySet()){
            if((int) object.getValue() > array.length/3) majorityElements.add((int) object.getKey());
        }

        return majorityElements;
    }
    // Better-2: O(n) SC: O(n)
    static List<Integer> majorityElementBetter2(int [] array){

        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> majorityElements = new ArrayList<>();
        int majority = array.length/3;

        for(int i=0; i<array.length; i++){
            if (majorityElements.size() == 2) break;
            else if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
                if(map.get(array[i]) > majority) majorityElements.add(array[i]);
            }
            else map.put(array[i], 1);
        } 

        return majorityElements;
    }
    // Optimal (Moore's Voting Algorithm (Modified))
    // TC: O(n) SC: O(1)
    static List<Integer> majorityElementOptimal(int [] array){
        List<Integer> majorityElements = new ArrayList<>();
        int counter1 = 0, counter2 = 0;
        int element1 = 0, element2 = 0;

        for(int i=0; i<array.length; i++){
            if(counter1 == 0 && element2!= array[i]){
                counter1 = 1;
                element1 = array[i];
            }
            else if(counter2 == 0 && element1!= array[i]){
                counter2 = 1;
                element2 = array[i];
            }
            else if(element1 == array[i]) counter1++;
            else if (element2 == array[i]) counter2++;
            
            else 
            {
                --counter1; --counter2;
            }
        }

    // elem1 elem2 may or may not be the elements that are majorityElementsBy3
    int count1 = 0, count2 =0;
    for(int i=0; i<array.length;i++){
        if(array[i] == element1) count1++;
        else if(array[i] == element2) count2++;
    }
    
    if(count1 > array.length/3) majorityElements.add(element1);
    if(count2 > array.length/3) majorityElements.add(element2);

        return majorityElements;

    }

}
