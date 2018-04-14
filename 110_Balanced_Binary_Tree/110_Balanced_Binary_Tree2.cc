int maxDepth(TreeNode* node) {
  if (!node) {
    return 0;
  }
  return std::max(maxDepth(node->left), maxDepth(node->right)) + 1;
}
bool isBalancedTree(TreeNode* node) {
  if (!node) {
    return true;
  }
  int left = maxDepth(node->left);
  int right = maxDepth(node->right);
  return std::abs(left - right) <= 1 && isBalancedTree(node->left) 
      && isBalancedTree(node->right);
}
