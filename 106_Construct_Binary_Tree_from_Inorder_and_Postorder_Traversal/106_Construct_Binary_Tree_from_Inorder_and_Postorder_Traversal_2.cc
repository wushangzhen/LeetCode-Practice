#include <iostream>
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
  TreeNode* result;
  if (!inorder.size() || !postorder.size()) {
    return result;
  }
  if (inorder.size() != postorder.size()) {
    return result;
  }
  return helper(inorder, postorder, order.size() - 1, 0, )
}
