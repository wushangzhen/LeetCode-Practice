#include <iostream>
#include <vector>
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
void levelOrderBottomHelper(TreeNode* node, vector<vector<int>>& vec_result,
    int i) {
  if (!node) {
    return;
  }
  if (vec_result.empty() || i > (vec_result.size() - 1)) {
		vec_result.push_back(vector<int>());
  }
  levelOrderBottomHelper(node->left, vec_result, i + 1);
  levelOrderBottomHelper(node->right, vec_result, i + 1);
  vec_result[i].push_back(node->val);
}
vector<vector<int> > levelOrderBottom(TreeNode* root) {
   vector<vector<int> > vec_result;
   levelOrderBottomHelper(root, vec_result, 0);
   reverse(vec_result.begin(), vec_result.end());
   return vec_result;
}



