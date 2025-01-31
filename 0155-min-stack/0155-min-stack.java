class MinStack {
    Stack<Pair<Integer,Integer>> stack;

MinStack(){
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */