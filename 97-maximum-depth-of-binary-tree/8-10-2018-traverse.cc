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
     * @return: An integer
     */
    int depth = 0;
    int maxDepth(TreeNode * root) {
        // write your code here
        traverse(root, 1);
        return depth;
    }
private:
    void traverse(TreeNode* root, int currentDepth) {
        if (root == NULL) {
            return;
        }
        depth = max(depth, currentDepth);
        traverse(root->left, currentDepth + 1);
        traverse(root->right, currentDepth + 1);
    }
};
