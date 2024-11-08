class Solution {
    public int[] nextGreaterElements(int[] array) {
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