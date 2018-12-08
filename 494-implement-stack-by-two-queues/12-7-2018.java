class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.poll());
        }
        return q.poll();
    
    }
    
    /** Get the top element. */
    public int top() {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.poll());
        }
        int temp = q.peek();
        q.add(q.poll());
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
