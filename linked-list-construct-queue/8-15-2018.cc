class QueueNode {
public:
    int val;
    QueueNode* next;
    QueueNode(int v) {
        val = v;
        next = NULL:
    }
};
class Queue {
public:
    QueueNode *dummy, *tail;
    Queue() {
        dummy = new QueueNode(-1);
        tail = dummy;
    }
    void push(int val) {
        Queue *node = new QueueNode(val);
        tail->next = node;
        tail = node;
    }
    int pop() {
        int result = dummy->next->val;
        dummy->next = dummy->next->next;
        if (dummy->next == NULL) {
            tail = dummy;
        }
        return result;
    }
    int peek() {
        int result = dummy->next->val;
        return result;
    }
    bool empty() {
        return dummy == tail;
    }
};
