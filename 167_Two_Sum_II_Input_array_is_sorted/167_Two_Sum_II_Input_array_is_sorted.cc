#include <iostream>

vector<int> twoSum(vector<int>& numbers, int target) {
  vector<int> vec_res;
  int i = 0;
  int j = numbers.size() - 1;
  while (i < j) {
    if (numbers[i] + numbers[j] == target) {
      vec_res.push_back(i + 1);
      vec_res.push_back(j + 1);
      return vec_res;
    } else if (numbers[i] + numbers[j] > target) {
      j--;
    } else if (numbers[i] + numbers[j] < target) {
      i++;
    }
  }
  return vec_res;
}
