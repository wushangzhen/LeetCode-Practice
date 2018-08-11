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
     * @return: True if the binary tree is BST, or false
     */
    bool isValid = true;
    TreeNode* lastNode = NULL;
    bool isValidBST(TreeNode * root) {
        // write your code here
        inorderTraverse(root, NULL);
        return isValid;
    }
private:
    void traverse(TreeNode* root) {
        if (root == NULL) {
            return;
        }
        traverse(root->left);
        if (lastNode != NULL && lastNode->val > root->val) {
            isValid = false;
            return;
        }
        lastNode = root;
        traverse(root->right);
    }
   
};
