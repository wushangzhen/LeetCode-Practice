#include <iostream>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* sortedArrayToBST(vector<int>& nums) {
  if (nums.size() == 0) {
    return NULL;
  }
  if (nums.size() == 1) {
    TreeNode* node = new TreeNode(nums[0]);
    return node;
  }
  int mid = nums.size() / 2;
  TreeNode* root = new TreeNode(nums[mid]);
  auto leftTree = vector<int> (nums.begin(), nums.begin() + mid); 
  auto rightTree = vector<int> (nums.begin() + mid + 1, nums.end());
  root->left = sortedArrayToBST(leftTree);
  root->right = sortedArrayToBST(rightTree);
  return root;
}
