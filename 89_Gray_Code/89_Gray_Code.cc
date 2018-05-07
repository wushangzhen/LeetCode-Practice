#include <iostream>


vector<int> grayCode(int n) {
  // 为了简化代码，这里初值实际上设定的是Ans{0}
  vector<int> ans(1, 0);
  // 依次根据Ans{i}计算Ans{i+1}
  for (int i = 0; i < n; i++) {
      // 在身后逆序复制，并且每个都加上2^i
      for (int j = ans.size() - 1; j >= 0; j--) {
          ans.push_back((1 << i) + ans[j]);
      }
  }
  // 返回结果
  return ans;
}

