#include <iostream>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

TreeNode* invertTree(TreeNode* root) {
  if (root == NULL) {
    return NULL;
  }
  TreeNode* temp = root->left;
  root->left = root->right; 
  root->right = temp;
  invertTree(root->right);
  invertTree(root->left);
  return root;
}

void display(TreeNode* root) {
  if (!root) {
    return;
  }
  std::cout << root->val << std::endl;
  display(root->left);
  display(root->right);
}

int main() {
  TreeNode node0(4);
  TreeNode node1(2);
  TreeNode node2(7);
  TreeNode node3(1);
  TreeNode node4(3);
  TreeNode node5(6);
  TreeNode node6(9);

  node0.left = &node1;
  node0.right= &node2;
  node1.left= &node3;
  node1.right= &node4;
  node2.left= &node5;
  node2.right= &node6;
  display(&node0);
  std::cout << "------" << std::endl;
  display(invertTree(&node0));
  return 0;
}

