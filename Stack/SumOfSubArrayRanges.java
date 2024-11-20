import java.util.Stack;

public class SumOfSubArrayRanges {
    public static void main(String[] args) {
        
    }

    //! Brute: TC: O(n^n) SC : O(1)
    static int sumOfSubArrayRanges(int [] nums){
        int sum = 0;
        // generate subArrays
        for(int i=0;i<nums.length; i++){
            int minimumElement = Integer.MAX_VALUE;
            int maximumElement = Integer.MIN_VALUE;
            for(int j=i; j<nums.length; j++){
                // find Max and min for each SubArray
                maximumElement = Math.max(maximumElement, nums[j]);
                minimumElement = Math.min(maximumElement, nums[j]);
                // Add them
                sum += maximumElement - minimumElement;
            }
        }
        return sum;
    }

    // ! Optimal: TC: O(10n) SC: O(n + n + n + n) 
    static long sumOfSubArrayRangesOptimal(int [] nums){
        return (long) (sumOfSubArraysMaximumOptimal(nums) - sumOfSubArraysMinimumOptimal(nums));
    }

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



     static int [] leftGreaterElements(int [] array){
        int [] leftGreaterElementsIndex = new int [array.length];
        Stack<Integer> monoStack = new Stack<>();
        for(int i=0; i<array.length; i++){
            while(!monoStack.isEmpty() && array[monoStack.peek()] < array[i]) monoStack.pop();
            if(monoStack.isEmpty()){
                leftGreaterElementsIndex[i] = -1;
            }else{
                leftGreaterElementsIndex[i] = monoStack.peek();
            }
            monoStack.push(i);
        }

        return leftGreaterElementsIndex;
    }

    static int [] rightGreaterElements(int [] array){
        int [] rightGreaterElementsIndex = new int [array.length];
        Stack<Integer> monoStack = new Stack<>();

        for(int i=array.length - 1; i>=0; i--){
            while(!monoStack.isEmpty() && array[monoStack.peek()] <= array[i]) monoStack.pop();
            if(monoStack.isEmpty()){
                rightGreaterElementsIndex[i] = array.length;
            }else{
                rightGreaterElementsIndex[i] = monoStack.peek();
            }
            monoStack.push(i);
        }


        return rightGreaterElementsIndex;

    }

    static int sumOfSubArraysMaximumOptimal(int [] array){
        int [] leftGreaterElements = leftGreaterElements(array);
        int [] rightGreaterElements = rightGreaterElements(array);

        int totalSum = 0;
        int modulo = (int) 1.e9 + 7;

        for(int i=0; i<array.length; i++){
            int leftCount = i - leftGreaterElements[i];
            int rightCount = rightGreaterElements[i] - i;
            long subArrays = (long) leftCount * rightCount;

            // Add the contribution of array[i] to the total sum, applying modulo at each step
            // Modular multiplication and addition to avoid overflow
            totalSum = (int) ((totalSum + (subArrays % modulo) * (array[i] % modulo)) % modulo);

        }

        return totalSum;
     }
}
