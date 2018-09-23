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
     TreeNode node;
     ResultType(boolean existed, TreeNode node) {
         this.existed = existed;
         this.node = node;
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
        if (A == null || B == null) {
            return null;
        }
        if (root == A) {
            return A;
        }
        if (root == B) {
            return B;
        }
        ResultType result = helper(root, A, B);
        return result.node;
    }
    ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, null);
        }
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        if (left.existed && right.existed) {
            return new ResultType(true, root);
        }

        if (left.node != null) {
            return new ResultType(true, left.node);
        }
        if (right.node != null) {
            return new ResultType(true, right.node);
        }
        if (root == A) {
            if (left.existed || right.existed) {
                return new ResultType(true, root);
            } else {
                return new ResultType(true, null);
            }
        }
        if (root == B) {
            if (left.existed || right.existed) {
                return new ResultType(true, root);
            } else {
                return new ResultType(true, null);
            }
        }
        if (left.existed) {
            return new ResultType(true, null);
        }
        if (right.existed) {
            return new ResultType(true, null);
        }
        return new ResultType(false, null);
    }
}
