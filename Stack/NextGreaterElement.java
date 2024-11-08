
import java.util.Stack;

public class NextGreaterElement{
    public static void main(String[] args) {
        
    }

    // ! Brute:
    // ! TC: O(n^2) SC: O(1)
    static int [] nextGreaterElement(int [] array){
        int [] nextGreaterElement = new int [array.length];
        int index = 0;
        for(int i = 0; i<array.length; i++){
            for(int j = i+1; j<array.length; j++){
                if(array[j] > array[i]){
                    nextGreaterElement[index] = array[j];
                    index++;
                    break;
                }else{
                    nextGreaterElement[index] = -1;
                    index++;
                }
            }
        }

        return nextGreaterElement;
    }

    // ! Optimal:
    // ! TC: O(n)  SC: O(n)
    // ! using monotonic stack: storing elements in stack in a particular order (increasing or decreasing)

    static int [] nextGreaterElementOptimal(int [] array){
        int [] nextGreaterElement = new int [array.length];
        int index = 0;
        Stack<Integer> monotonicStack = new Stack<>();

        for(int i=array.length-1; i>=0; i--){
            while(!monotonicStack.isEmpty() && monotonicStack.peek() <= array[i]) monotonicStack.pop();

            if(monotonicStack.isEmpty()) nextGreaterElement[i] = -1;
            else{
                monotonicStack.push(array[i]);
                nextGreaterElement[i] = monotonicStack.peek();
            }
        }

        return nextGreaterElement;
    }

    static int [] NGNleetcode(int [] array1, int [] array2){
        int [] nextGreaterElement = new int [array1.length];
        for(int i = 0; i<array1.length; i++){
            nextGreaterElement[i] = ngnleetcodeHelper(array2, array1[i]);
        }
        return nextGreaterElement;
    }

    static int ngnleetcodeHelper(int [] array2, int num){
          for(int i=0; i<array2.length; i++){
            if(array2[i] == num){
                for(int j =i+1; j<array2.length; j++){
                    if(array2[j] > num) return array2[j];
                    else return -1;
                }  
            }
          }
          return -2;      
    }

    

    

}