public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public Stack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int x) {
        // write your code here
        q1.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q2.add(q1.poll());
        } 
        q1.poll();
        swap();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q2.add(q1.poll());
        } 
        int res = q1.poll();
        q2.add(res);
        swap();
        return res;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return q1.isEmpty();
    }
    void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
