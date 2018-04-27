#include <iostream>

void rotate(vector<int>& nums, int k) {
         if (k == 0) {
             return;
         }
         while (k > 0) {
             nums.insert(nums.begin(), *(nums.end() - 1));
             k--;
             nums.erase(nums.end() - 1);
         }
         return;
    }
void rotate(vector<int>& nums, int k) {
  if (nums.size() == 0) {
    return;
  }
  k %= nums.size();
  reverse (nums.begin(), nums.end());
  reverse (nums.begin(), nums.begin() + k);
  reverse (nums.begin() + k, nums.end());
}
//void rotate(vector<int>& nums, int k) {
//  if (nums.size() == 0) {
//    return;
//  }
//  k %= nums.size();
//  for (int i = 0; i < k; i++) {
//    swap(nums[k - 1 - i], nums[nums.size() - 1 - i]); 
//    swap(nums.size() - 1 - i, nums[k + i]);
//  } 
//}

