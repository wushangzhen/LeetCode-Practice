#include <vector>
#include <iostream>

int singleNumber(std::vector<int>& nums) {
  for (int i = 0; i < nums.size() - 1; i++) {
    nums[i + 1] = nums[i + 1] ^ nums[i];
  } 
  return nums[nums.size() - 1];
}

int main() {
  std::vector<int> vec = {1, 2, 2, 3, 3};
  std::cout << singleNumber(vec) << std::endl;
}
