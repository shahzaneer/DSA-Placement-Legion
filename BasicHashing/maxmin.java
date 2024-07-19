
import java.util.Arrays;
import java.util.HashMap;

class maxmin{
    public static void main(String[] args) {
        int [] array  = {1,2,3,1,2,3,4,3,6,7,3,10,7,6,4};
        System.out.println(Arrays.toString(minmaxFrequency(array)));
    }

    static int [] minmaxFrequency(int [] array){
        HashMap<Integer, Integer> minmaxFrequency = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(minmaxFrequency.containsKey(array[i])){
                minmaxFrequency.put(array[i], minmaxFrequency.get(array[i]) + 1);
            }
            else{
                minmaxFrequency.put(array[i], 1);
            }
        }

            int minElement = 0, maxElement= 0;
            int minElementFrequency = Integer.MAX_VALUE, maxElementFrequency = Integer.MIN_VALUE;

        for(HashMap.Entry entryObj : minmaxFrequency.entrySet()){
            if(minElementFrequency > (int) entryObj.getValue()){
                minElement = (int) entryObj.getKey();
                minElementFrequency = (int) entryObj.getValue();
            }

            if (maxElementFrequency < (int) entryObj.getValue()){
                maxElement = (int) entryObj.getKey();
                maxElementFrequency = (int) entryObj.getValue();
            }

        }

        int [] result = {maxElement,maxElementFrequency, minElement, minElementFrequency};
        return result;
    } 
}