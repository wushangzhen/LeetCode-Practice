#include <iostream>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int minDepth(TreeNode* root) {
  if (root == NULL) {
    return 0;
  }
  if (0 == minDepth(root->left) || 0 == minDepth(root->right)) {
    return std::max(minDepth(root->left), minDepth(root->right)) + 1;
  }
  return std::min(minDepth(root->left), minDepth(root->right)) + 1;
}

int main() {
  TreeNode node0(1);
  TreeNode node1(2);
  TreeNode node2(2);
  TreeNode node3(4);
  TreeNode node4(3);
  TreeNode node5(3);
  TreeNode node6(4);

  node0.left = &node1;
  node1.right = &node2;
  node2.left = &node3;
  node3.right = &node4;
  node4.left = &node5;
  node0.right = &node6;

  

  std::cout << minDepth(&node0) << std::endl;
}

