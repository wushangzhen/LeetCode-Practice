class TwoSum {
public:
    /*
     * @param number: An integer
     * @return: nothing
     */
    vector<int> vec;
    void add(int number) {
        // write your code here
        vec.push_back(number);
        
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    bool find(int value) {
        // write your code here
        sort(vec.begin(), vec.end());
        for (int i = 0, j = vec.size() - 1; i < j;) {
            if (vec[i] + vec[j] == value) {
                return true;
            } else if (vec[i] + vec[j] < value) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
};
