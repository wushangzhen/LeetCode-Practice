#include <iostream>

int rob(vector<int>& nums) {
  if (nums.size() == 0) {
    return 0;
  }
  if (nums.size() == 1) {
    return nums[0];
  }
  if (nums.size() == 2) {
    return std::max(nums[0], nums[i]);
  }
  int n = nums.size();
  vector<int> f(n, 0);
  f[0] = nums[0];
  f[1] = std::max(nums[0], nums[1]);
  for (int i = 2; i < n; i++) {
    f[i] = std::max(nums[i] + f[i - 2], f[i - 1]);
  }
  return f[i - 1];
}
