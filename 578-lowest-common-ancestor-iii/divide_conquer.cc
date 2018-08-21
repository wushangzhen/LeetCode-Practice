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
class ResultType {
public:
    bool a_exist, b_exist;
    TreeNode* node;
    ResultType(bool a_exist, bool b_exist, TreeNode* node) {
        this->a_exist = a_exist;
        this->b_exist = b_exist;
        this->node = node;
    }
    
};

class Solution {
public:
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    TreeNode * lowestCommonAncestor3(TreeNode * root, TreeNode * A, TreeNode * B) {
        // write your code here
        ResultType* result = helper(root, A, B);
        if (result->a_exist && result->b_exist) {
            return result->node;
        } else {
            return NULL;
        }
    }
    ResultType* helper(TreeNode* root, TreeNode* A, TreeNode* B) {
        if (root == NULL) {
            return new ResultType(false, false, NULL);
        }
        ResultType* left_rt = helper(root->left, A, B);
        ResultType* right_rt = helper(root->right, A, B);
        bool a_exist = left_rt->a_exist || right_rt->a_exist || A == root;
        bool b_exist = left_rt->b_exist || right_rt->b_exist || B == root;
        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt->node != NULL && right_rt->node != NULL) {
            return new ResultType(a_exist, b_exist, root);
        }
        if (left_rt->node != NULL) {
            return new ResultType(a_exist, b_exist, left_rt->node);
        }
        if (right_rt->node != NULL) {
            return new ResultType(a_exist, b_exist, right_rt->node);
        }
        return new ResultType(a_exist, b_exist, NULL);
    }
};
