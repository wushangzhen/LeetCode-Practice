#include <iostream>
#include <vector>

void subsetsWithDupHeper(std::vector<std::vector<int> >& vec_result, 
    std::vector<int>& vec, std::vector<int>& nums, int paths) {
  vec_result.push_back(vec);
  for (int i = paths; i < nums.size(); i++) {
    if (i == paths || nums[i] != nums[i-1]){
      vec.push_back(nums[i]);
      subsetsWithDupHeper(vec_result, vec, nums, i + 1);
      vec.pop_back();
    }
  }
}
std::vector<std::vector<int> > subsetsWithDup(std::vector<int>& nums) {
  std::sort(nums.begin(), nums.end());
  std::vector<std::vector<int> > vec_result;
  std::vector<int> vec;
  int paths = 0;
  subsetsWithDupHeper(vec_result, vec, nums, paths); 
  return vec_result;
}


int main() {
  std::vector<int> vec = {1, 2, 2};
  std::vector<std::vector<int> > vec_result = subsetsWithDup(vec); 
  for (auto vec1 : vec_result) {
    std::cout << "{";
    for (auto s : vec1) {
      std::cout<< s << ",";
    }
    std::cout << "}";
  }
 
}
