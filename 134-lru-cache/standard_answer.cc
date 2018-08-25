class KeyValue {
public:
    int key, val;
    KeyValue* next;
    KeyValue(int key, int val) {
        this->key = key;
        this->val = val;
        this->next = NULL;
    }
};
class LRUCache {
public:
    int capacity, size = 0;
    KeyValue* dummy; 
    KeyValue* tail;
    unordered_map<int, KeyValue*> keyToPrev;
    /*
    * @param capacity: An integer
    */LRUCache(int capacity) {
        // do intialization if necessary
        this->capacity = capacity;
        this->dummy = new KeyValue(0, 0);
        this->tail = dummy;
    }
    void moveToTail(int key) {
        KeyValue* prev = keyToPrev[key];
        KeyValue* curt = prev->next;
        if (tail == curt) {
            return;
        }
        prev->next = prev->next->next;
        tail->next = curt;
        if (prev->next != NULL) {
            keyToPrev[prev->next->key] = prev;
        }
        keyToPrev[curt->key] = tail;
        tail = curt;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    int get(int key) {
        // write your code here
        if (keyToPrev.find(key) == keyToPrev.end()) {
            return -1;
        }
        moveToTail(key);
        return tail->val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            KeyValue* prev = keyToPrev[key];
            prev->next->val = value;
            return;
        }
        if (size < capacity) {
            size++;
            KeyValue* curt = new KeyValue(key, value);
            tail->next = curt;
            keyToPrev[key] = tail;
            tail = curt;
            return;
        }
        KeyValue* first = dummy->next;
        keyToPrev.erase(first->key);
        first->key = key;
        first->val = value;
        keyToPrev[first->key] = dummy;
        moveToTail(key);
    }
};
