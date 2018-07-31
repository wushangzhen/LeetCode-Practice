#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    void reverseElement(vector<int> &nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    void recoverRotatedSortedArray(vector<int> &nums) {
        // write your code here
        if (nums.empty()) {
            return;
        }
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                reverseElement(nums, 0, i);
                reverseElement(nums, i + 1, nums.size() - 1);
                reverseElement(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
};

int main() {
    Solution s;
    int a[5] = {4, 5, 1, 2, 3};
    vector<int> vec(a, a + 5);
    s.reverseElement(vec, 0, 1);
    for (int i = 0; i < 5; i++) {
        cout << vec[i] << endl;
    }
}
