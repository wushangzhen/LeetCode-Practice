#include <iostream>
#include <vector>

int searchInsert(std::vector<int>& nums, int target) {
  if (target <= nums[0]) {
    return 0;
  }
  for (int i = 0; i < nums.size() - 1; i++) {
    if (nums[i] < target && nums[i + 1] >= target) {
      return i + 1;
    }
  }
  return nums.size();
}

int main() {
  std::vector<int> vec = {1, 3, 5, 6};
  std::cout << searchInsert(vec, 2) << std::endl;
}

