#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    int findPosition(vector<int> &nums, int target) {
        // write your code here
        if (nums.size() == 0) {
            return -1;
        }
        return binarySearch(0, nums.size() - 1, target, nums);
    }
private:
    int binarySearch(int start, int end, int &target, vector<int> &nums) {
        if (start > end) {
            return -1;
        }
        // int mid = (start / 2 + end / 2);// may overflow
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return binarySearch(mid + 1, end, target, nums);
        }
        return binarySearch(start, mid - 1, target, nums);
    }
};

int main() {

}
