
import java.util.HashMap;
import java.util.Map;

public class appearOnce {
   public static void main(String[] args) {
    int [] array = {2,2,1};
    System.out.println(appearOnce(array));
    System.out.println(appearOnesOptimal(array));
    System.out.println(appearOnceBetter(array));

   } 

//    Brute Force (my) : TC: O(n^2) SP: O(1)
   static int appearOnce(int [] array){
    for(int i=0; i<array.length; i++){
        int counter = 0;
        for(int j = 0; j<array.length; j++){
            if(array[i] == array[j]) counter++;
            if(counter > 1) break;
        }
        if(counter == 1) return array[i];

    }
    return -1;
   }
//    Better : TC: O(n + n) SP: O(n)
static int appearOnceBetter(int [] array){
    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i=0; i<array.length;i++){
        int value = map.getOrDefault(array[i], 0);
        map.put(array[i], value + 1);
    }

    for(Map.Entry<Integer, Integer> mapValue: map.entrySet()){
        if(mapValue.getValue() == 1) return mapValue.getKey();
    }

    return -1;

}
// Optimized (my): TC: O(n) SP: O(1)
static int appearOnesOptimal(int [] array){
    int xor = 0;
    for(int i=0; i<array.length; i++){
        xor = xor ^ array[i];
    }

    return xor;
} 

}
