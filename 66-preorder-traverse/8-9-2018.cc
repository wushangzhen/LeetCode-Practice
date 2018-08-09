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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    void traverse(TreeNode *root, vector<int> &vec_res) {
        if (root == NULL) {
            return;
        }
        vec_res.push_back(root->val);
        traverse(root->left, vec_res);
        traverse(root->righti, vec_res);

        }
    vector<int> preorderTraversal(TreeNode * root) {
        // write your code here
        vector<int> vec_res;
        traverse(root, vec_res);
        return vec_res;
    }
};
