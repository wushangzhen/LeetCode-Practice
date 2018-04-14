#include <iostream>
#include <vector>
#include <stack>
#include <unordered_map>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void inorderTraversalHelper(TreeNode* root, std::vector<int>& vec); 
std::vector<int> inorderTraversal(TreeNode* root) {
  std::vector<int> vec;
  if (!root) {
    return vec; 
  } else {
    inorderTraversalHelper(root, vec); 
    return vec;
  }
}
void inorderTraversalHelper(TreeNode* root, std::vector<int>& vec) {
  if (!root) {
    return;
  }
  inorderTraversalHelper(root->left, vec);
  vec.push_back(root->val);
  inorderTraversalHelper(root->right, vec);
}


std::vector<int> inorderTraversal2(TreeNode* root) {
  std::vector<int> vec;
  if (!root) {
    return vec;
  }
  std::stack<TreeNode*> stk;
  stk.push(root);
  TreeNode* temp;
  while (!stk.empty()) {
    temp = stk.top(); 
    if (temp->left) {
      stk.push(temp->left);
      temp->left = NULL;
    } else {
      stk.pop();
      vec.push_back(temp->val);
      if (temp->right) {
        stk.push(temp->right); 
      }
    }
  }
  return vec;
}

std::vector<int> inorderTraversal3(TreeNode* root) {
  std::vector<int> vec;
  std::unordered_map<TreeNode*, bool> un_map;
  std::stack<TreeNode*> stk;
  if (!root) {
    return vec;
  }
  stk.push(root);
  TreeNode* temp;
  while (!stk.empty()) {
    temp = stk.top();
    if (temp->left && !un_map[temp]) {
      stk.push(temp->left);
      un_map[temp] = true;
    } else {
      stk.pop();
      vec.push_back(temp->val);
      if (temp->right) {
        stk.push(temp->right);
      }
    }
  }
  return vec;
}


int main() {
  TreeNode node0(0);
  TreeNode node1(1);
  TreeNode node2(2);
  TreeNode node3(3);
  node0.right = &node1;
  node1.left = &node2;

  for (auto e : inorderTraversal3(&node0)) {
    std::cout << e << std::endl;
  }

}
