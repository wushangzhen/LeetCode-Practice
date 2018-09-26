/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

class ResultType {
    boolean existed;
    TreeNode ancestor;
    ResultType(boolean existed, TreeNode ancestor) {
        this.existed = existed;
        this.ancestor = ancestor;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (A == null || B == null) {
            return null;
        }
        ResultType result = helper(root, A, B);
        return result.ancestor;
    }
    ResultType helper(TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return new ResultType(false, null);
        }
        if (node == A && node == B) {
            return new ResultType(true, node);
        }
        ResultType left = helper(node.left, A, B);
        ResultType right = helper(node.right, A, B);
        if (left.ancestor != null) {
            return left;
        }
        if (right.ancestor != null) {
            return right;
        }
        if (left.existed || right.existed) {
            if (node == A || node == B) {
                return new ResultType(true, node);
            }
            if (left.existed && right.existed) {
                return new ResultType(true, node);
            }
            return new ResultType(true, null);
        }
        if (node == A || node == B) {
            return new ResultType(true, null);
        } 
        return new ResultType(false, null);
    }
}
