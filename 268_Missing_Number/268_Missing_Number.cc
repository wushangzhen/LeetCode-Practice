#include <iostream>
#include <vector>

using namespace std;
//int missingNumber(vector<int>& nums) {
//  if (nums.size() == 0) {
//    return -1;
//  }
//  sort(nums.begin(), nums.end());
//  for (int i = 0; i < nums.size() - 1; i++) {
//    if (nums[i + 1] - nums[i] == 2) {
//      return nums[i] + 1;
//    }
//  }
//  return -1;
//} // this is not the right answer


int missingNumber(vector<int>& nums) {
  int res = 0;
  for (int i = 1; i < nums.size() + 1; i++) {
    res = res ^ i ^ nums[i - 1];
  }
  return res;
}
int main() {
  vector<int> vec = {9,6,4,2,3,5,7,0,1};
  cout << missingNumber(vec) << endl;
}
