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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    vector<int> closestKValues(TreeNode * root, double target, int k) {
        // write your code here
        vector<int> result;
        multimap<double, int> treeMap;
        if (root == NULL) {
            return result;
        }
        inorderTraverse(root, target, treeMap);
        auto it = treeMap.begin(); 
        for (;it != treeMap.end() && result.size() < k; it++) {
            result.push_back(it->second);
        }
        return result;
    }
    void inorderTraverse(TreeNode* root, double target, multimap<double, int> &treeMap) {
        if (root == NULL) {
            return;
        }
        inorderTraverse(root->left, target, treeMap);
        treeMap.insert(make_pair(abs(root->val - target), root->val));
        inorderTraverse(root->right, target, treeMap);
    }
};
