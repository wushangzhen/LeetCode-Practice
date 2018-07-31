#include <vector>
using namespace std;
class Solution {
public:
    int findPostion(vector<int> &nums, int target) {
        if (nums.empty()) {
            return -1;
        }
        int start = 0;
        int end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
                // end = mid;
                //return mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            if (nums[mid] > target) {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == end) {
            return end;
        }
        return -1;
    }
};

int main() {
    return 0;
} 
