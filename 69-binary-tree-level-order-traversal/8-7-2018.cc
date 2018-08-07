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
     * @return: Level order a list of lists of integer
     */
    vector<vector<int>> levelOrder(TreeNode * root) {
        // write your code here
        vector<vector<int>> vec_res;
        if (root == NULL) {
            return vec_res;
        }
        queue<TreeNode*> que;
        que.push(root);
        while (!que.empty()) {
            int size = que.size();
            vector<int> vec;
            for (int i = 0; i < size; i++) {
                auto node = que.front();
                vec.push_back(node->val); 
                que.pop();
                if (node->left != NULL) {
                que.push(node->left);
                }
                if (node->right != NULL) {
                que.push(node->right);
                }
            }
            vec_res.push_back(vec);
        }
        return vec_res;
    }
};
