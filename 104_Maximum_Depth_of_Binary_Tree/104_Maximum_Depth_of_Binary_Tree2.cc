#include <iostream>
#include <queue>
struct TreeNode {
 int data;
 TreeNode* left; 
 TreeNode* right;

 TreeNode(int i) : data(i), left(nullptr), right(nullptr) {};
};
int maxDepth(TreeNode* root) {
  if (NULL == root) {
    return 0;
  }
  std::queue<TreeNode*> q;
  q.push(root);
  int max_depth = 0;
  while (!q.empty()) {
    int size = q.size();// be careful with this because for range edge cannot be changed
    for (int i = 0; i < size; i++) {
      TreeNode* node = q.front();
      q.pop();

      if (node->left) {
        q.push(node->left);
      }
      if (node->right) {
        q.push(node->right);
      }
    }
    max_depth++;
  }
  return max_depth;

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

