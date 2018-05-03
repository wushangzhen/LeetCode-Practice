#include <iostream>
vector<vector<int>> permute(vector<int>& nums) {
  vector<vector<int> > vec;
  if (nums.size() == 0) {
    return vec;
  }
  int size = nums.size();
  helper(vec, size, 0, nums);  
  return vec;
}
void helper(vector<vector<int> >& vec, int size, int num, vector<int>& nums) {
  if (num == size) {
    vec.push_back(nums);
    return;
  }
  for (int i = num; i < size; i++) {
    swap(nums[num], nums[i]);
    helper(vec, vec_temp, size, num + 1, nums);
    swap(nums[num], nums[i]);
  }
}
