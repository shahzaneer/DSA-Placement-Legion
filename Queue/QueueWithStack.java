import java.util.Stack;
public class QueueWithStack {
    public static void main(String[] args) {
        QueueViaStack<Integer> queue = new QueueViaStack<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.peek());
        


    }

    

}

//! implementing a Queue FIFO DS with using stack
// ! while doing dry run start with one element and then wth two elements dont do directly with 4 elements 

class QueueViaStack<T>{
    Stack<T> queue;
    Stack<T> helperStack;

    public QueueViaStack() {
        queue = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(T data){
        if(queue.isEmpty()) {
            queue.push(data);
            return;
        }

        while (!queue.isEmpty()) {
            helperStack.push(queue.pop());
        }
    
        // Push the new element onto the empty queue
        queue.push(data);
    
        // Move everything back to queue
        while (!helperStack.isEmpty()) {
            queue.push(helperStack.pop());
        }

    }

    public void pop(){
        if(!queue.isEmpty()) queue.pop();
    }

    public T peek(){
        if(!queue.isEmpty()) return queue.peek();
        return null;
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }


    

}
