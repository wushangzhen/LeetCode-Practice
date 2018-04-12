#include <iostream>
//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isSymmetricRecursive(TreeNode* node1, TreeNode* node2);
bool isSymmetric(TreeNode* root) {
  if (root == NULL) {
    return true;
  }    
      
  return isSymmetricRecursive(root->left, root->right);
  
}

bool isSymmetricRecursive(TreeNode* node1, TreeNode* node2) {
  if (node1 == NULL || node2 == NULL) {
    return node1 == node2;
  } else {
    if (node1->val != node2->val) {
      return false;
    }
  }
  return isSymmetricRecursive(node1->left, node2->right) && 
      isSymmetricRecursive(node1->right, node2->left);
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
  node0.right = &node2;
  node1.left = &node3;
  node1.right = &node4;
  node2.left = &node5;
  node2.right = &node6;
  std::cout << isSymmetric(&node0) << std::endl;

}

