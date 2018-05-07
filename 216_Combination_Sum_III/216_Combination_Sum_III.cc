#include <iostream>
vector<vector<int>> combinationSum3(int k, int n) {
  vector<vector<int> > vec_res;
  vector<int> path;
  helper(vec_res, path, n, k, 1);
  return vec_res;
}


void helper(vector<vector<int> >& vec_res, vector<int>& path, int n, int k, int ix) {
  if (n == 0 && path.size() == k) {
    vec_res.push_back(path);
    return;
  }
  for (int i = ix; i <= 9; i++) {
     if (n < i) {
      return;
    }
    path.push_back(i);
    helper(vec_res, path, n - i, k, i + 1);
    path.pop_back();
  }
}
