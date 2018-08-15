class MyQueue {
public:
    stack<int> stack1, stack2;
    void stack2ToStack1(stack<int>& stack1, stack<int>& stack2) {
        while(!stack2.empty()) {
            stack1.push(stack2.top());
            stack2.pop();
        }
    }
    MyQueue() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    void push(int element) {
        // write your code here
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    int pop() {
        // write your code here
        if (stack1.empty()) {
            stack2ToStack1(stack1, stack2);
        }
        int result = stack1.top();
        stack1.pop();
        return result;
    }

    /*
     * @return: An integer
     */
    int top() {
        // write your code here
        if (stack1.empty()) {
            stack2ToStack1(stack1, stack2);
        }
        return stack1.top();
    }
};
