#include <iostream>
#include <vector>
#include <queue>


//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void isBalancedHelper(TreeNode* node1, std::vector<int>& vec);
bool isBalanced(TreeNode* root) {
  std::vector<int> vec;
  if (!root) {
    return true;
  }
  isBalancedHelper(root, vec);
  if (!vec.empty()) {
    return false;
  }
  return true;
}

int maxDepth (TreeNode* node2);
void isBalancedHelper(TreeNode* node1, std::vector<int>& vec) {
  if (!node1) {
    return;
  }
  std::queue<TreeNode*> que;
  TreeNode* temp;
  que.push(node1);
  int a = 0;
  int b = 0;
  while (!que.empty()) {
    temp = que.front();
    que.pop();

    if (temp->left) {
      a = maxDepth(temp->left); 
      que.push(temp->left);
    } else {
      a = 0;
    }
    if (temp->right) {
      b = maxDepth(temp->right);
      que.push(temp->right);
    } else {
      b = 0;
    }
    if (std::abs(a-b) > 1) {
      vec.push_back(std::abs(a - b));
    }
  }
  //if (!node1->right && node1->left) {
  //  if (maxDepth(node1->left) > 1) {
  //    vec.push_back(maxDepth(node1->left));
  //  }
  //}
  //if (node1->right && !node1->left) {
  //  if (maxDepth(node1->right) > 1) {
  //    vec.push_back(maxDepth(node1->right));
  //  }
  //}

  //if (/*node1->left && node1->right &&*/ 
  //    std::abs(maxDepth(node1->left) - maxDepth(node1->right)) > 1) { 
  //  vec.push_back(maxDepth(node1->left) - maxDepth(node1->right));
  //}
}

int maxDepth (TreeNode* node2) {
  if (!node2) {
    return 0;
  }

  return std::max(maxDepth(node2->left), 
      maxDepth(node2->right)) + 1;
}

int main() {
  TreeNode node0(1);
  TreeNode node1(2);
  TreeNode node2(2);
  TreeNode node3(3);
  TreeNode node4(3);
  TreeNode node5(4);
  TreeNode node6(4);
  node0.left = &node1;
  node1.left = &node3;
 // node3.left = &node5;
  node3.left = &node4;
  node0.right = &node2;
  node2.right = &node5;
  node5.right = &node6;
  std::cout << isBalanced(&node0) << std::endl;

}
