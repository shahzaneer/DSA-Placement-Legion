import java.util.ArrayList;

public class ReArrangePositiveAndNegative {
    public static void main(String[] args) {
        
    }
    // Brute: TC: O(2n) SC: O(n)
    static int [] ReArrangeBrute(int [] array){
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();

        for(int i=0; i<array.length;i++){
            if(array[i] > 0) positives.add(array[i]);
            else if (array[i] < 0) negatives.add(array[i]);
        }

        for(int i=0; i<array.length/2; i++){
            array[2*i] = positives.get(i);
            array[(2*i) + 1] = negatives.get(i);
        }
        return array;
    }

    // Optimal TC: O(n) SC: O(n)
    static ArrayList<Integer> ReArrangeOptimal(int [] array){
        int oddIndex = 1, evenIndex = 0;
        ArrayList<Integer> reArrangedElements = new ArrayList<Integer>();

        for(int i=0; i<array.length;i++){
            if(array[i] > 0){
                reArrangedElements.add(array[evenIndex]);
                evenIndex+=2;
            } 
            else if(array[i] < 0){
                reArrangedElements.add(array[oddIndex]);
                oddIndex+=2;
            }
        }
       return reArrangedElements;
    }
}
