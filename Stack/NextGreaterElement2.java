import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        
    } 
    
    // ! Brute:
    // ! TC: O(n * 2n ) SC: O(1)
    static int [] nextGreaterElement2Brute(int [] array){
        int [] nextGreaterElement2 = new int [array.length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j< array.length * 2; j++){
                int index = j % array.length;
                if(array[index] > array[i]){
                    nextGreaterElement2[i] = array[index];
                    break;
                }
                else{
                    nextGreaterElement2[i] = -1;
                }
            }
        }
        return nextGreaterElement2;
    }

    // ! Better:
    // ! TC: O(4n) SC: O(n)
    // ! using monotonic Stack
    // ! Monotonic stack is a stack which stores elements in a particular order
    // ! either increasing or decreasing

    static int [] nextGreaterElement2Optimal(int [] array){
        int [] nextGreaterElement2 = new int [array.length];
        Stack<Integer> monoStack = new Stack<>();
        int doubleArraySize = 2 * array.length;
        for(int i = doubleArraySize - 1; i>=0; i--){
            while(!monoStack.isEmpty() && monoStack.peek() <= array[ i % array.length]) monoStack.pop();
            if(i < array.length){
                if(monoStack.isEmpty()){
                    nextGreaterElement2[i] = -1;
                }else{
                    nextGreaterElement2[i] = monoStack.peek();
                }
            }
         monoStack.push(array[i % array.length]);

        }
        return nextGreaterElement2;
    }


}
