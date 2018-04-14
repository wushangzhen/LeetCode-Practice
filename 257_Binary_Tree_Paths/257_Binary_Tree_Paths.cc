#include <iostream>
#include <string>
#include <vector>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
void binaryTreePathsHelper(TreeNode* node, 
    std::string str, std::vector<std::string>& vec_result);

std::vector<std::string> binaryTreePaths(TreeNode* root) {
  std::vector<std::string> vec_result;
  std::string str;
  binaryTreePathsHelper(root, str, vec_result);
  return vec_result;
}

void binaryTreePathsHelper(TreeNode* node, 
    std::string str, std::vector<std::string>& vec_result) {
  if (!node) {
    return;
  } else {
    str += std::to_string(node->val);
  }
  if (!node->left && !node->right) {
    vec_result.push_back(str);
  } else {
    str += "->";
  }
  binaryTreePathsHelper(node->left, str, vec_result);
  binaryTreePathsHelper(node->right, str, vec_result);
}


int main() {
  TreeNode node0(1);
  TreeNode node1(2);
  TreeNode node2(2);
  TreeNode node3(3);
  
  node0.left = &node1;
  node1.right = &node2;
  node0.right = &node3;
  for (auto s : binaryTreePaths(&node0)) {
    std::cout << s << std::endl;
  }

}
