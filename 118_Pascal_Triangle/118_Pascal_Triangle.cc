#include <iostream>
#include <vector>
vector<vector<int> > generate(int numRows) {
  vector<vector<int> > vec_res;
  for (int i = 0; i < numRows; i++) {
    vec_res.push_back(vector<int>(i + 1, 1));
  }
  for (int i = 0; i < numRows; i++) {
    for (int j = 1; j < i; j++) {
      vec_res[i][j] = vec_res[i - 1][j - 1] + vec_res[i - 1][j]; 
    }
  } 
  return vec_res;
}
