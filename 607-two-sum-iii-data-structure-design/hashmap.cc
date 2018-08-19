class TwoSum {
public:
    /*
     * @param number: An integer
     * @return: nothing
     */
    unordered_map<int, int> hashMap;
    void add(int number) {
        // write your code here
        hashMap[number]++;
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        for (unordered_map<int, int>::iterator it = hashMap.begin(); it != hashMap.end(); it++) {
            int target = value - it->first;
            if (target != it->first && hashMap.find(target) != hashMap.end() || (target == it->first && it->second > 1)) {
                return true;
            }
        }
        return false;
    }
};
