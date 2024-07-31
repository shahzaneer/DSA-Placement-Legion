
import java.util.HashMap;
import java.util.Map;


public class majority_elements {
    // by n/2
    public static void main(String[] args) {
        int [] array = {1,2,3,1,1,1};
        System.out.println(majorityElementBruteForce(array));
        System.out.println(majorityElementBetter(array));
        System.out.println(majorityElementMooreVotingAlgorithm(array));
    }
    // TC: O(n^2) SC: O(1)
    static int majorityElementBruteForce(int [] array){
        for(int i = 0; i<array.length;i++){
            int count = 0;
            for(int j=0; j<array.length; j++){
                if(array[j] == array[i]){
                    count++;
                }
            }
            if(count > array.length/2) return array[i];
        }
        return -1;
    }
        // TC: O(n log n) SC: O(n)
    static int majorityElementBetter(int [] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }
            else map.put(array[i], 1);
        }

        for(Map.Entry value: map.entrySet()){
            if((int) value.getValue() > (array.length / 2) ){
                return (int) value.getKey();
            }
        }

        return -1;
    }
        // TC: O(n) SC: O(1)
    static int majorityElementMooreVotingAlgorithm(int [] array){
        // for checking the majority Element
        int count = 0;
        int element = array[0];
        for(int i=0; i<array.length; i++){
            if(count == 0){
                element = array[i];
                count = 1;
            }
            else if(array[i]==element){
                count++; 
            }
            else if (array[i]!=element){
                count--;
            }
        }

        // for checking if the element that might be the majority element is actually the majority element or not?
        int count1 = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == element) count1++;
        }

        if(count1 > array.length/2) return element;
        return -1;
    }
}
