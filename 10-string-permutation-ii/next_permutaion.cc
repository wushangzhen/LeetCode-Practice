#include <algorithm>
class Solution {
public:
    /**
     * @param str: A string
     * @return: all permutations
     */
    vector<string> stringPermutation2(string &str) {
        // write your code here
        vector<string> result;
        sort(str.begin(), str.end());
        result.push_back(str);
        while (next_permutation(str.begin(), str.end())) {
            result.push_back(str);
        }
        return result;
    }
};
