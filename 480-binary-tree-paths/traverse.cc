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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    vector<string> binaryTreePaths(TreeNode * root) {
        // write your code here
        vector<string> results;
        if (root == NULL) {
            return results;
        }
        string str = "";
        backTrace(root, str, results);
        return results;
    }
    void backTrace(TreeNode* root, string str, vector<string>& results) {
        if (root == NULL) {
            return;
        }
        if (root && root->right == NULL && root->left == NULL) {
            stringstream ss;
            ss << str;
            ss << root->val;
            ss >> str;
            results.push_back(str);
            return;
        }
        stringstream ss;
        ss << str;
        ss << root->val << "->";
        ss >> str;
        backTrace(root->left, str, results);
        backTrace(root->right, str, results);
    }
};
