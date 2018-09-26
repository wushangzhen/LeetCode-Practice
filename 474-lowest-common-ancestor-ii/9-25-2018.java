/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        ArrayList<ParentTreeNode> aPath = nodeToRoot(A);
        ArrayList<ParentTreeNode> bPath = nodeToRoot(B);
        int i = aPath.size() - 1;
        int j = bPath.size() - 1;
        ParentTreeNode result = root;
        while (i >= 0 && j >= 0) {
            if (aPath.get(i) != bPath.get(j)) {
                break;
            }
            result = aPath.get(i);
            i--;
            j--;
        }
        return result;
    }
    
    ArrayList<ParentTreeNode> nodeToRoot(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
