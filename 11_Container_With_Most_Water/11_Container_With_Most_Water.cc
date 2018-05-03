#include <iostream>
#include <vector>
using namespace std;
int maxArea(vector<int>& height) {
  if (height.size() == 0) {
    return 0;
  }
  int i = 0;
  int j = height.size() - 1;
  int res = 0;
  while (i != j) {
    res = max(res, min(height[i], height[j]) * (j - i));
    if (height[i] < height[j]) {
      i++;
    } else {
      j--;
    }
  }
  return res;
}

int main() {
  vector<int> vec = {1, 4, 3, 2};
  cout << maxArea(vec) << endl;
}
