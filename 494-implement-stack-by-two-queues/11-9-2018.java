public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> q;
    public Stack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // write your code here
        q.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.poll());
        }
        q.poll();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.poll());
        }
        int last = q.poll();
        q.add(last);
        return last;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return q.isEmpty();
    }
}
