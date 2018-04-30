#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
  vector<vector<int> > vec_res;
  if (!root) {
    return vec_res;
  }
  int level = 0;
  queue<TreeNode*> que;
  que.push(root);
  while (!que.empty()) {
    int size = que.size();
    vector<int> vec;
    while (size--) {
      TreeNode* temp = que.front();
      que.pop();
      if (temp->left) {
        que.push(temp->left);
      }
      if (temp->right) {
        que.push(temp->right);
      }
      vec.push_back(temp->val);
    }
    level++;
    if (level % 2 == 0) {
      reverse(vec.begin(), vec.end());
    } 
    vec_res.push_back(vec);
  }
  return vec_res;
}
