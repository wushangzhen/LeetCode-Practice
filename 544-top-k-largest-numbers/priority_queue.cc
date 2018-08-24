struct Cmp {
    bool operator()(const int& a, const int& b) {
        return a > b;
    }
};
class Solution {
public:
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    vector<int> topk(vector<int> &nums, int k) {
        // write your code here
        if (nums.empty()) {
            return nums;
        }
        priority_queue<int, vector<int>, Cmp> priQue;
        for (int i = 0; i < nums.size(); i++) {
            priQue.push(nums[i]);
            if (i >= k) {
                priQue.pop();
            }
        }
        vector<int> result;
        while (!priQue.empty()) {
            int top = priQue.top(); 
            priQue.pop();
            result.push_back(top);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};
