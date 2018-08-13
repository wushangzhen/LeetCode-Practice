#include <vector>
#include <queue>
using namespace std;
class Solution {
public:
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    vector<vector<int> > subsets(vector<int> &nums) {
        // write your code here
        sort(nums.begin(), nums.end());
        vector<vector<int>> results;
        queue<vector<int>> que;
        vector<int> vec;
        vector<int> vecTemp;
        que.push(vec);
        int len = nums.size();
        while (!que.empty()) {
            vecTemp = que.front();
            que.pop();
            results.push_back(vecTemp);
            for (int i = 0; i < len; i++) {
                if (vecTemp.size() == 0 || vecTemp[vecTemp.size() - 1] < nums[i]) {
                    vec = vecTemp;
                    vec.push_back(nums[i]);
                    que.push(vec);
                }
            }
        }
        return results;
    }
};
