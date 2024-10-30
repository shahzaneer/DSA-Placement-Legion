class MyQueue {
    Stack<Integer> queue;
    Stack<Integer> helperStack;

    public MyQueue() {
          queue = new Stack<>();
        helperStack = new Stack<>(); 
    }
    
    public void push(int data) {
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
    
    public int pop() {
        return queue.pop();

    }
    
    public int peek() {
        return queue.peek();
        
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */