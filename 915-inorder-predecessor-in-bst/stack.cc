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
    TreeNode * inorderPredecessor(TreeNode * root, TreeNode * p) {
        // write your code here
        if (root == NULL || p == NULL) {
            return NULL;
        }
        stack<TreeNode*> stk;
        TreeNode* cur = root;
        TreeNode* last = NULL;
        while (cur != NULL || !stk.empty()) {
            while (cur != NULL) {
                stk.push(cur);
                cur = cur->left;
            }
            cur = stk.top();
            stk.pop();
            if (cur == p) {
                return last;
            } else {
                last = cur;
            }
            cur = cur->right;
        }
        return NULL;
    }
};
