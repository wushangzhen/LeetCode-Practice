#include <iostream>
struct TreeNode {
 int data;
 TreeNode* left; 
 TreeNode* right;

 TreeNode(int i) : data(i), left(nullptr), right(nullptr) {};
};
int maxDepth(TreeNode* root) {
  if (root == nullptr) {
    return 0;
  }
  int left_depth = maxDepth(root->left);
  int right_depth = maxDepth(root->right);
  return std::max(left_depth, right_depth) + 1;

}
int main() {
  TreeNode node0(1);
  TreeNode node1(1);
  TreeNode node2(1);
  TreeNode node3(1);
  node0.left = &node1;
  node1.left = &node2;
  node2.right = &node3;
  std::cout << maxDepth(&node0) << std::endl;
}
