#include <iostream>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  vector<TreeNode*> generateTrees(int n) {
    vector<TreeNode*> result_vec;
    if (n < 1) {
      return result_vec;
    }
    return helper(1, n);
  }
  vector<TreeNode*> helper(int start, int end) {
    vector<TreeNode*> result_vec;
    if (start > end) {
      result_vec.push_back(NULL);
      return result_vec;
    }
    for (int i = start; i <= end; i++) {
      vector<TreeNode*> leftChild = helper(start, i - 1);
      vector<TreeNode*> rightChild = helper(i + 1, end);
      for (auto left : leftChild) {
        for (auto right : rightChild) {
          TreeNode* root = new TreeNode(i);
          root->left = left;
          root->right = right;
          result_vec.push_back(root);
        }
      }
    }
    return result_vec;
  }
};
