#include <iostream>
#include <vector>

int removeDuplicates(std::vector<int>& nums) {
  int len = nums.size();
  for (int i = 0; i < len - 1; i++) {
    while (nums[i] == nums[i + 1]) {
      if (i + 1 == len - 1) {
        len--;
        break;
      }
      for (int j = i + 1; j < len - 1; j++) {
        nums[j] = nums[j + 1];
      } 
      len--;
    }
  }
  return len;
}

int main() {
  std::vector<int> vec = {1,1};
  std::cout << removeDuplicates(vec) << std::endl;
}
