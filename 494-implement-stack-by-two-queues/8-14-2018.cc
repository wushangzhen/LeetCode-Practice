class Stack {
public:
    /*
     * @param x: An integer
     * @return: nothing
     */
    queue<int> que1, que2;
    void func(queue<int> &que1, queue<int> &que2) {
        while (que1.size() != 1) {
            que2.push(que1.front());
            que1.pop();
        } 
    }
    void swapQueues (queue<int> &que1, queue<int> &que2) {
        queue<int> temp = que1;
        que1 = que2;
        que2 = temp;
    }
    void push(int x) {
        // write your code here
        que1.push(x);
    }

    /*
     * @return: nothing
     */
    void pop() {
        // write your code here
        func(que1, que2);
        que1.pop();
        swapQueues(que1, que2);
    }

    /*
     * @return: An integer
     */
    int top() {
        // write your code here
        func(que1, que2);
        int result = que1.front();
        que1.pop();
        que2.push(result);
        swapQueues(que1, que2);
        return result;
    }

    /*
     * @return: True if the stack is empty
     */
    bool isEmpty() {
        // write your code here
        return que1.size() == 0;
    }
};
