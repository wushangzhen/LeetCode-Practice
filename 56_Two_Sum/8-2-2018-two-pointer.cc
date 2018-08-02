#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
class Solution {
public:
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &numbers, int target) {
        // write your code here
        int len = numbers.size();
        vector<int> res;
        if (len == 0) {
            return res;
        }
        std::sort(numbers.begin(), numbers.end());
        int left = 0, right = len - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                res.push_back(left);
                res.push_back(right);
                return res;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
        
    }
};
