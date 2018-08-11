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
    bool isBST = true;
    TreeNode *maxNode, *minNode;
    ResultType(bool isBST) {
        this->isBST = isBST; // this pointer is requireable
        this->maxNode = NULL;
        this->minNode = NULL;
    }
};

class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    bool isValidBST(TreeNode *root) {
        ResultType* result = helper(root);
        return result->isBST;
    }
    
    ResultType* helper(TreeNode *root) {
        if (root == NULL) {
            return new ResultType(true);
        }
        
        ResultType* left = helper(root->left);
        ResultType* right = helper(root->right);
        
        if (!left->isBST || !right->isBST) {
            return new ResultType(false);
        }
        
        if (left->maxNode != NULL && left->maxNode->val >= root->val) {
            return new ResultType(false);
        }
        
        if (right->minNode != NULL && right->minNode->val <= root->val) {
            return new ResultType(false);
        }
        ResultType* result = new ResultType(true);
        result->minNode = left->minNode == NULL ? root : left->minNode;
        result->maxNode = right->maxNode == NULL ? root : right->maxNode;
        return result;
    }
};
