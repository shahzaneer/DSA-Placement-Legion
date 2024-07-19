import java.util.HashMap;

public class frequency {
    public static void main(String[] args) {
        int [] array = {1,2,3,1,2,3,4,12};
        // System.out.println(countFrequency(array));

        countFrequencyBruteForce(array);
        
    }

    static HashMap<Integer, Integer> countFrequency(int [] array){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i= 0; i<array.length;i++){
            if(frequencyMap.containsKey(array[i])){
                frequencyMap.put(array[i], frequencyMap.get(array[i])+1);
            }
            else{
                frequencyMap.put(array[i], 1);
            }
        }
         // Time : O(N)
        // SPACE: O(N)
        return frequencyMap;
    }

    static void countFrequencyBruteForce(int [] arr){
        boolean visited[] = new boolean[arr.length];
 
        for (int i = 0; i < arr.length; i++) {
     
            if (visited[i] == true)
                continue;
                
                 int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
    
}
