#include <iostream>
#include <vector>
using namespace std;
void moveZeroes(vector<int>& nums) {
  int count = 0;
  for (int i = 0; i < nums.size() - count; i++) {
    if (nums[i] == 0) {
      for (int j = i; j < nums.size() - 1; j++) {
        nums[j] = nums[j + 1];
        if (j + 1 == nums.size() - 1) {
            nums[j + 1] = 0;
        }
      }
      count++;
      i--;
    }
  }     
} // Time cost a lot my method

void moveZeroes(vector<int>& nums) {
  int j = 0, n = nums.size();
  for (int i = 0; i < n; i++) {
    if (nums[i] != 0) {
      nums[j] = nums[i];
      j++;
    }
  }
  for (; j < nums.size(); j++) {
    num[j] = 0;
  }
}

int main() {
  vector<int> vec = {0, 1, 0, 3, 12};
  moveZeroes(vec);
  for (int i = 0; i < vec.size(); i++) {
    cout << vec[i] << endl;
  }

}
