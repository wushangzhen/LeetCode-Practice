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
     * @param root: The root of binary tree
     * @return: An integer
     */
    int minDepth(TreeNode * root) {
        // write your code here
        if (root == NULL) {
            return 0;
        }
        return helper(root);
    }
    int helper(TreeNode* root) {
        int left = INT_MAX;
        int right = INT_MAX;
        if (root->left) {
            left = helper(root->left);
        }
        if (root->right) {
            right = helper(root->right);
        }
        if (!root->left && !root->right) {
            return 1;
        }
        return std::min(left, right) + 1;
    }
};
