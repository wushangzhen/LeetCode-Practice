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
        if (lastNode != NULL) {
            lastNode->left = NULL;
            lastNode->right = root;
        }
        lastNode = root;
        TreeNode* right = root->right; // this is the point in case of next layer root changes
        flatten(root->left);
        flatten(right); 
    }
private:
    TreeNode* lastNode = NULL;
};
