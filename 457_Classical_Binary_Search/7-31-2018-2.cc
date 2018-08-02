#include <vector>
using namespace std;

class Solution {
    int findPosition(vector<int> nums, int target) {
        if (nums.empty()) {
            return -1;
        }
        int start = 0; 
        int end = nums.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
};
int main() {
}
