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
    TreeNode* minSubtree;
    int sum, minSum;
    ResultType(TreeNode* minSubtree, int sum, int minSum) {
        this->minSubtree = minSubtree;
        this->sum = sum;
        this->minSum = minSum;
    }
};
class Solution {
public:
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    TreeNode * findSubtree(TreeNode * root) {
        // write your code here
        ResultType* result = helper(root);
        return result->minSubtree;
    }
    ResultType* helper(TreeNode* node) {
        if (node == NULL) {
            return new ResultType(NULL, INT_MAX, 0);
        }
        ResultType* leftResult = helper(node->left);
        ResultType* rightResult = helper(node->right);
        ResultType* result1 = new ResultType(node, leftResult->sum + rightResult->sum + node->val, leftResult->sum + rightResult->sum + node->val);
        ResultType** result = &result1;
        if (leftResult->minSum <= (*result)->minSum) {
            (*result)->minSum = leftResult->minSum;
            (*result)->minSubtree = leftResult->minSubtree;
        }
        if (rightResult->minSum <= (*result)->minSum) {
            (*result)->minSum = rightResult->minSum;
            (*result)->minSubtree = rightResult->minSubtree;
        }
        cout << *result << endl;
        return *result;
        
    }
};
// because of the pointer value change problem
