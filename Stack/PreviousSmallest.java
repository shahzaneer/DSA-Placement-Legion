
import java.util.Arrays;
import java.util.Stack;


public class PreviousSmallest {
    public static void main(String[] args) {
        int [] array = {4,5,2,10,8};
        System.out.println(Arrays.toString(previousSmallest(array)));
    }

    // ! Optimal: using monotonic Stack
    static int [] previousSmallest(int [] array){
        Stack<Integer> monostack = new Stack<>();
        int [] previousSmallest = new int [array.length];
        for(int i=0; i<array.length; i++){
            while(!monostack.isEmpty() && monostack.peek() >= array[i]) monostack.pop();
            if(monostack.isEmpty()){
                previousSmallest[i] = -1;
            }else{
                previousSmallest[i] = monostack.peek();
            }

            monostack.push(array[i]);
        }

        return previousSmallest;
          
    }
}
