
import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    public static void main(String[] args) {
        StackViaQueue<Integer>  stack = new StackViaQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());

    }
}

class StackViaQueue<T>{
    Queue<T> stack;

    StackViaQueue(){
        stack = new LinkedList<>();
    }

    void push(T data){
        stack.add(data);

        for(int i=0; i<stack.size() - 1; i++){
            stack.add(stack.poll());
        }

    }

    T peek(){
        return stack.peek();
    }
    T pop(){ 
        return stack.poll();
    }

    boolean isEmpty(){
        return stack.isEmpty();
    }


}
