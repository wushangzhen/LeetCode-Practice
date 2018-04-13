#include <iostream>
#include <queue>
#include <vector>
//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void findPath(TreeNode* root, int sum,  
    std::vector<int> path, std::vector<std::vector<int> > &paths);
std::vector<std::vector<int> > pathSum(TreeNode* root, int sum) {
  std::vector<std::vector<int> > paths;
  std::vector<int> path;
  findPath(root, sum, path, paths);
  return paths;
}

void findPath(TreeNode* root, int sum, 
    std::vector<int> path, std::vector<std::vector<int> > &paths) {
  if (!root) {
    return;
  }
  if (!root->left && !root->right && sum == root->val) {
    path.push_back(root->val);
    paths.push_back(path);
  }
  path.push_back(root->val);
  findPath(root->left, sum - root->val, path, paths);
  findPath(root->right, sum - root->val, path, paths);
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

  for (auto i : pathSum(&node0, 7)) {
    for (auto j : i) {
      std::cout << j << std::endl;
    }
    std::cout << std::endl;
  }
}
