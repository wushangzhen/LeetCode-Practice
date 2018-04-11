#include <iostream>


//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool isSameTree(TreeNode* p, TreeNode* q) {
  if (p == NULL || q == NULL) {
     return p == q; 
  }
  return (p->val == q->val && isSameTree(p->left, q->left) 
      && isSameTree(p->right, q->right));
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

  TreeNode node7 = node0;
  std::cout << isSameTree(&node7, &node0) << std::endl; 
 
}
