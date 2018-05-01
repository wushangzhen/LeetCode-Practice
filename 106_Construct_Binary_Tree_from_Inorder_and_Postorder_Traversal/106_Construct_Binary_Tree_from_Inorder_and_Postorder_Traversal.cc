#include <iostream>
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int rootPos = postorder.size() - 1;
        return helper(inorder, 0, inorder.size() - 1, postorder, rootPos);
    }

private:
    TreeNode* helper(vector<int>& inorder, int l, int r, vector<int>& postorder, int& end) {
        if(l > r || end < 0)    return nullptr;

        int rootVal = postorder[end];
        int rootIndex = find(inorder.begin() + l, inorder.begin() + r, rootVal) - inorder.begin();

        TreeNode* root = new TreeNode(rootVal);

        end --;
        root->right = helper(inorder, rootIndex + 1, r, postorder, end);
        root->left = helper(inorder, l, rootIndex - 1, postorder, end);
        return root;
    }
