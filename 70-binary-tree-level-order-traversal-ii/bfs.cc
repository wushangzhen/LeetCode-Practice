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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    vector<vector<int>> levelOrderBottom(TreeNode * root) {
        // write your code here
        vector<vector<int>> results;
        if (!root) {
            return results;
        }
        queue<TreeNode*> que;
        que.push(root);
        while (!que.empty()) {
            int size = que.size();
            vector<int> result;
            for (int i = 0; i < size; i++) {
                TreeNode* top = que.front();
                que.pop();
                result.push_back(top->val);
                if (top->left) {
                    que.push(top->left);
                }
                if (top->right) {
                    que.push(top->right);
                }
            }
            results.push_back(result);
        }
        reverse(results.begin(), results.end());
        return results;
    }
};
