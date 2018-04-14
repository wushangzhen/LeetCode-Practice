#include <iostream>
#include <string>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void tree2strHelper(TreeNode* node, std::string& str);
std::string tree2str(TreeNode* t) {
  std::string str;
  if (!t) {
    str += ""; 
  } else {
    tree2strHelper(t, str);
  }
  return str;
}

void tree2strHelper(TreeNode* node, std::string& str) {
   if (!node) {
     return;
   }
   if (str.empty()) {
     str += std::to_string(node->val);
     tree2strHelper(node->left, str);
     if (!node->left && node->right) {
         str += "()";
     } 
     tree2strHelper(node->right, str);
   } else {
     str = str + "(" + std::to_string(node->val);
     tree2strHelper(node->left, str);
     if (!node->left && node->right) {
         str += "()";
     } 
     tree2strHelper(node->right, str);
     str += ")";
   }
}
//str::string tree2strHelper2 (TreeNode* node) {
//  if (node && !node->left && node->right) {
//    return "()";
//  }
//  if (!node) {
//    return "";
//  }
//  return tree2strHelper2()
//}


int main() {
  TreeNode node1(1);
  TreeNode node2(2);
  TreeNode node3(3);
  TreeNode node4(4);
  node1.left = &node2;
  node2.right = &node4;
  node1.right = &node3;
  std::cout << tree2str(&node1) << std::endl;
  
}
