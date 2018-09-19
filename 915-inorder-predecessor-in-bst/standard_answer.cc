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
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    TreeNode* predecessor;
    TreeNode * inorderPredecessor(TreeNode * root, TreeNode * p) {
        // write your code here
        if (root == NULL || p == NULL) {
            return NULL;
        }
        traverse(root, p);
        return predecessor;
    }
    void traverse(TreeNode* root, TreeNode* p) {
        if (root == NULL) {
            return;
        }
        traverse(root->left, p);
        if (root == p) {
            if (root->left) {
                predecessor = root->left;
            }
            return;
        }
        
        if (root->val < p->val) {
            predecessor = root;
            traverse(root->right, p);
        }
    }
};
