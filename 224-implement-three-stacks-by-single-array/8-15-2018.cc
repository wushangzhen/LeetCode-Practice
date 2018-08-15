class StackNode {
public:
    int prev, next;
    int value;
    StackNode(int p, int v, int n) { 
        value = v;
        prev = p;
        next = n;
    }
};

class ThreeStacks {
public:
    ThreeStacks(int size) {
        // do intialization if necessary
        stackSize = size;
        indexUsed = 0;
        for (int i = 0; i < 3; ++i)
            stackPointer.push_back(-1);
        buffer.resize(stackSize * 3);
    }
 
    void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value, -1);
    }

    int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        int value = buffer[stackPointer[stackNum]]->value;
        int lastIndex = stackPointer[stackNum];
        if (lastIndex != indexUsed - 1)
            swap(lastIndex, indexUsed - 1, stackNum);

        stackPointer[stackNum] = buffer[stackPointer[stackNum]]->prev;
        if (stackPointer[stackNum] != -1)
            buffer[stackPointer[stackNum]]->next = -1;

        buffer[indexUsed-1] = NULL;
        indexUsed --;
        return value;
    }

    int peek(int stackNum) {
        // Write your code here
        // Return the top element
        return buffer[stackPointer[stackNum]]->value;
    }

    bool isEmpty(int stackNum) {
        // Write your code here
        return stackPointer[stackNum] == -1;
    }

    void swap(int lastIndex, int topIndex, int stackNum) {
        if (buffer[lastIndex]->prev == topIndex) {
            int tmp = buffer[lastIndex]->value;
            buffer[lastIndex]->value = buffer[topIndex]->value;
            buffer[topIndex]->value = tmp;
            int tp = buffer[topIndex]->prev;
            if (tp != -1) {
                buffer[tp]->next = lastIndex;
            }
            buffer[lastIndex]->prev = tp;
            buffer[lastIndex]->next = topIndex;
            buffer[topIndex]->prev = lastIndex;
            buffer[topIndex]->next = -1;
            stackPointer[stackNum] = topIndex;
            return;
        }

        int lp = buffer[lastIndex]->prev;
        if (lp != -1)
            buffer[lp]->next = topIndex;
        
        int tp = buffer[topIndex]->prev;
        if (tp != -1)
            buffer[tp]->next = lastIndex;

        int tn = buffer[topIndex]->next;
        if (tn != -1)
            buffer[tn]->prev = lastIndex;
        else {
            for (int i = 0; i < 3; ++i)
                if (stackPointer[i] == topIndex)
                    stackPointer[i] = lastIndex;
        }

        StackNode* tmp = buffer[lastIndex];
        buffer[lastIndex] = buffer[topIndex];
        buffer[topIndex] = tmp;
        stackPointer[stackNum] = topIndex;
    }

private:
    int stackSize, indexUsed;
    vector<int> stackPointer;
    vector<StackNode*> buffer;
};
