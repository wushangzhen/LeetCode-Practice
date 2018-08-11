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
    TreeNode* minNode;
    TreeNode* maxNode;
    ResultType(bool isBST) {
        isBST = isBST;
        minNode = NULL;
        maxNode = NULL;
    }
};

class Solution {
public:
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    bool isValidBST(TreeNode * root) {
        // write your code here
        return divideConquer(root)->isValidBST;
    }
private:
    ResultType* divideConquer(TreeNode* root) {
        if (root == NULL) {
         return new ResultType(true);
        } 
        ResultType* left = divideConquer(root->left);
        ResultType* right = divideConquer(root->right);
        if (!left->isValidBST || !right->isValidBST) {
            return new ResultType(false);
        }
        if (left->maxNode != NULL && left->maxNode->val >= root->val) {
            return new ResultType(false);
        }
        if (right->minNode != NULL && right->minNode->val <= root->val) {
            return new ResultType(false);
        }
        ResultType* result = new ResultType(true);
        result->minNode = left->minNode != NULL ? left->minNode : root;
        result->maxNode = right->maxNode != NULL ? right->maxNode : root;
        return result;
    }
};

