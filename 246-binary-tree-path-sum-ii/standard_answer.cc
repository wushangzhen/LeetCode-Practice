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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    vector<vector<int>> binaryTreePathSum2(TreeNode * root, int target) {
        // write your code here
        vector<vector<int>> result;
        vector<int> vec;
        helper(root, target, 0, vec, result);
        return result;
    }
    void helper(TreeNode* root, int sum, int level, vector<int>& vec, vector<vector<int>>& results) {
        if (root == NULL) {
            return;
        }
        vec.push_back(root->val);
        int tmp = sum;
        for (int i = level; i >= 0; i--) {
            tmp -= vec[i];
            if (tmp == 0) {
                vector<int> temp;
                for (int j = i; j <= level; j++) {
                    temp.push_back(vec[j]);
                }
                results.push_back(temp);
            }
        }
        helper(root->left, sum, level + 1, vec, results);
        helper(root->right, sum, level + 1, vec, results);
        vec.pop_back();
    }
};
