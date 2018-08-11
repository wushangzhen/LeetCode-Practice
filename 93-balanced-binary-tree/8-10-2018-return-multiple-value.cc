/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */

class ResultType {
public:
    bool isBalanced;
    int currentDepth;
    ResultType(bool _isBalanced, int _currentDepth) {
        isBalanced = _isBalanced;
        currentDepth = _currentDepth;
    }
}
class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    bool isBalanced(TreeNode * root) {
        // write your code here
        return maxDepth(root)->isBalanced;
    }
private:
    ResultType* maxDepth(TreeNode* root) {
        if (root == NULL) {
            return new ResultType(true, 0);
        }
        ResultType* left = maxDepth(root->left);
        ResultType* right = maxDepth(root->right);
        if (!left->isBalanced || !right->isBalanced) {
            return new ResultType(false, -1);
        }
        if (abs(left->currentDepth - right->currentDepth) > 1) {
            return new ResultType(false, -1);
        }
        return new ResultType(true, max(left->currentDepth, right->currentDepth) + 1);
    }   
};
