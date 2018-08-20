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
        TreeNode* lowerNode = lowerBound(root, target);
        TreeNode* upperNode = upperBound(root, target);
        if (lowerNode == NULL) {
            return upperNode->val;
        }
        if (upperNode == NULL) {
            return lowerNode->val;
        }
        if (target - lowerNode->val > upperNode->val - target) {
            return upperNode->val;
        }
        return lowerNode->val;
    }
    TreeNode* lowerBound(TreeNode* root, double target) {
        if (root == NULL) {
            return NULL;
        }
        if (target <= root->val) {
            return lowerBound(root->left, target);
        }
        TreeNode* lowerNode = lowerBound(root->right, target);
        if (lowerNode != NULL) {
            return lowerNode;
        }
        return root;
    }
    TreeNode* upperBound(TreeNode* root, double target) {
        if (root == NULL) {
            return NULL;
        }
        if (target > root->val) {
            return upperBound(root->right, target);
        }
        TreeNode* upperNode = upperBound(root->left, target);
        if (upperNode != NULL) {
            return upperNode;
        }
        return root;
    }
};
