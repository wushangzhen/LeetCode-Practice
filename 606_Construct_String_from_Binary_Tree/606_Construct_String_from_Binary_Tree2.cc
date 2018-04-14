#include <string>

std::string tree2str(TreeNode* node) {
  if (!node) {
    return "";
  }
  string s = to_string(node->val);
  if (node->left) {
    s += "(" + tree2str(node->left) + ")";
  } else if (node->right) {
    s += "()"; 
  }
  if (node->right) {
    s += "(" + tree2str(node->right) + ")";
  }
  return s;
}
