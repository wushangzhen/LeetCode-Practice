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

class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    int NOT_BALANCED = -1;
    bool isBalanced(TreeNode * root) {
        // write your code here
        return maxDepth(root) != NOT_BALANCED;
    }
private:
    int maxDepth(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }
        int left = maxDepth(root->left);
        int right = maxDepth(root->right);
        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }
        if (abs(left - right) > 1) {
            return NOT_BALANCED;
        }
        return max(left, right) + 1;

    }
};
