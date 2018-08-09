#include <vector>
using namespace std;

//Definition of TreeNode:
class TreeNode {
public:
    int val;
    TreeNode *left, *right;
    TreeNode(int val) {
        this->val = val;
        this->left = this->right = NULL;
    }
};


class Solution {
public:
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    TreeNode * buildTree(vector<int> &inorder, vector<int> &postorder) {
        // write your code here
        if (inorder.empty() || postorder.empty()) {
            return NULL;
        }
        int len = postorder.size() - 1;
        TreeNode* res = helper(inorder, postorder, 0, len, len);
        return res;
    }
private:
    TreeNode* helper(vector<int> &inorder, vector<int> &postorder, int left, int right, int &end) {
        if (left > right || end < 0) {
            return NULL;
        }
        int rootVal = postorder[end];
        int rootIndex = find(inorder.begin() + left, inorder.begin() + right, rootVal) - inorder.begin();
        TreeNode* root = new TreeNode(rootVal);
        end--;
        root->right = helper(inorder, postorder, rootIndex + 1, right, end);
        root->left = helper(inorder, postorder, left, rootIndex - 1, end);
        return root;
    }
};
