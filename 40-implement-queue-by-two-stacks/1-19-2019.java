class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stk2.isEmpty()) {
            pushElem2Stk2();
        }
        return stk2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stk2.isEmpty()) {
            pushElem2Stk2();
        }
        return stk2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
    void pushElem2Stk2() {
        while (!stk1.isEmpty()) {
            stk2.push(stk1.pop());
        }
        return;
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
