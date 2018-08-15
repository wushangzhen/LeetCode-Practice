class CircularQueue {
public:
    /**
     * @return:  return true if the array is full
     */
    int front = 0;
    int rear = 0;
    int size = 0;
    int* circularQueue;
    int len = 0;
    CircularQueue(int n) {
        // do intialization if necessary
        circularQueue = new int[n];
        len = n;
    }
    bool isFull() {
        // write your code here
        return size == len;
    }

    /**
     * @return: return true if there is no element in the array
     */
    bool isEmpty() {
        // write your code here
        return size == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    void enqueue(int element) {
        // write your code here
        if (isFull()) {
            throw ("full");
        }
        rear = (front + size) % len;
        circularQueue[rear] = element;
        size++;
    }

    /**
     * @return: pop an element from the queue
     */
    int dequeue() {
        // write your code here
        if (isEmpty()) {
            throw ("empty");
        }
        int result = circularQueue[front];
        front = (front + 1) % len;
        size--;
        return result;
        
    }
};
