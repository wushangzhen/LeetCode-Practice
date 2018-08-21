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
        vector<string> leftPaths = binaryTreePaths(root->left);
        vector<string> rightPaths = binaryTreePaths(root->right);
        stringstream ss;
        string str;
        ss << root->val;
        ss >> str;
        for (string path : leftPaths) {
            results.push_back(str + "->" + path);
        }
        for (string path : rightPaths) {
            results.push_back(str + "->" + path);
        }
        if (results.size() == 0) {
            results.push_back("" + str);
        }
        return results;
    }
};
