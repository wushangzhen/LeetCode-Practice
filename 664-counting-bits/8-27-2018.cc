class Solution {
public:
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    vector<int> countBits(int num) {
        // write your code here
        vector<int> result;
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                count++;
                temp = (temp & (temp - 1));
            }
            result.push_back(count);
        }
        return result;
    }
};
