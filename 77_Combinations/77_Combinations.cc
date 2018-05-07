#include <iostream>
#include <vector>
vector<vector<int> > combine(int n, int k) {
  vector<vector<int> > vec_res;
  vector<int> path;
  helper(vec_res, path, 1, k, n);
  return vec_res;
}
void helper(vector<vector<int> >& vec_res, vector<int>& path, int ix, int k, int n) {
  if (path.size() == k) {
    vec_res.push_back(path);
    return;
  }
  for (int i = ix; i <= n; i++) {
    path.push_back(i);
    helper(vec_res, path, i + 1, k, n);
    path.erase(path.end() - 1);
  }
}
