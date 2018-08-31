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
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    vector<ListNode*> binaryTreeToLists(TreeNode* root) {
        // Write your code here
        vector<ListNode*> results;
        if (root == NULL) {
            return results;
        }
        queue<TreeNode*> que;
        que.push(root);
        while (!que.empty()) {
            int size = que.size();
            ListNode* dummy = new ListNode(0); 
            ListNode* tail = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode* top = que.front();
                que.pop();
                tail->next = new ListNode(top->val); 
                tail = tail->next;
                if (top->left != NULL) {
                    que.push(top->left);
                }
                if (top->right != NULL) {
                    que.push(top->right);
                }
            }
            results.push_back(dummy->next);
        }
        return results;
        
    }
};
