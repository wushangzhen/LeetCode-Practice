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
        vector<TreeNode*> vec;
        traverse(root, p, vec);
        int count = 0;
        for (auto node : vec) {
           if (node != p) {
               count++;
           } else {
               break;
           } 
        }
        if (count == 0) {
            return NULL;
        }
        return vec[count - 1];
    }
    void traverse(TreeNode* root, TreeNode* p, vector<TreeNode*>& vec) {
        if (root == NULL) {
            return;
        }
        traverse(root->left, p, vec);
        vec.push_back(root);
        traverse(root->right, p, vec);
    }
};
