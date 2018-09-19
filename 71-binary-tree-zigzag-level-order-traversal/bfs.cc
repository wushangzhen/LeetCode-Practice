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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    vector<vector<int>> zigzagLevelOrder(TreeNode * root) {
        // write your code here
        vector<vector<int>> results;
        if (!root) {
            return results;
        }
        stack<TreeNode*> stk1;
        stack<TreeNode*> stk2;
        stk1.push(root);
        bool leftToRight = true;
        while (!stk1.empty()) {
            int size = stk1.size();
            vector<int> result;
            for (int i = 0; i < size; i++) {
                TreeNode* top = stk1.top();
                stk1.pop();
                result.push_back(top->val);
                if (leftToRight) {
                    if (top->left) {
                        stk2.push(top->left);
                    }
                    if (top->right) {
                        stk2.push(top->right);
                    }
                } else {
                    if (top->right) {
                        stk2.push(top->right);
                    }
                    if (top->left) {
                        stk2.push(top->left);
                    }
                }
            }
            leftToRight = !leftToRight;
            results.push_back(result);
            stack<TreeNode*> tempStk = stk1;
            stk1 = stk2;
            stk2 = tempStk;
        }
        return results;
    }
};
