#include <iostream>
vector<vector<int> > combinationSum(vector<int>& candidates, int target) {
  sort(candidates.begin(), candidates.end());
  vector<vector<int> > vec_res;
  vector<int> vec_path;
  helper(vec_res, 0, target, vec_path, candidates);
  return vec_res;
}
void helper(vector<vector<int> >& vec, int ix, int remain, vector<int>& path, 
  vector<int>& candidates) {
  if (remain == 0) {
    vec.push_back(path);
    return;
  }
  for (int i = ix; i < candidates.size(); i++) {
    if (remain < candidates[i]) {
      return;
    }
    path.push_back(candidates[i]);
    helper(vec, i, remain - candidates[i], path, candidates);
    path.pop_back();
  }
}

