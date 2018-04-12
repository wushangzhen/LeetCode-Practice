#include <unordered_set>
#include <iostream>
#include <queue>


struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
bool hasPathSum(TreeNode* root, int sum) {
  if (!root) return false;
  if (root->left == NULL && root->right == NULL) {
    return root->val == sum;
  }
  return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right,
      sum - root->val); 
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

  std::cout << hasPathSum(&node0, 7) << std::endl;
 
}
