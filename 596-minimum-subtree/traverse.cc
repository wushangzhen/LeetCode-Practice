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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    TreeNode * findSubtree(TreeNode * root) {
        // write your code here
        TreeNode* result = NULL;
        int min = INT_MAX;
        searchTree(root, min, &result);
        return result;
    }
    int searchTree(TreeNode* root, int& min, TreeNode** result) { // This is the point
        if (root == NULL) {
            return 0;
        }
        int sum = searchTree(root->left, min, result) + searchTree(root->right, min, result)  + root->val;
        if (sum < min) {
            min = sum;
            *result = root; // This can change the result
        }
        return sum;
    }
};
