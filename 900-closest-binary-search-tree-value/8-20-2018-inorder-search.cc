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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    int closestValue(TreeNode * root, double target) {
        // write your code here
        double diff = abs(double(root->val) - target);
        int result = root->val;
        inOrderSearch(root, diff, target, result);
        return result;
    }
    void inOrderSearch(TreeNode* root, double &diff, double &target, int &result) {
        if (!root) {
            return;
        }
        inOrderSearch(root->left, diff, target, result);
        if (diff > abs(double(root->val) - target)) {
            result = root->val;
            diff = abs(double(root->val) - target);
        }
        inOrderSearch(root->right, diff, target, result);
    }
};

