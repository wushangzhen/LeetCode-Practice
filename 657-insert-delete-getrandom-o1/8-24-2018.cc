class RandomizedSet {
public:
    unordered_map<int, int> valueAndIndex;
    vector<int> vec;
    int capacity = 0;
    RandomizedSet() {
        // do intialization if necessary
        srand(time(NULL));
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    bool insert(int val) {
        // write your code here
        if (valueAndIndex.find(val) == valueAndIndex.end()) {
            valueAndIndex[val] = capacity;
            vec.push_back(val);
            capacity++;
            return true;
        }
        return false;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    bool remove(int val) {
        // write your code here
        if (valueAndIndex.find(val) != valueAndIndex.end()) {
            if (valueAndIndex[val] < capacity - 1) {
                vec[valueAndIndex[val]] = vec[capacity - 1];
                vec[capacity - 1] = val;
            }
            capacity--;
            vec.pop_back();
            valueAndIndex.erase(val);
            return true;
        }
        return false;
    }

    /*
     * @return: Get a random element from the set
     */
    int getRandom() {
        // write your code here
        if (capacity < 1) {
            return 0;
        }
        return vec[rand() % capacity];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param = obj.insert(val);
 * bool param = obj.remove(val);
 * int param = obj.getRandom();
 */
