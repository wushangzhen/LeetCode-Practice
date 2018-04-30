#include <iostream>


//Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
 public:
  TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    if (!preorder.size() || !inorder.size()) {
      return NULL;
    }
    if (preorder.size() != inorder.size()) {
      return NULL;
    }
    return build(preorder, inorder, 0, 0, inorder.size() - 1);
  }
  TreeNode* build(vector<int> preorder, vector<int> inorder, int preIndex, int startInIndex, int endInIndex) {
    if (endInIndex < startInIndex) {
      return NULL;
    }
    TreeNode* node = new TreeNode(preorder[preIndex]);
    int index = getIndexInOrder(inorder, preorder[preIndex]);
    int lenL = index - startInIndex;
    int LenR = endInIndex - startInIndex - lenL;
    if (lenL > 0) {
      node->left = build(preorder, inorder, preIndex + 1, startInIndex, index - 1);
    }
    if (LenR > 0) {
      node->right = build(preorder, inorder, preIndex + lenL + 1, index + 1, endInIndex);
    }
    return node;
  }

  int getIndexInOrder(vector<int> inorder, int val) {
    for (int i = 0; i < inorder.size(); i++) {
      if (val == inorder[i]) {
        return i;
      }
    }
    return -1;
  }
};

