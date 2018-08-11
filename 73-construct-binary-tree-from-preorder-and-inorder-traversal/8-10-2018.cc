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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    TreeNode * buildTree(vector<int> &preorder, vector<int> &inorder) {
        // write your code here
        if (preorder.empty() || inorder.empty()) {
            return NULL;
        }
        int len = preorder.size() - 1;
        int start = 0;
        TreeNode* res = helper(preorder, inorder, 0, len, start);
        return res;
    }
private:
    TreeNode* helper(vector<int> &preorder, vector<int> &inorder, int left, int right, int &start) {
        if (left > right || start == preorder.size()) {
            return NULL;
        }
        int rootVal = preorder[start];
        int rootIndex = find(inorder.begin() + left, inorder.begin() + right, rootVal) - inorder.begin();
        TreeNode* root = new TreeNode(rootVal);
        start++;
        root->left = helper(preorder, inorder, left, rootIndex - 1, start);
        root->right = helper(preorder, inorder, rootIndex + 1, right, start);
        return root;
    }
};
