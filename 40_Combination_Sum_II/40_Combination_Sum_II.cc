#include <iostream>

vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
  sort(candidates.begin(), candidates.end());
  vector<vector<int> > vec_res;
  vector<int> path;
  helper(vec_res, 0, target, path, candidates);
  return vec_res;
}
void helper(vector<vector<int> >& vec_res, int ix, int remain, vector<int>& path, 
    vector<int>& candidates) {
  if (remain == 0) {
    vec_res.push_back(path);
    return;
  }    
  for (int i = ix; i < candidates.size(); i++) {
    if (remain < candidates[i]) {
      return;
    }
    path.push_back(candidates[i]);
    helper(vec_res, i + 1, remain - candidates[i], path, candidates);
    path.pop_back();
    while (i < candidates.size() && candidates[i+1] == candidates[i]) {// 避免重复组合
      ++i;
    }
  }
}
