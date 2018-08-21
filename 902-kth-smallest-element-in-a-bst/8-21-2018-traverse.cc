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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    int kthSmallest(TreeNode * root, int k) {
        // write your code here
        if (root == NULL) {
            return -1;
        }
        vector<int> vec;
        inorderTraverse(root, vec);
        return vec[k - 1];
    }
    void inorderTraverse(TreeNode* root, vector<int>& vec) {
        if (root == NULL) {
            return;
        }
        inorderTraverse(root->left, vec);
        vec.push_back(root->val);
        inorderTraverse(root->right, vec);
    }
};
