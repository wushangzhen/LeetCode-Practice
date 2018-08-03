#include <set>
#include <vector>
using namespace std;
class Solution {
public:
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    int deduplication(vector<int> &nums) {
        // write your code here
        set<int> set1;
        for (int i = 0; i < nums.size(); i++) {
            set1.insert(nums[i]);
        }
        set<int>::iterator iter = set1.begin();
        for (int i = 0; iter != set1.end(); i++, iter++) {
            nums[i] = *iter;
        }
        return set1.size();
    }
};
