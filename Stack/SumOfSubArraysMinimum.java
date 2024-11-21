
import java.util.Stack;

public class SumOfSubArraysMinimum {
    public static void main(String[] args) {
        
    }

    // ! Brute: TC: O(n*n) SC: O(1)
    static int sumOfSubArraysMinimumBrute(int [] array){
        int totalSum = 0;
        int modulo = (int) 1.e9+ 7;
        for(int i=0; i<array.length; i++){
            int minElement = array[i];
            for(int j=i; j<array.length; j++){
                minElement = Math.min(minElement,array[j]);
                totalSum += minElement % modulo;

            }
        }

        return totalSum;
    }

    // ! Optimal:
    //! TC : O(n+n+n) SC : O(n+n)
    static int [] leftSmallerElements(int [] array){
        int [] leftSmallerElementsIndex = new int [array.length];
        Stack<Integer> monoStack = new Stack<>();
        for(int i=0; i<array.length; i++){
            while(!monoStack.isEmpty() && array[monoStack.peek()] > array[i]) monoStack.pop();
            if(monoStack.isEmpty()){
                leftSmallerElementsIndex[i] = -1;
            }else{
                leftSmallerElementsIndex[i] = monoStack.peek();
            }
            monoStack.push(i);
        }

        return leftSmallerElementsIndex;
    }

    static int [] rightSmallerElements(int [] array){
        int [] rightSmallerElementsIndex = new int [array.length];
        Stack<Integer> monoStack = new Stack<>();

        for(int i=array.length - 1; i>=0; i--){
            while(!monoStack.isEmpty() && array[monoStack.peek()] >= array[i]) monoStack.pop();
            if(monoStack.isEmpty()){
                rightSmallerElementsIndex[i] = array.length;
            }else{
                rightSmallerElementsIndex[i] = monoStack.peek();
            }
            monoStack.push(i);
        }


        return rightSmallerElementsIndex;

    }

    static int sumOfSubArraysMinimumOptimal(int [] array){
        int [] lsmallestIndexes = leftSmallerElements(array);
        int [] rsmallestIndexes = rightSmallerElements(array);

        int totalSum = 0;
        int modulo = (int) 1.e9 + 7;

        for(int i=0; i<array.length; i++){
            int leftCount = i - lsmallestIndexes[i];
            int rightCount = rsmallestIndexes[i] - i;
            long subArrays = (long) leftCount * rightCount;

            // Add the contribution of array[i] to the total sum, applying modulo at each step
            // Modular multiplication and addition to avoid overflow
            totalSum = (int) ((totalSum + (subArrays % modulo) * (array[i] % modulo)) % modulo);

        }

        return totalSum;
     }
}