#include <iostream>
#include <vector>
void subsetsHelper(std::vector<std::vector<int> >& vec_result, 
    std::vector<int>& vec, std::vector<int>& nums, int pos);
std::vector<std::vector<int> > subsets(std::vector<int>& nums) {
  std::vector<std::vector<int> > vec_result;
  std::vector<int> vec;
  int pos = 0;
  subsetsHelper(vec_result, vec, nums, pos);
  return vec_result;
}
  
void subsetsHelper(std::vector<std::vector<int> >& vec_result, 
    std::vector<int>& vec, std::vector<int>& nums, int pos) {
  vec_result.push_back(vec);
  for (int i = pos; i < nums.size(); i++) {
    vec.push_back(nums[pos]);
    subsetsHelper(vec_result, vec, nums, i + 1);
    vec.pop_back();
  }

}

class Solution {
public:
    std::vector<std::vector<int>> subsets(std::vector<int>& nums) {
        sort(nums.begin(), nums.end());
        std::vector<std::vector<int>> subs;
        std::vector<int> sub;
        genSubsets(nums, 0, sub, subs);
        return subs;
    }
    void genSubsets(std::vector<int>& nums, int start, std::vector<int>& sub, std::vector<std::vector<int>>& subs) {
        subs.push_back(sub);
        for (int i = start; i < nums.size(); i++) {
            sub.push_back(nums[i]);
            genSubsets(nums, i + 1, sub, subs);
            sub.pop_back();
        }
    }
};

int main() {
  std::vector<int> vec = {1, 2, 3};
  std::vector<std::vector<int> > vec_result = subsets(vec); 
  for (auto vec1 : vec_result) {
    std::cout << "{";
    for (auto s : vec1) {
      std::cout<< s << ",";
    }
    std::cout << "}";
  }
}
