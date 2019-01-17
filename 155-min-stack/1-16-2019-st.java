class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk1;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stk1 = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min) {
            stk1.push(min);
            min = x;
        }
        stk1.push(x);
    }
    
    public void pop() {
        int x = stk1.peek();
        stk1.pop();
        if (x == min) {
            min = stk1.peek();
            stk1.pop();
        }
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return min;
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
