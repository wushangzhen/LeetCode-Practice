#include <iostream>
#include <vector>
int maxSubArray(std::vector<int>& nums) {
  int res = INT_MIN;
  int sum = 0;
  for (auto num : nums) {
    sum = std::max(sum + num, num);
    res = std::max(res, sum);
  }
  return res;
}
int main() {
  std::vector<int> vec = {-2,1,-3,4,-1,2,1,-5,4};
  std::cout << maxSubArray(vec) << std::endl;
}
