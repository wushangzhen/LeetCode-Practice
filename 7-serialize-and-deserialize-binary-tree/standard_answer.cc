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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    string serialize(TreeNode * root) {
        // write your code here
        vector<TreeNode*> vec;
        vec.push_back(root);
        for (int i = 0; i < vec.size(); i++) {
            TreeNode *node = vec[i];
            if (node == NULL) {
                continue;
            }
            vec.push_back(node->left);
            vec.push_back(node->right);
        }
        while (vec.size() > 0 && vec[vec.size() - 1] == NULL) {
            vec.pop_back();
        }
        if (vec.size() == 0) {
            return "{}";
        }
        stringstream ss;
        ss << "{" << vec[0]->val;
        for (int i = 1; i < vec.size(); i++) {
            if (vec[i] == NULL) {
                ss << ",#";
            } else {
                ss << "," << vec[i]->val;
            }
        }
        ss << "}"; 
        return ss.str();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    TreeNode * deserialize(string &data) {
        // write your code here
        if (data == "{}") {
            return NULL;
        }
        vector<string> vals = split(data.substr(1, data.size() - 2), ",");
        TreeNode *root = new TreeNode(atoi(vals[0].c_str()));
        queue<TreeNode*> q;
        q.push(root);
        bool isLeftChild = true;
        for (int i = 1; i < vals.size(); i++) {
            if (vals[i] != "#") {
                TreeNode* node = new TreeNode(atoi(vals[i].c_str()));
                if (isLeftChild) {
                    q.front()->left = node;
                } else {
                    q.front()->right = node;
                }
                q.push(node);
            }
            if (!isLeftChild) {
                q.pop();
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
    vector<string> splilt(const string &str, string delim) {
        vector<string> results;
        int lastIndex = 0;
        string::size_type index;
        while (index = str.find(delim, lastIndex) != string::npos) {
            results.push_back(str.substr(lastIndex, int(index) - lastIndex));
            lastIndex = index + delim.length();
        }
        if (lastIndex != str.length()) {
            results.push_back(str.substr(lastIndex, str.length() - lastIndex));
        }
        return results;
    }
};
