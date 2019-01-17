class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MinStack() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        stk1.push(x);
        if (stk2.size() == 0 || stk2.peek() >= x) {
            stk2.push(x);
        }
    }
    
    public void pop() {
        int x = stk1.pop();
        if (stk2.size() != 0 && x == stk2.peek()) {
            stk2.pop();
        }
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
