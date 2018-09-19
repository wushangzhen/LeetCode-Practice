/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */


class Solution {
public:
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    TreeNode * inorderSuccessor(TreeNode * root, TreeNode * p) {
        // write your code here
        TreeNode* successor = NULL;
        while (root != NULL && root != p) {
            if (root->val > p->val) {
                successor = root;
                root = root->left;
            } else {
                root = root->right;
            }
        }
        if (root == NULL) {
            return NULL;
        }
        if (root->right == NULL) {
            return successor;
        } else {
           root = root->right; 
           while (root->left) {
               root = root->left;
           }
        }
        return root;
    }
};
