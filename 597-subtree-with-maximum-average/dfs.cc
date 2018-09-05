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
    int size;
    int sum;
    //ResultType() : size(0), sum(0) {}
    ResultType(int size, int sum) {
        this->size = size;
        this->sum = sum;
    }
 };

class Solution {
public:
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    TreeNode * findSubtree2(TreeNode * root) {
        // write your code here
        helper(root);
        return node;
    }
    ResultType helper(TreeNode* root) {
        if (root == NULL) {
            return ResultType(0, 0);
        }
        ResultType left = helper(root->left);
        ResultType right = helper(root->right);
        ResultType result = ResultType(left.size + right.size + 1, left.sum + right.sum + root->val);
        if (node == NULL || result.sum * data.size > data.sum * result.size) {
            node = root;
            data = result;
        }
        return result;
    }
private:
    TreeNode* node = NULL;
    ResultType data = ResultType(0, 0);
};
