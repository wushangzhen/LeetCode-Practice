/**
 * Definition of ParentTreeNode:
 * class ParentTreeNode {
 * public:
 *     int val;
 *     ParentTreeNode *parent, *left, *right;
 * }
 */


class Solution {
public:
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    ParentTreeNode * lowestCommonAncestorII(ParentTreeNode * root, ParentTreeNode * A, ParentTreeNode * B) {
        // write your code here
        vector<ParentTreeNode*> APath = nodeToRoot(A);
        vector<ParentTreeNode*> BPath = nodeToRoot(B);
        int indexA = APath.size() - 1;
        int indexB = BPath.size() - 1;
        ParentTreeNode* lowestCommonAncestor = NULL;
        while (indexA >= 0 && indexB >= 0) {
            if (APath[indexA] != BPath[indexB]) {
                break;
            }
            lowestCommonAncestor = APath[indexA];
            indexA--;
            indexB--;
        }
        return lowestCommonAncestor;
    }
    vector<ParentTreeNode*> nodeToRoot(ParentTreeNode* node) {
        vector<ParentTreeNode*> result;
        while (node != NULL) {
            result.push_back(node);
            node = node->parent;
        }
        return result;
    }
};
