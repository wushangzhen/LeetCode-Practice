#include <map>
#include <vector>
using namespace std;
struct Compare {
   bool operator()(const int& x, const int& y) {
       return x > y;
   } 
};

class Solution {
public:
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    vector<int> subarraySumClosest(vector<int> &nums) {
        // write your code here
        vector<int> result;
        if (nums.empty()) {
            return result;
        }
        int prefixSum = 0;
        map<int, int, Compare> treeMap;
        treeMap[prefixSum] = 0;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums[i];
            if (treeMap.find(prefixSum) != treeMap.end()) {
                result.push_back(treeMap[prefixSum]);
                result.push_back(i);
                return result;
            }
            treeMap[prefixSum] = i + 1;
        }
        map<int, int>::iterator iter = treeMap.begin();
        map<int, int>::iterator iter2 = treeMap.begin();
        iter2++;
        int min = INT_MAX;
        for (; iter != treeMap.end() && iter2 != treeMap.end(); iter++, iter2++) {
            if (std::abs(iter2->first - iter->first) <= min) {
                while (!result.empty()) {
                    result.pop_back();
                }
                int index1 = iter2->second;
                int index2 = iter->second;
                if (index1 < index2) {
                    result.push_back(index1);
                    result.push_back(index2 - 1);
                } else {
                    result.push_back(index2);
                    result.push_back(index1 - 1);
                }
                min = std::abs(iter2->first - iter->first);
            }
        }
        return result;
    }
};

