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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    void flatten(TreeNode * root) {
        // write your code here
        if (root == NULL) {
            return;
        }
        preorderSearch(root);
    }
    TreeNode* preorderSearch(TreeNode* root) {
        if (root == NULL) {
            return NULL;
        }
        TreeNode* leftLast = preorderSearch(root->left);
        TreeNode* rightLast = preorderSearch(root->right);
        if (leftLast != NULL) {
            leftLast->right = root->right;
            root->right = root->left;
            root->left = NULL;
        }
        if (rightLast != NULL) {
            return rightLast;
        }
        if (leftLast != NULL) {
            return leftLast;
        }
        return root;
    }
};
