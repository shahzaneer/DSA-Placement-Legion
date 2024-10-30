
import java.util.Stack;

public class MinStack {
    Stack<Pair<Integer,Integer>> stack;

    public MinStack(){
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        }
        else stack.push(new Pair(val, Math.min(val, stack.peek().second)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
       return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
    }
}


class Pair<T,D>{
    T first;
    D second;

    Pair(T first, D second){
        this.first = first;
        this.second = second;
    }
}
