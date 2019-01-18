class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    int max = Integer.MAX_VALUE;
    public MaxStack() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void push(int x) {
        stk1.push(x);
        if (stk2.isEmpty() || stk2.peek() <= x) {
            stk2.push(x);
        } else {
            stk2.push(stk2.peek());
        }
    }
    
    public int pop() {
        int x = stk1.pop();
        stk2.pop();
        return x;
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int peekMax() {
        return stk2.peek();
    }
    
    public int popMax() {
        int x = stk2.pop();
        Stack<Integer> stk = new Stack<>();
        while (stk1.peek() != x) {
            stk.push(pop());
        }
        stk1.pop();
        while (!stk.isEmpty()) {
            push(stk.pop());
        }
        return x;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
